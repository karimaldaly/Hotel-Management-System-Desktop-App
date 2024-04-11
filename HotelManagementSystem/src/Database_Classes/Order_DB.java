
package Database_Classes;

import System_Classes.Order;
import java.sql.*;
import javax.swing.JOptionPane;


public class Order_DB {
    
    
    
    Connection conn = Connection_DB.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;

    public void insertOrder(Order order) {
        try {
            String insertOrder = "insert into orderItem('booking_id','item_food','price','quantity','total') values(" + order.getBookingId() + ",'" + order.getFoodItem() + "'," + order.getPrice() + "," + order.getQuantity() + "," + order.getTotal() + ")";

            statement = conn.prepareStatement(insertOrder);
 
            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully inserted a new Order");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Order Failed");
        } finally {
            CloseStatmentOnly();
        }

    }

    public void CloseAll() {
        {
            try {
                statement.close();
                result.close();
            } catch (SQLException ex) {
                System.err.print(ex.toString() + " >> CLOSING DB");
            }
        }
    }

    private void CloseStatmentOnly() {
        {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.err.print(ex.toString() + " >> CLOSING DB");
            }
        }
    }
    
    
    
    
    
}
