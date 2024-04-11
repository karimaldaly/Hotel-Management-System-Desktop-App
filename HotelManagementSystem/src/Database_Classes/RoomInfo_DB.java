
package Database_Classes;


import System_Classes.RoomInfo;
import System_Classes.RoomPrice;
import java.sql.*;
import javax.swing.JOptionPane;



public class RoomInfo_DB {
    
    
  Connection conn = Connection_DB.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;

     public void insertRoom(RoomInfo room) {
        try {
            String insertQuery = "insert into room('room_no','bed_number','tv','wifi','gizer','phone','room_class')"
                    + " values('"
                    + room.getRoom_no()
                    + "'," + room.getBed_number() + ""
                    + ",'" + room.isHasTV() + "'"
                    + ",'" + room.isHasWIFI() + "'"
                    + ",'" + room.isHasGizer() + "'"
                    + ",'" + room.isHasPhone() + "'"
                    + ",'" + room.getRoomPrice_class().getRoom_type() + "'"
                    + ")";

            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully inserted a new Room ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery of Room Class Failed");
        }
        finally
        {
            CloseStatmentOnly();
        }
    }

    public ResultSet getRooms() {
        try {
            String query = "select * from room";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room DB Operation");
        }
        
        return result;
    }
    
    public int getNoOfRooms()
    {
        int rooms = -1;
        try {
            String query = "select count(room_no)  as noRoom from room";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            while(result.next())
            {
                rooms = result.getInt("noRoom");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming count Room DB Operation");
        }
        
        return rooms;
    }
    
    public ResultSet getAllRoomNames()
    {
         try {
            String query = "select room_no from room";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room_No  ROOM DB Operation");
        }
        
        return result;
    }

    public void deleteRoom(int roomId) {

        try {
            String deleteQuery = "delete from room where room_id=" + roomId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Deleted room");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Delete query room Failed");
        }
        finally
        {
            CloseStatmentOnly();
        }
    }
    
    public void updateRoom(RoomInfo room)
    {
         try {
            String updateQuery ="update room set room_no = '"
                    +room.getRoom_no()+"', bed_number="
                    +room.getBed_number()+", tv = '"
                    +boolToString(room.isHasTV())+"', wifi = '"
                    +boolToString(room.isHasWIFI())+"',gizer = '"
                    +boolToString(room.isHasGizer())+"', phone = '"
                    +boolToString(room.isHasPhone())+"', room_class= '"
                    +room.getRoomPrice_class().getRoom_type()+"', meal_id = "
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
           
            statement = conn.prepareStatement(updateQuery);

          
            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully updated a room");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
         finally
         {
             CloseStatmentOnly();
         }

    }

    public String boolToString(boolean value) {
        return value ? "true" : "false";
    }
    
    public void insertRoomType(RoomPrice roomType) {
        try {
            String insertRoomTypeQuery = "insert into roomType values('" + roomType.getRoom_type() + "'," + roomType.getPricePerDay() + ")";

            System.out.println(">>>>>>>>>> " + insertRoomTypeQuery);

            statement = conn.prepareStatement(insertRoomTypeQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully inserted a new Room Type");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery Failed");
        }
        finally
        {
            CloseStatmentOnly();
        }
    }

    public ResultSet getRoomType() {
        try {
            String query = "select * from roomType";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room Type DB Operation");
        }

        return result;
    }

    public void updateRoomType(RoomPrice roomType) {
        try {
            String updateRoomTypeQuery = "update roomType set price= " + roomType.getPricePerDay() + " where type='" + roomType.getRoom_type() + "'";

            statement = conn.prepareStatement(updateRoomTypeQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully updated a  Room Type");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "UpdateQuery Failed");
        }
        finally
        {
            CloseStatmentOnly();
        }
    }
    
    public void CloseAll()
    {
        {
                        try
                        {
                            statement.close();
                            result.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }
    
    private void CloseStatmentOnly()
    {
        {
                        try
                        {
                            statement.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }
    
    
    
    
}
