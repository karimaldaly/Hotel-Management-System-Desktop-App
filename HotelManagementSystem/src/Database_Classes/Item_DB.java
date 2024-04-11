
package Database_Classes;

import System_Classes.Item;
import java.sql.*;
import javax.swing.JOptionPane;

public class Item_DB {
    
    
    Connection conn = Connection_DB.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;
    
     public void insertItem(Item item) {
        try {
            String insertItem = "insert into item('name','description','price') values('" + item.getItem_name() + "','" + item.getDescription() + "'," + item.getPrice() + ")";

           
            statement = conn.prepareStatement(insertItem);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully inserted a new insertItem");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery of insertItem Failed");
        }
        finally
        {
            CloseStatmentOnly();
        }
    }

    public void updateItem(Item item) {
        try {
            String updateFood = "update food set name= '" + item.getItem_name() + "', price= " + item.getPrice() + "description = '" + item.getDescription() + "' where item_id = " + item.getItem_id();

         
            statement = conn.prepareStatement(updateFood);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully updateitem ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update Item failed");
        }
        finally
        {
            CloseStatmentOnly();
        }
    }

    public ResultSet getItems() {
        try {
            String query = "select * from item";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all item DB Operation");
        }

        return result;
    }

    public void deleteItem(int itemId) {
        try {
            String deleteQuery = "delete from item where item_id=" + itemId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Deleted item");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Delete query Item Failed");
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
