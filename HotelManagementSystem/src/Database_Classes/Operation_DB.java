
package Database_Classes;

import  System_Classes.*;
import java.sql.*;
import javax.swing.JOptionPane;


public class Operation_DB {
    
    
    Connection conn = Connection_DB.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;

    public void insertClient(ClientInfo user) throws SQLException {
        try {
            String insertQuery = "insert into client"
                    + "('" + "name" + "'," + "'" + "address" + "','" + "phone" + "','" + "type" + "')"
                    + " values('"
                    + user.getName()
                    + "','" + user.getAddress() + "'"
                    + ",'" + user.getPhone_no() + "'"
                    + ",'" + user.getType() + "'"
                    + ")";

         
            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully inserted new client");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery Failed");
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

    public void updateClient(ClientInfo user) {
      
        try {
            String updateQuery = "update client set name = '"
                    + user.getName() + "',"
                    + "address = '" + user.getAddress() + "',"
                    + "phone = '" + user.getPhone_no() + "',"
                    + "type = '" + user.getType() + "' where user_id= "
                    + user.getClient_id();

           
            statement = conn.prepareStatement(updateQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully updated new client");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }

    }

    public void deleteClient(int userId) throws SQLException {
        try {
            String deleteQuery = "delete from client where client_id=" + userId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Deleted client");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Delete query Failed");
        }
        finally
        {
            CloseStatmentOnly();
        }

    }

    public ResultSet getAllClient() {
        try {
            String query = "select * from client";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all client DB Operation");
        }
        finally
        {
            CloseAll();
        }

        return result;
    }


    
    
    
    public ResultSet searchClient(String user) {
        try {
            String query = "select client_id,name,address from userInfo where name like '%"+user+"%'";
            
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from search user function");
        }
     
        return result;
    }
    
    public ResultSet searchAnClient(int id)
    {
        try {
            String query = "select * from client where Client_id="+id;
            
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning AN user function");
        }
        
        return result;
    }

    public ResultSet getAvailableRooms(long check_inTime)
    {
       try {
           
        
            String query = "SELECT room_no FROM room LEFT OUTER JOIN booking ON room.room_no = booking.booking_room WHERE booking.booking_room is null or "+check_inTime+"< booking.check_in " +"or booking.check_out <"+check_inTime+" group by room.room_no  order by room_no ";
            System.out.println(query);
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning free rooms from getAvailable func.");
        }

      
        return result;
    }
    
    public ResultSet getBookingInfo(long start_date, long end_date,String roomNo)
    {
        try {
            
     
            String query = "select * from booking where booking_room = '"+ roomNo+"' AND ("
                    +"( check_in <= "+start_date +" and ( check_out = 0 or check_out<= "+end_date+") ) or"
                    +"( check_in >"+start_date+" and check_out< "+end_date+" ) or"
                    +"( check_in <= "+end_date +" and ( check_out =0 or check_out> "+end_date+") ) )";
                    
                    
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning booking info between two specific days");
        }
        

        return result;
    }
    
    public int getClientId(ClientInfo user)
    { int id = -1;
        try {
            String query = "select user_id from client where name='"+user.getName()+"' and phone ='"+user.getPhone_no()+"'";
            
            System.out.println(query +" <<<");
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
         
            
            id = result.getInt("user_id");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning AN user function");
        }
       
        return id;
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
