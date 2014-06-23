package service;

import java.util.ArrayList;

import dao.GuestDAO;
import dto.Guest;

public class GuestService implements GuestServiceIF {

	@Override
	public ArrayList<Guest> getGuests() {
		ArrayList<Guest> guestList = 
				GuestDAO.getInstance().getGuests();
		return guestList;
	}

}
