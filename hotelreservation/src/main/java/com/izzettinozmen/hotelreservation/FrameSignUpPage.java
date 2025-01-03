/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.izzettinozmen.hotelreservation;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author ifozmen
 */
public class FrameSignUpPage extends javax.swing.JFrame {

    /**
     * Creates new form UserSettings
     */
    public FrameSignUpPage() {
        initComponents();
        setLocationRelativeTo(null);
        populateYearComboBox();
    }

    /**
     * Creates new form UserSettings
     */
    private void saveDataToDatabase() {
        String username = txtUserName.getText();
        String password = new String(txtPassword.getPassword());
        String name = txtName.getText();
        String surname = txtSurname.getText();
        String birthYear = (String) cmbYear.getSelectedItem();
        String email = txtMail.getText();
        String phone = txtPhoneNum.getText();
        String address = txtAddress.getText();
        String gender = (String) cmbGender.getSelectedItem();

        String dbUrl = "jdbc:mysql://localhost:3306/your_database_name"; // Veritabanı URL'i
        String dbUsername = "root"; // Veritabanı kullanıcı adı
        String dbPassword = ""; // Veritabanı şifresi

        String insertQuery = "INSERT INTO users (username, password, name, surname, birth_year, email, phone, address, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setString(4, surname);
            pstmt.setString(5, birthYear);
            pstmt.setString(6, email);
            pstmt.setString(7, phone);
            pstmt.setString(8, address);
            pstmt.setString(9, gender);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                this.dispose();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data to the database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtUserName.setText("");
        txtPassword.setText("");
        txtName.setText("");
        txtSurname.setText("");
        txtMail.setText("");
        txtPhoneNum.setText("");
        txtAddress.setText("");
        cmbYear.setSelectedIndex(-1);
        cmbGender.setSelectedIndex(0);
        jCheckBox1.setSelected(false);
    }

    private void populateYearComboBox() {
        int startYear = 1920;
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        cmbYear.removeAllItems();
        for (int year = startYear; year <= currentYear; year++) {
            cmbYear.addItem(String.valueOf(year));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblSurname = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPhonenum = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        lblBOD = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtPhoneNum = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox<>();
        btnSignUp = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmbYear = new javax.swing.JComboBox<>();
        txtAddress = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        checkBoxPassword = new javax.swing.JCheckBox();
        btnTerms = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblSurname.setText("Surname :");

        lblName.setText("Name :");

        lblUserName.setText("Username :");

        lblPhonenum.setText("Phone :");

        lblAddress.setText("Address :");

        lblGender.setText("Gender :");

        lblMail.setText("Mail :");

        lblBOD.setText("Birth Year :");

        txtUserName.setToolTipText("<html>Enter Username</html>");

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        btnSignUp.setText("Confirm Changes");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblPassword.setText("Password :");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        checkBoxPassword.setText("Show Password");
        checkBoxPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPasswordActionPerformed(evt);
            }
        });

        btnTerms.setText("Terms of Usage");
        btnTerms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTermsActionPerformed(evt);
            }
        });

        jCheckBox1.setText("I Accept Terms of Usage");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(btnSignUp))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(261, 261, 261)
                            .addComponent(checkBoxPassword))
                        .addComponent(lblPhonenum)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lblPassword)
                            .addGap(18, 18, 18)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lblUserName)
                            .addGap(18, 18, 18)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMail)
                                .addComponent(lblName)
                                .addComponent(lblAddress)
                                .addComponent(lblSurname))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtName)
                                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(lblGender)
                                            .addGap(18, 18, 18)
                                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(lblBOD)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(txtAddress)
                                .addComponent(txtMail)
                                .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTerms)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPassword))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBOD)
                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSurname)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMail)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhonenum)
                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTerms)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSignUp))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        boolean valid = true;

        if (!jCheckBox1.isSelected()) {
            JOptionPane.showMessageDialog(this, "You must accept the Terms of Usage to proceed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtUserName.getText().isEmpty()) {
            txtUserName.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            valid = false;
        } else {
            txtUserName.setBorder(UIManager.getBorder("TextField.border"));
        }

        if (txtPassword.getPassword().length == 0) {
            txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            valid = false;
        } else {
            txtPassword.setBorder(UIManager.getBorder("PasswordField.border"));
        }

        if (txtName.getText().isEmpty()) {
            txtName.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            valid = false;
        } else {
            txtName.setBorder(UIManager.getBorder("TextField.border"));
        }

        if (txtSurname.getText().isEmpty()) {
            txtSurname.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            valid = false;
        } else {
            txtSurname.setBorder(UIManager.getBorder("TextField.border"));
        }

        if (cmbYear.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a valid birth year.", "Error", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        if (txtMail.getText().isEmpty()) {
            txtMail.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            valid = false;
        } else {
            txtMail.setBorder(UIManager.getBorder("TextField.border"));
        }

        if (txtPhoneNum.getText().isEmpty()) {
            txtPhoneNum.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            valid = false;
        } else {
            txtPhoneNum.setBorder(UIManager.getBorder("TextField.border"));
        }

        if (txtAddress.getText().isEmpty()) {
            txtAddress.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            valid = false;
        } else {
            txtAddress.setBorder(UIManager.getBorder("TextField.border"));
        }

        // Eğer geçersiz alan varsa işlemi durdur
        if (!valid) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Veritabanına kaydetme işlemi
        saveDataToDatabase();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Cancel without saving changes?",
                "Confirm", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose(); // Pencereyi kapat
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void checkBoxPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPasswordActionPerformed
        if (checkBoxPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0);

        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_checkBoxPasswordActionPerformed

    private void btnTermsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTermsActionPerformed
        // TODO add your handling code here:
        TermsOfUsage terms = new TermsOfUsage();
        terms.setVisible(true);
    }//GEN-LAST:event_btnTermsActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new FrameSignUpPage().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnTerms;
    private javax.swing.JCheckBox checkBoxPassword;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBOD;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhonenum;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNum;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
