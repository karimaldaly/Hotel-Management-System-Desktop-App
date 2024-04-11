
package Database_Classes;

import System_Classes.EmployeeInfo;
import java.sql.*;
import javax.swing.JOptionPane;


public class Employee_DB {
    
    
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    
    
    public Employee_DB()
    {
        conn = Connection_DB.connectTODB();
    }
      public void insertEmployee(EmployeeInfo user)  {
        try {
            String insertQuery = "insert into Employee"
                    + "('" + "name" + "'," + "'" + "address" + "','" + "phone" + "','" + "type" + "')"
                    + " values('"
                    + user.getName()
                    + "','" + user.getAddress() + "'"
                    + ",'" + user.getPhone_no() + "'"
                    + ",'" + user.getType() + "'"
                    + ")";

           
            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully inserted new Customer");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery Failed");
        }
        finally
        {
            CloseStatementOnly();
        }
        
        
    }
    
    public void updateEmployee(EmployeeInfo user) {
      
        try {
            String updateQuery = "update Employee set name = '"
                    + user.getName() + "',"
                    + "address = '" + user.getAddress() + "',"
                    + "phone = '" + user.getPhone_no() + "',"
                    + "type = '" + user.getType() + "' where Employee_id= "
                    + user.getClient_id();

            
            statement = conn.prepareStatement(updateQuery);

          
            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully updated new Employee");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        
        finally
        {
            CloseStatementOnly();
        }

    }

    public void deleteEmployee(int userId) throws SQLException {
        try {
            String deleteQuery = "delete from userInfo where Employee_id=" + userId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Deleted user");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Delete query Failed");
        }
        finally
        {
            CloseStatementOnly();
        }

    }

    public ResultSet getAllEmployee() {
        try {
            String query = "select * from Employee";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Employee DB Operation");
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
