/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.izzettinozmen.hotelreservation;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ifozmen
 */
public class FrameHotelList extends javax.swing.JFrame {

    /**
     * Creates new form HotelList
     */
    public FrameHotelList() {
        initComponents();
        setLocationRelativeTo(null);
        addHotelsToScrollPane();
    }

    private void showSplashAndOpen(JFrame targetFrame, String imagePath, String message) {
        JWindow splash = new JWindow();
        JPanel splashPanel = new JPanel();
        splashPanel.setLayout(new BoxLayout(splashPanel, BoxLayout.Y_AXIS));
        splashPanel.setBackground(java.awt.Color.WHITE);

        JLabel iconLabel = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
            iconLabel.setIcon(icon);
        } catch (Exception e) {
            iconLabel.setText("Icon Cannot Loaded");
        }
        iconLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel splashLabel = new JLabel(message, JLabel.CENTER);
        splashLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        splashLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        splashPanel.add(Box.createRigidArea(new java.awt.Dimension(0, 20)));
        splashPanel.add(iconLabel);
        splashPanel.add(Box.createRigidArea(new java.awt.Dimension(0, 10)));
        splashPanel.add(splashLabel);

        splash.getContentPane().add(splashPanel);
        splash.setSize(300, 200);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);

        Timer timer = new Timer(500, e -> {
            splash.dispose();
            targetFrame.setVisible(true);
            this.setVisible(false);
            this.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void addHotelsToScrollPane() {
        // JScrollPane'in içine yerleştirilecek ana panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Dikey sıralama

        // Örnek otel bilgileri
        String[][] hotels = {
            {"Blue Horizon Suites", "Eşsiz deniz manzarasıyla huzurun yeni adresi.", "9.3", "1500 TL/gece", "Antalya", "https://images.etstur.com/files/images/hotelImages/TR/216095/l/Lago-Hotel-Genel-370417.jpg"},
            {"Golden Beach Hotel", "Altın kumsalların tam yanında.", "8.7", "1200 TL/gece", "Bodrum", "https://images.etstur.com/files/images/hotelImages/TR/216095/l/Lago-Hotel-Genel-370417.jpg"},
            {"Mountain View Resort", "Dağ manzarasıyla dinlenme fırsatı.", "9.0", "1000 TL/gece", "Uludağ", "https://images.etstur.com/files/images/hotelImages/TR/216095/l/Lago-Hotel-Genel-370417.jpg"},
            {"Sea Breeze Inn", "Deniz esintisini hissedin.", "8.5", "900 TL/gece", "Çeşme", "https://images.etstur.com/files/images/hotelImages/TR/216095/l/Lago-Hotel-Genel-370417.jpg"},};

        // Her bir otel için panel oluştur ve ekle
        for (String[] hotel : hotels) {
            JPanel hotelPanel = new JPanel();
            hotelPanel.setLayout(new BorderLayout(10, 10));
            hotelPanel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.LIGHT_GRAY, 1));
            hotelPanel.setBackground(java.awt.Color.WHITE);

            // Resim alanı (sol taraf)
            try {
                java.net.URL imageURL = new java.net.URL(hotel[5]);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageURL).getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setPreferredSize(new java.awt.Dimension(150, 150));
                hotelPanel.add(imageLabel, BorderLayout.WEST);
            } catch (Exception e) {
                JLabel errorLabel = new JLabel("Resim yüklenemedi");
                errorLabel.setPreferredSize(new java.awt.Dimension(150, 150));
                hotelPanel.add(errorLabel, BorderLayout.WEST);
            }

            // Sağ taraf bilgi paneli
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BorderLayout());
            infoPanel.setBackground(java.awt.Color.WHITE);

            // Üst panel: Otel ismi ve puan
            JPanel topPanel = new JPanel();
            topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            topPanel.setBackground(java.awt.Color.WHITE);

            JLabel nameLabel = new JLabel(hotel[0]);
            nameLabel.setFont(new java.awt.Font("Lantinghei SC", java.awt.Font.BOLD, 18));
            nameLabel.setForeground(new java.awt.Color(34, 113, 179)); // Modern mavi renk

            JLabel ratingLabel = new JLabel("Puan: " + hotel[2]);
            ratingLabel.setFont(new java.awt.Font("Helvetica Neue", java.awt.Font.PLAIN, 13));
            ratingLabel.setForeground(new java.awt.Color(255, 140, 0)); // Turuncu renk

            topPanel.add(nameLabel);
            topPanel.add(Box.createRigidArea(new java.awt.Dimension(10, 0))); // Boşluk
            topPanel.add(ratingLabel);

            // Orta panel: Şehir ve açıklama
            JPanel middlePanel = new JPanel();
            middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
            middlePanel.setBackground(java.awt.Color.WHITE);

            JLabel locationLabel = new JLabel("Şehir: " + hotel[4]);
            locationLabel.setFont(new java.awt.Font("Helvetica Neue", java.awt.Font.ITALIC, 12));
            locationLabel.setForeground(java.awt.Color.DARK_GRAY);

            JLabel descLabel = new JLabel("<html>" + hotel[1] + "</html>");
            descLabel.setFont(new java.awt.Font("Helvetica Neue", java.awt.Font.PLAIN, 13));

            middlePanel.add(locationLabel);
            middlePanel.add(descLabel);

            // Alt panel: Fiyat ve buton
            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            bottomPanel.setBackground(java.awt.Color.WHITE);

            JLabel priceLabel = new JLabel("Fiyat: " + hotel[3]);
            priceLabel.setFont(new java.awt.Font("Helvetica Neue", java.awt.Font.BOLD, 13));

            JButton checkButton = new JButton("Check Hotel");

            bottomPanel.add(priceLabel);
            bottomPanel.add(checkButton);

            // Bilgi paneline üst, orta ve alt panelleri ekle
            infoPanel.add(topPanel, BorderLayout.NORTH);
            infoPanel.add(middlePanel, BorderLayout.CENTER);
            infoPanel.add(bottomPanel, BorderLayout.SOUTH);

            // Sağ tarafı hotelPanel'e ekle
            hotelPanel.add(infoPanel, BorderLayout.CENTER);

            // Ana panele otel panelini ekle
            mainPanel.add(hotelPanel);
            mainPanel.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10))); // Oteller arası boşluk
        }

        // JScrollPane'e ana paneli ekle
        jScrollPane1.setViewportView(mainPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnShowRes = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnUserProf = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnResHistory = new javax.swing.JButton();
        btnHotelList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnShowRes.setText("Show Reservations");
        btnShowRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowResActionPerformed(evt);
            }
        });

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnUserProf.setText("User Settings");
        btnUserProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserProfActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnResHistory.setText("Reservation History");
        btnResHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResHistoryActionPerformed(evt);
            }
        });

        btnHotelList.setText("Hotel List");
        btnHotelList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHotelListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addGap(52, 52, 52)
                .addComponent(btnHotelList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUserProf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShowRes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResHistory)
                .addGap(137, 137, 137)
                .addComponent(btnLogOut))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHotelList)
                        .addComponent(btnHome)
                        .addComponent(btnUserProf)
                        .addComponent(btnShowRes)
                        .addComponent(btnResHistory))
                    .addComponent(btnLogOut))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowResActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowResActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        JWindow splash = new JWindow();
        JPanel splashPanel = new JPanel();
        splashPanel.setLayout(new BoxLayout(splashPanel, BoxLayout.Y_AXIS));
        splashPanel.setBackground(java.awt.Color.WHITE);

        JLabel iconLabel = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/com/izzettinozmen/hotelreservation/Hotels/pngegg.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
            iconLabel.setIcon(icon);
        } catch (Exception e) {
            iconLabel.setText("Icon Cannot Loaded");
        }
        iconLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        JLabel splashLabel = new JLabel("Loading Home...", JLabel.CENTER);
        splashLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        splashLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        splashPanel.add(Box.createRigidArea(new java.awt.Dimension(0, 20)));
        splashPanel.add(iconLabel);
        splashPanel.add(Box.createRigidArea(new java.awt.Dimension(0, 10)));
        splashPanel.add(splashLabel);
        splash.getContentPane().add(splashPanel);
        splash.setSize(300, 200);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
        Timer timer = new Timer(100, e -> {
            FrameHome hotelMenuFrame = new FrameHome();
            hotelMenuFrame.setVisible(true);
            this.setVisible(false);
            splash.dispose();
            this.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnUserProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserProfActionPerformed
        // TODO add your handling code here:
        FrameUser adminMenuFrame = new FrameUser();

        showSplashAndOpen(adminMenuFrame,
                getClass().getResource("/com/izzettinozmen/hotelreservation/Hotels/pngegg.png").getPath(),
                "Loading Settings...");
    }//GEN-LAST:event_btnUserProfActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        JWindow splash = new JWindow();
        JPanel splashPanel = new JPanel();
        splashPanel.setLayout(new BoxLayout(splashPanel, BoxLayout.Y_AXIS));
        splashPanel.setBackground(java.awt.Color.WHITE);

        JLabel iconLabel = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/com/izzettinozmen/hotelreservation/Hotels/pngegg.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
            iconLabel.setIcon(icon);
        } catch (Exception e) {
            iconLabel.setText("Icon Cannot Loaded");
        }
        iconLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        JLabel splashLabel = new JLabel("Logging Out...", JLabel.CENTER);
        splashLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        splashLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        splashPanel.add(Box.createRigidArea(new java.awt.Dimension(0, 20)));
        splashPanel.add(iconLabel);
        splashPanel.add(Box.createRigidArea(new java.awt.Dimension(0, 10)));
        splashPanel.add(splashLabel);
        splash.getContentPane().add(splashPanel);
        splash.setSize(300, 200);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
        Timer timer = new Timer(500, e -> {
            FrameLogin loginMenu = new FrameLogin();
            loginMenu.setVisible(true);
            this.setVisible(false);
            splash.dispose();
            this.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnResHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResHistoryActionPerformed

    private void btnHotelListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHotelListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHotelListActionPerformed

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
            java.util.logging.Logger.getLogger(FrameHotelList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameHotelList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameHotelList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameHotelList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameHotelList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHotelList;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnResHistory;
    private javax.swing.JButton btnShowRes;
    private javax.swing.JButton btnUserProf;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
