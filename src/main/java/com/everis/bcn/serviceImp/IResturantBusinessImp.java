package com.everis.bcn.serviceImp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.bcn.model.BookingAssembler;
import com.everis.bcn.model.DaoByDto;
import com.everis.bcn.dao.AbstractDao;
import com.everis.bcn.daoImp.BookingDAOImp;
import com.everis.bcn.daoImp.MesaDAOImp;
import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.dto.Dto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.model.MessageString;
import com.everis.bcn.model.ModdelMapperConfig;
import com.everis.bcn.service.IResturantBusiness;

/**
 * 
 * @author J Michael
 *
 */
@Service
public class IResturantBusinessImp implements IResturantBusiness {

	@Autowired private BookingDAOImp bookinDao;
	@Autowired private RestaurantDAOImp restaurantDao;
	@Autowired private MesaDAOImp mesaDao;
	@Autowired private AbstractDao<Turn> turnDao;

	@Autowired private MessageString messageString;
	@Autowired private BookingAssembler bookingAssembler;
	@Autowired private ModdelMapperConfig moddelMapperConfig;
	@Autowired private DaoByDto daoByDto;
	
	private Set<Mesa> listaMesasOfRestaurant;
	private Set<Mesa> listaMesasOfTurn;
	
	/**
	 * inject Entity class in Dao
	 */
	@Autowired
	public void setDao() {
		bookinDao.setClazz(Booking.class);
		restaurantDao.setClazz(Restaurant.class);
		turnDao.setClazz(Turn.class);
		bookinDao.setClazz(Booking.class);
	}

	@Override
	public boolean editBooking(Booking booking) {
		return false;
	}

	@Override
	public boolean cancelBooking(Booking bookingFromDto) {
		boolean resp = true;
		Booking booking_cancel_aux = bookinDao.get(bookingFromDto.getLocalizador());
		
		if (booking_cancel_aux == null || !bookingFromDto.equals(booking_cancel_aux)) resp = false;
		else bookinDao.delete(booking_cancel_aux.getBookingId());
		
		return resp;
	}

	@Override
	public boolean reserve(Booking booking) {
		boolean resp = true;
		
		List<Mesa> listMesasWithAvailableCapacity = listaMesasOfRestaurant
				.stream()
				.filter(mesa -> (!listaMesasOfTurn.contains(mesa) && booking.getPersonas() <= mesa.getCapacity()))
				.collect(Collectors.toList());

		booking.setMesa(!listMesasWithAvailableCapacity.isEmpty() ? listMesasWithAvailableCapacity.get(0) : null);

		if (booking.getMesa() != null) {
			booking.setLocalizador(generateLocalizator(booking));
			bookinDao.save(booking);
			
		} else resp = false;

		return resp;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restaurantDao.save(restaurant);
	}

	@Override
	public Set<Restaurant> getRestaurants() {
		return restaurantDao.getAll();
	}

	@Override
	public Set<Turn> getTurns() {
		return turnDao.getAll();
	}

	@Override
	public Set<Booking> getBookings() {
		return bookinDao.getAll();
	}

	/********* Generated methods ************/

	/**
	 * generate Localizator
	 * 
	 * @param booking
	 * @return
	 */
	private long generateLocalizator(Booking booking) {
		return Long.parseLong("" + booking.getRestaurant().getRestaurantId() + booking.getMesa().getId()
				+ +booking.getTurn().getTurnId()
				+ MessageString.getFormat().format(booking.getDay()).replaceAll("-", ""));
	}

	/***
	 * message By Register Booking
	 * r
	 * @param dto
	 * @return
	 */
	public String manageReserve(Dto dto) {
		listaMesasOfRestaurant = new HashSet<Mesa>();
		listaMesasOfTurn = new HashSet<Mesa>();
		messageString.setSuccess_booking(new StringBuilder());
		
		dto.setDaoByDto(daoByDto);
		Booking booking = bookingAssembler.getBookingFromDto(dto, moddelMapperConfig.getModelMapperBooking());
		listaMesasOfRestaurant = mesaDao.getMesasIdOfTheRestaurant(booking.getRestaurant().getRestaurantId());
		listaMesasOfTurn = bookinDao.getMesasOfTheTurn(booking);
		
		return areThereMesaAvailable(booking) ? 
				isThereCapacityAvailable(booking) ? messageString.getSuccess_booking().append(reserveDetail(booking)).toString() : MessageString.getFailedCapacity() 
						: MessageString.getFailedMesas();
	}

	/***
	 * return boolean of table available by turn in restaurant
	 * r1
	 * @param booking
	 * @return
	 */
	public boolean areThereMesaAvailable(Booking booking) {
		return listaMesasOfRestaurant.stream()
				.filter(mesa -> (!listaMesasOfTurn.contains(mesa)))
				.collect(Collectors.toList()).size() > 0;
	}
	
	/**
	 * return boolean of capacity available and reserve
	 * r2
	 * @return
	 */
	public boolean isThereCapacityAvailable(Booking booking) {
		List<Mesa> listMesasAvailablesCapacity = listaMesasOfRestaurant
				.stream()
				.filter(mesa -> (!listaMesasOfTurn.contains(mesa) && booking.getPersonas() <= mesa.getCapacity()))
				.collect(Collectors.toList());
		
		return listMesasAvailablesCapacity.size() > 0 ? reserve(booking) : false;
	}

	/**
	 * info detail string
	 * 
	 * @return
	 */
	private String reserveDetail(Booking booking) {
		return " detail : Codigo de Restaurant - " + booking.getRestaurant().getRestaurantId() + "\n" + "Mesa - "
				+ booking.getMesa().getId() + "\n" + "Day - " + MessageString.getFormat().format(booking.getDay())
				+ "\n" + "Turno - " + booking.getTurn().getTurnId() + "\n" + "Localizator : "
				+ booking.getLocalizador();
	}

	/***
	 * 
	 * @param dto
	 * @return
	 */
	public String manageCancelReserve(Dto dto) {
		listaMesasOfRestaurant = new HashSet<Mesa>();
		listaMesasOfTurn = new HashSet<Mesa>();
		
		dto.setDaoByDto(daoByDto);
		Booking booking = bookingAssembler.getBookingFromDto(dto, moddelMapperConfig.getModelMapperBookingCancel());
		return cancelBooking(booking) ? messageString.getSuccess_cancelBooking().toString()
				: messageString.getFailedCancel();
	}

}
