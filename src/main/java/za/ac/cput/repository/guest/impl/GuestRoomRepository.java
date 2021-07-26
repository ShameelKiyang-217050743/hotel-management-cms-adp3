package za.ac.cput.repository.guest.impl;
/**
 * Student Number: 217050743
 * Author: Shameel Kiyang
 */
import za.ac.cput.entity.guest.GuestRoom;
import za.ac.cput.repository.guest.IGuestRoomRepository;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GuestRoomRepository implements IGuestRoomRepository{

    private static GuestRoomRepository guestRoomRepository= null;
    private List<GuestRoom> guestRoomDb = null;

    private GuestRoomRepository(){
        guestRoomDb = new ArrayList<GuestRoom>();
    }

    public static GuestRoomRepository getGuestRoomRepository(){

        if (guestRoomRepository == null)
            guestRoomRepository = new GuestRoomRepository();

        return guestRoomRepository;
    }

    @Override
    public GuestRoom create(GuestRoom x) {
        try {
            guestRoomDb.add(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public GuestRoom read(String s) {
        for (GuestRoom gue:guestRoomDb) {
            if (gue.getRoomNo() == s)
                return gue;
        }
        return null;
    }

    @Override
    public GuestRoom update(GuestRoom x, String s) {
        GuestRoom oldGuestRoom = read(x.getRoomNo());
        if (oldGuestRoom != null){
            guestRoomDb.remove(oldGuestRoom);
            guestRoomDb.add(x);
            return x;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        try {
            GuestRoom delGuestRoom = read(s);
            if (delGuestRoom != null)
                guestRoomDb.remove(delGuestRoom);
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
