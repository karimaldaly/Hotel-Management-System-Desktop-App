
package Database_Classes;

import System_Classes.ClientInfo;
import java.sql.*;
import javax.swing.JOptionPane;


public class Client_DB {
    
    
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    
    
    public Client_DB()
    {
        conn = Connection_DB.connectTODB();
    }
    public void insertClient(ClientInfo user)  {
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

            JOptionPane.showMessageDialog(null, "successfully inserted new Client");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery Failed");
        }
        finally
        {
            CloseStatementOnly();
        }
        
        
    }
    
    public void updateClient(ClientInfo user) {
      
        try {
            String updateQuery = "update client set name = '"
                    + user.getName() + "',"
                    + "address = '" + user.getAddress() + "',"
                    + "phone = '" + user.getPhone_no() + "',"
                    + "type = '" + user.getType() + "' where client_id= "
                    + user.getClient_id();

            
            statement = conn.prepareStatement(updateQuery);

          
            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully updated new Client");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        
        finally
        {
            CloseStatementOnly();
        }

    }

    public void deleteClient(int userId) throws SQLException {
        try {
            String deleteQuery = "delete from Client where Client_id=" + userId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Deleted Client");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Delete query Failed");
        }
        finally
        {
            CloseStatementOnly();
        }

    }

    public ResultSet getAllClient() {
        try {
            String query = "select * from Client";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all CLient DB Operation");
        }
        

        return result;
    }
    
    private void CloseStatementOnly()
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

    
    
    
}
