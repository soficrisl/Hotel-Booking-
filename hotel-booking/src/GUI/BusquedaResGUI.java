/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import EDD.ListaDoble;
import EDD.NodoDoble;
import static FUNCTIONS.FuncionesGenerales.contieneNumeroEnteroPositivo;
import static FUNCTIONS.FuncionesGenerales.contieneSoloLetras;
import FUNCTIONS.HotelManager;
import FUNCTIONS.Messages;
import OBJECTS.Client;
import OBJECTS.Reservation;

/**
 *  Clase de la interfaz para Buscar Reservaciones
 *
 * @author Julene
 */
public class BusquedaResGUI extends javax.swing.JFrame {
    //Atributos
    public static GUI GUIinicial;
    public static BusquedaGUI busquedaGUI;
    public static CheckInGUI checkinGUI;
    public static HistorialGUI historialGUI;
    public static CheckOutGUI checkoutGUI;
    private int cedula;
    /**
     * Constructores de la clase  dependiendo de que interfaz venga
     * 
     * @throws Exception 
     */
    
    //Desde historialGUI
    public BusquedaResGUI(HistorialGUI historialGUI) {
        initComponents();
        this.historialGUI = historialGUI;
        historialGUI.setVisible(false);
        this.setVisible(true);
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    //Desde CheckoutGUI
    public BusquedaResGUI(CheckOutGUI checkoutGUI) {
        initComponents();
        this.checkoutGUI = checkoutGUI;
        checkoutGUI.setVisible(false);
        this.setVisible(true);
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    //Desde BusquedaGUI
    public BusquedaResGUI(BusquedaGUI busquedaGUI) {
        initComponents();
        this.busquedaGUI = busquedaGUI;
        busquedaGUI.setVisible(false);
        this.setVisible(true);
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    //Desde CheckInGUI
    public BusquedaResGUI(CheckInGUI checkinGUI) {
        initComponents();
        this.checkinGUI = checkinGUI;
        checkinGUI.setVisible(false);
        this.setVisible(true);
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    //Desde GUIinicial
    public BusquedaResGUI(GUI GUIinicial) {
        initComponents();
        this.GUIinicial = GUIinicial;
        GUIinicial.setVisible(false);
        this.setVisible(true);
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public BusquedaResGUI() {
        initComponents();
        this.setVisible(true);
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Lobby = new javax.swing.JButton();
        checkin = new javax.swing.JButton();
        Busqueda = new javax.swing.JButton();
        Historial = new javax.swing.JButton();
        Busquedares = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkout = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CampoCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 470, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 464, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));

        Lobby.setBackground(new java.awt.Color(0, 0, 102));
        Lobby.setFont(new java.awt.Font("Century Gothic", 2, 16)); // NOI18N
        Lobby.setForeground(new java.awt.Color(255, 255, 255));
        Lobby.setText("Home");
        Lobby.setBorder(null);
        Lobby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LobbyActionPerformed(evt);
            }
        });

        checkin.setBackground(new java.awt.Color(0, 51, 102));
        checkin.setFont(new java.awt.Font("Century Gothic", 2, 16)); // NOI18N
        checkin.setForeground(new java.awt.Color(255, 255, 255));
        checkin.setText("Check-In");
        checkin.setBorder(null);
        checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinActionPerformed(evt);
            }
        });

        Busqueda.setBackground(new java.awt.Color(0, 0, 102));
        Busqueda.setFont(new java.awt.Font("Century Gothic", 2, 16)); // NOI18N
        Busqueda.setForeground(new java.awt.Color(255, 255, 255));
        Busqueda.setText("Busqueda");
        Busqueda.setBorder(null);
        Busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaActionPerformed(evt);
            }
        });

        Historial.setBackground(new java.awt.Color(0, 0, 102));
        Historial.setFont(new java.awt.Font("Century Gothic", 2, 16)); // NOI18N
        Historial.setForeground(new java.awt.Color(255, 255, 255));
        Historial.setText("Historial");
        Historial.setBorder(null);
        Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialActionPerformed(evt);
            }
        });

        Busquedares.setBackground(new java.awt.Color(0, 51, 102));
        Busquedares.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        Busquedares.setForeground(new java.awt.Color(255, 255, 255));
        Busquedares.setText("Busqueda Reservacion");
        Busquedares.setBorder(null);
        Busquedares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaresActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unnamed (3) (3).jpg"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Menu");

        checkout.setBackground(new java.awt.Color(0, 51, 102));
        checkout.setFont(new java.awt.Font("Century Gothic", 2, 16)); // NOI18N
        checkout.setForeground(new java.awt.Color(255, 255, 255));
        checkout.setText("Check-out");
        checkout.setBorder(null);
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lobby, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(checkin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Busqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Busquedares, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addComponent(Historial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(checkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lobby, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Busquedares, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Historial, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 470));

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jPanel6.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setFont(new java.awt.Font("Malgun Gothic Semilight", 2, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Caracas");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unnamed (2).jpg"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Captura de pantalla 2024-03-07 230020.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -20, 650, 100));

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 2, 14)); // NOI18N
        jLabel1.setText("Cedula:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 60, -1));

        CampoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(CampoCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 120, -1));

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Busqueda Reservacion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Malgun Gothic Semilight", 2, 16)); // NOI18N
        jLabel9.setText("Introduzca la cedula del cliente que desea buscar:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 480, -1));

        buscar.setBackground(new java.awt.Color(0, 51, 102));
        buscar.setFont(new java.awt.Font("Malgun Gothic", 2, 12)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 160, -1));

        CampoResultado.setColumns(20);
        CampoResultado.setRows(5);
        jScrollPane1.setViewportView(CampoResultado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 510, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para ir a la interfaz GUIinicial
     * @param evt 
     */
    private void LobbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LobbyActionPerformed
        GUI GUIinicial = new GUI(this);
        
    }//GEN-LAST:event_LobbyActionPerformed

    /**
     * Metodo para ir a la interfaz HistorialGUI
     * @param evt 
     */
    private void HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialActionPerformed
        HistorialGUI historialGUI = new HistorialGUI(this);
    }//GEN-LAST:event_HistorialActionPerformed

    /**
     * Metodo para ir a la interfaz CheckInGUI
     * @param evt 
     */
    private void checkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinActionPerformed
        CheckInGUI interfazcheckIn = new CheckInGUI(this);
    }//GEN-LAST:event_checkinActionPerformed

    private void BusquedaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaresActionPerformed

    }//GEN-LAST:event_BusquedaresActionPerformed

    /**
     * Metodo para ir a la interfaz BusquedaGUI
     * @param evt 
     */
    private void BusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaActionPerformed
        BusquedaGUI busquedaGUI = new BusquedaGUI(this);
    }//GEN-LAST:event_BusquedaActionPerformed

    /**
     * Metodo para ir a la interfaz CheckoitGUI
     * @param evt 
     */
    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        CheckOutGUI checkoutGUI = new CheckOutGUI(this);
    }//GEN-LAST:event_checkoutActionPerformed

    private void CampoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCedulaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        CampoResultado.setText("");
        String cedulaString = CampoCedula.getText().toString();
        
        if (CampoCedula.getText().trim().isEmpty()) {
            Messages.error("No pueden haber campos vacíos");}
        else if (!contieneNumeroEnteroPositivo(cedulaString)){
            Messages.error("Verifica que los datos introducidos sean correctos, cédula inválida.");}
        else{
        HotelManager manager = Datos.getManager();
        cedula = Integer.parseInt(cedulaString);
        Reservation reserva = manager.searchReservation(cedula);
        

        // Verificar si se encontraron resultados
        if (reserva != null) {
            Messages.information("Se han encontrado los datos exitosamente!");
            String info = reserva.show();
            CampoResultado.setText(info);
            
        } else {
            Messages.information("No se encontraron reservaciones con la cédula proporcionada.");
        }
        }
        CampoCedula.setText("");
        
    }//GEN-LAST:event_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(BusquedaResGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaResGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaResGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaResGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaResGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Busqueda;
    private javax.swing.JButton Busquedares;
    private javax.swing.JTextField CampoCedula;
    private javax.swing.JTextArea CampoResultado;
    private javax.swing.JButton Historial;
    private javax.swing.JButton Lobby;
    private javax.swing.JButton buscar;
    private javax.swing.JButton checkin;
    private javax.swing.JButton checkout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
