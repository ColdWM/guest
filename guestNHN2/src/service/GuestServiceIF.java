package service;

import java.util.ArrayList;

import dto.Guest;

public interface GuestServiceIF {

	public abstract ArrayList<Guest> getGuests();
	public abstract void insert(Guest guest);
	public abstract void update(Guest guest);
	public abstract Guest getGuest(String guestId);
	public abstract boolean PACheck(Guest guest);
	
}
