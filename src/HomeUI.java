import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * This class represents the user interface of the home
 * 
 * @author anes_
 */
public class HomeUI extends javax.swing.JFrame {
    
    TryConnectionHost tryConnectionHost;
    TryConnectionClient tryConnectionClient;
    StatisticsManager statisticsManager = new StatisticsManager();
    
    GameUI gameUI;
    SettingsUI settingsUI;
    StatisticsUI statisticsUI;
    boolean menuActive1 = true, menuActive2 = false, menuActive3 = false;

    /**
     * Creates new form HomeUI
     */
    public HomeUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.initGameUI();
        tryConnectionHost = new TryConnectionHost(imgStatus);
        tryConnectionClient = new TryConnectionClient(imgStatus);;
        tryConnectionClient.start();
        tryConnectionHost.start();
        
    }
    
    private void initGameUI(){
        
        gameUI = new GameUI(statisticsManager);
        settingsUI = new SettingsUI();
        statisticsUI = new StatisticsUI(statisticsManager);
        pnlContainer.add(gameUI);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        pnlContainer = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlGame = new javax.swing.JPanel();
        lblGame = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlSettings = new javax.swing.JPanel();
        lblSettings = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlStatistics = new javax.swing.JPanel();
        lblConnection = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        imgStatus = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Checkers");
        setPreferredSize(new java.awt.Dimension(1030, 712));
        setResizable(false);
        getContentPane().setLayout(null);

        pnlContainer.setBackground(new java.awt.Color(51, 255, 204));
        pnlContainer.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnlContainer);
        pnlContainer.setBounds(110, 80, 990, 600);

        pnlMenu.setBackground(new java.awt.Color(23, 35, 51));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        pnlMenu.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 108, 68));

        pnlGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlGameMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlGameMousePressed(evt);
            }
        });

        lblGame.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblGame.setForeground(new java.awt.Color(255, 255, 255));
        lblGame.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGame.setText("Gioco");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/game.png"))); // NOI18N

        pnlGame.setBackground(new java.awt.Color(41, 57, 80));

        javax.swing.GroupLayout pnlGameLayout = new javax.swing.GroupLayout(pnlGame);
        pnlGame.setLayout(pnlGameLayout);
        pnlGameLayout.setHorizontalGroup(
            pnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGameLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGame, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGameLayout.setVerticalGroup(
            pnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameLayout.createSequentialGroup()
                .addGroup(pnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGame, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pnlGame.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(255, 255, 255)));

        pnlMenu.add(pnlGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 110, 40));

        pnlSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSettingsMouseClicked(evt);
            }
        });

        lblSettings.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblSettings.setForeground(new java.awt.Color(255, 255, 255));
        lblSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSettings.setText("Impostazioni");
        lblSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSettingsMousePressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings.png"))); // NOI18N

        pnlSettings.setBackground(new java.awt.Color(23, 35, 51));

        javax.swing.GroupLayout pnlSettingsLayout = new javax.swing.GroupLayout(pnlSettings);
        pnlSettings.setLayout(pnlSettingsLayout);
        pnlSettingsLayout.setHorizontalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSettingsLayout.setVerticalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlSettings.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0,0)));

        pnlMenu.add(pnlSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 110, 40));

        pnlStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlStatisticsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlStatisticsMousePressed(evt);
            }
        });

        lblConnection.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblConnection.setForeground(new java.awt.Color(255, 255, 255));
        lblConnection.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblConnection.setText("Statistiche");

        imgLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/connection.png"))); // NOI18N

        pnlStatistics.setBackground(new java.awt.Color(23, 35, 51));

        javax.swing.GroupLayout pnlStatisticsLayout = new javax.swing.GroupLayout(pnlStatistics);
        pnlStatistics.setLayout(pnlStatisticsLayout);
        pnlStatisticsLayout.setHorizontalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStatisticsLayout.setVerticalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlStatistics.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0,0)));

        pnlMenu.add(pnlStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 110, 40));

        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        pnlMenu.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 40, 40));

        imgStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nopair.png"))); // NOI18N
        pnlMenu.add(imgStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Stato");
        pnlMenu.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        getContentPane().add(pnlMenu);
        pnlMenu.setBounds(0, 0, 110, 680);

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 51, 51));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Checkers");
        pnlTitle.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1, 830, 80));

        getContentPane().add(pnlTitle);
        pnlTitle.setBounds(106, 0, 1000, 81);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSettingsMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pnlSettingsMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void pnlGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGameMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pnlGameMouseClicked

    private void pnlStatisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatisticsMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pnlStatisticsMouseClicked

    private void lblSettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSettingsMousePressed
        // TODO add your handling code here:
        this.changeMenuItem(2);
        lblTitle.setText("Settings");
        
    }//GEN-LAST:event_lblSettingsMousePressed

    private void pnlStatisticsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatisticsMousePressed
        // TODO add your handling code here:
        
        this.changeMenuItem(3);
        lblTitle.setText("Statistiche");
        statisticsUI.initStatistics();
    }//GEN-LAST:event_pnlStatisticsMousePressed

    private void pnlGameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGameMousePressed
        // TODO add your handling code here:
        
        this.changeMenuItem(1);
        lblTitle.setText("Checkers");
    }//GEN-LAST:event_pnlGameMousePressed

    private void changeMenuItem(int menuItem){
        
        switch(menuItem){
            
            case 1:
                if(!menuActive1){
                    
                    pnlContainer.remove(statisticsUI);
                    pnlContainer.remove(settingsUI);
                    pnlContainer.add(gameUI);
                    menuActive1 = true;
                    menuActive2 = false;
                    menuActive3 = false;
                    pnlGame.setBackground(new Color(41, 57, 80));
                    pnlSettings.setBackground(new Color(23, 35, 51));
                    pnlStatistics.setBackground(new Color(23, 35, 51));
                    pnlGame.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(255, 255, 255)));
                    pnlSettings.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0,0)));
                    pnlStatistics.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0,0)));

                }
                break;
                
            case 2:
                if(!menuActive2){
                    
                    pnlContainer.remove(gameUI);
                    pnlContainer.remove(statisticsUI);
                    pnlContainer.add(settingsUI);
                    menuActive2 = true;
                    menuActive1 = false;
                    menuActive3 = false;
                    pnlSettings.setBackground(new Color(41, 57, 80));
                    pnlGame.setBackground(new Color(23, 35, 51));
                    pnlStatistics.setBackground(new Color(23, 35, 51));
                    pnlSettings.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(255, 255, 255)));
                    pnlGame.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0,0)));
                    pnlStatistics.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0,0)));
                }
                break;
                
            case 3:
                pnlContainer.remove(gameUI);
                pnlContainer.remove(settingsUI);
                pnlContainer.add(statisticsUI);
                menuActive1 = false;
                menuActive2 = false;
                menuActive3 = true;
                pnlStatistics.setBackground(new Color(41, 57, 80));
                pnlSettings.setBackground(new Color(23, 35, 51));
                pnlGame.setBackground(new Color(23, 35, 51));
                pnlStatistics.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(255, 255, 255)));
                pnlSettings.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0,0)));
                pnlGame.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0,0)));
                break;
        }
        
        pnlContainer.revalidate();
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
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 HomeUI home = new HomeUI();
                home.setVisible(true);
                home.setIconImage(new ImageIcon(getClass().getResource("/image/checkers.png")).getImage());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblConnection;
    private javax.swing.JLabel lblGame;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSettings;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlGame;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlSettings;
    private javax.swing.JPanel pnlStatistics;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables
}
