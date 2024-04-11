
package Database_Classes;

import System_Classes.Food;
import java.sql.*;
import javax.swing.JOptionPane;
  

public class Food_DB {
    
    
    
    Connection conn = Connection_DB.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;
    
     public void insertFood(Food food) {
        try {
            String insertFood = "insert into food('name','price') values('" + food.getName() + "'," + food.getPrice() + ")";

          
            statement = conn.prepareStatement(insertFood);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully inserted a new Food Type");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery of Food Failed");
        }
        finally
        {
            CloseStatmentOnly();
        }
    }

    public ResultSet getFoods() {
        try {
            String query = "select * from food";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all food DB Operation");
        }
        

        return result;
    }

    public void updateFood(Food food) {
        try {
            String updateFood = "update food set name= '" + food.getName() + "', price= " + food.getPrice() + " where food_id = " + food.getFood_id();

         
            statement = conn.prepareStatement(updateFood);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully updateFood ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "updateFood of Food Failed");
        }
        finally
        {
            CloseStatmentOnly();
        }
    }

    public void deleteFood(int foodId) {
        try {
            String deleteQuery = "delete from food where food_id=" + foodId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Deleted food");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Delete query FOod Failed");
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
