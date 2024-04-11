
package Database_Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class Connection_DB {
    
     public static Connection connectTODB()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0" , "root" , "");
//            JOptionPane.showMessageDialog(null, "Connection Establishment");
            return Con;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            return null;
        }
        
        
    }
    
}
