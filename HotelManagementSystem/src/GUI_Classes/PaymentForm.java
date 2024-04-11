
package GUI_Classes;


import System_Classes.Order;
import Database_Classes.Booking_DB;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.text.JTextComponent;


public class PaymentForm extends javax.swing.JFrame {

    
    
    Booking_DB bookingdB = new Booking_DB();
    Vector<String> bookingList = new Vector();

    int bookingId = -1;
    ResultSet result;
 
    
    public PaymentForm() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combobox = new javax.swing.JComboBox<>();
        checkout = new javax.swing.JButton();
        payment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        print = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        combobox.setBackground(new java.awt.Color(0, 102, 102));
        combobox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        combobox.setForeground(new java.awt.Color(255, 255, 255));
        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        checkout.setBackground(new java.awt.Color(0, 153, 153));
        checkout.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        checkout.setForeground(new java.awt.Color(255, 255, 255));
        checkout.setText("check out");
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });

        payment.setBackground(new java.awt.Color(0, 153, 153));
        payment.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setText("generate payment");
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        print.setBackground(new java.awt.Color(0, 153, 153));
        print.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("total");

        total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total.setText(" ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Payment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(313, 313, 313))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combobox)
                    .addComponent(checkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(print, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(58, 58, 58))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxActionPerformed

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
       
        
            if (bookingId != 1) {
            bookingdB.updateCheckOut(bookingId, new Date().getTime() / 1000);
            result = bookingdB.getABooking(bookingId);
         
            try {
                int duration = 1;
                int checkIn = result.getInt("check_in");
                int checkOut = result.getInt("check_out");
                String roomName = result.getString("booking_room");

                long diff = Math.abs((checkOut * 1000) - (checkIn * 1000));
               

                int durationDays = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                int roomFare = bookingdB.getRoomPrice(bookingId);

                bookingdB.CloseAll();
             
                if (roomFare != -1) {

                    System.out.println("working as expected " + roomFare);
                    bookingdB.insertOrder(new Order(
                            bookingId,
                            roomName,
                            roomFare,
                            durationDays,
                            (roomFare * durationDays)
                    ));
                }
          
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "no booking result found\n " + ex.toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "no booking selected, try to select one hitting enter from suggestion box");
        }

    }//GEN-LAST:event_checkoutActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
       
         if (bookingId != -1) {
            result = bookingdB.getAllPaymentInfo(bookingId);
        } else {
            JOptionPane.showMessageDialog(null, "no booking selected, try to select one hitting enter from suggestion box");
        }
    }//GEN-LAST:event_paymentActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
     
        try {
            MessageFormat header = new MessageFormat("I3 Technologies");
            MessageFormat footer = new MessageFormat("I3 hotel Management, Faysal Ahmed");

            table.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Error printer \n" + ex.toString());
        }
    }//GEN-LAST:event_printActionPerformed

    private void tablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablePropertyChange
       
         if (table.getModel().getRowCount() != 0) {
            System.out.println(table.getModel().getRowCount() + " ,,,");
           
            
        }
    }//GEN-LAST:event_tablePropertyChange

    
    
    
    
    
    


    public void bookingComboFill(ResultSet result) {
        bookingList.clear();
        try {

            while (result.next()) {
              
                bookingList.add(result.getString("booking_room") + ", " + result.getString("name") + "," + result.getString("booking_id"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "bookingCombo fill error");
        }

    }

    public void searchHelper() {
        final DefaultComboBoxModel model = new DefaultComboBoxModel(bookingList);
        combobox.setModel(model);

        JTextComponent editor = (JTextComponent) combobox.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt) {

                if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                    String details = (String) combobox.getSelectedItem();
                
                    if (!details.contains(",")) {
                        JOptionPane.showMessageDialog(null, "no booking found, try adding a new booking");
                    } else {
                        bookingId = Integer.parseInt(details.substring(details.lastIndexOf(",") + 1));
                       

                    }

                }

            
                String value = "";
                try {
                    value = combobox.getEditor().getItem().toString();
                  

                } catch (Exception ex) {
                }
                if (value.length() >= 2) {

                  
                    bookingComboFill(bookingdB.bookingsReadyForOrder(value));
                    
                }

            }
        });
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkout;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton payment;
    private javax.swing.JButton print;
    private javax.swing.JTable table;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
