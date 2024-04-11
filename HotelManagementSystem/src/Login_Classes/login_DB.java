
package Login_Classes;

import java.sql.*;
import javax.swing.JOptionPane;


public class login_DB {
    
  
    
    
    public login_DB(){
        
        
       
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0" , "root" , "");
            String sql = " select * from logindb where username=? and password=? ";
            PreparedStatement pre = Con.prepareStatement(sql);
//          pre.setString(1,username.getText());   jframe  username
//          pre.setString(2,password.getText());   jframe  password
            
            ResultSet rs = pre.executeQuery();
            
            if(rs.next()){
                
                JOptionPane.showMessageDialog(null, "username and password matched");
            }else {
                 JOptionPane.showMessageDialog(null, "username and password dont matched");
//                 username.setText("");     jframe  username
//                 password.setText("");     jframe  password
            }
            Con.close();
            
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null,e);
            
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
}
