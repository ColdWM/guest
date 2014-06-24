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

	@Override
	public void insert(Guest guest) {
		GuestDAO.getInstance().insert(guest);
		//String guestText = guest.getguestText();
		//System.out.println(guestText);
	}

	@Override
	public void update(Guest guest) {
		GuestDAO.getInstance().update(guest);
		String guestText = guest.getguestText();
		System.out.println(guestText);
		
	}

	@Override
	public Guest getGuest(String guestId) {
		Guest guest = GuestDAO.getInstance().getGuest(guestId);
		return guest;
	}

	@Override
	public boolean PACheck(Guest guest) {
		boolean flag = false;
		flag = GuestDAO.getInstance().PACheck(guest);
		return flag;
	}

	
	
}
