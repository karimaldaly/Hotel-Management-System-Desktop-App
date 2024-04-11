
package System_Classes;

import java.util.ArrayList;


public class Booking {
    

    private ClientInfo Client;
    ArrayList<RoomInfo> rooms;
      
    private int booking_id;
    private long checkInDate;
    private long checkOutDate;
    private String bookingType;
 
    
    
    public Booking()
    {
        Client = new ClientInfo();
        rooms = new ArrayList<>();
        booking_id = -1;
        bookingType = "Reserved";
        
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }
  
    
    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }
    
    public void addRoom(String roomNo)
    {
        rooms.add(new RoomInfo(roomNo));
        
    }
    
    public void removeRoom(String roomNo)
    {
        for(RoomInfo a: rooms)
        {
            if(a.getRoom_no().equals(roomNo))
            {
                rooms.remove(a);
            }
        }
    }


    public ArrayList<RoomInfo> getRooms() {
        return rooms;
    }
    
    public int getRoomsFare()
    {
        int total = 0;
        for(RoomInfo room:rooms)
        {
            total += room.getRoomPrice_class().getPricePerDay();
        }
        return total;
    }

    public ClientInfo getClient() {
        return Client;
    }

    public void setClient(ClientInfo Client) {
        this.Client = Client;
    }  

    public void setCheckOutDate(int checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public long getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(long checkInDate) {
        this.checkInDate = checkInDate;
    }

    public long getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(long checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

 
    
    
}
