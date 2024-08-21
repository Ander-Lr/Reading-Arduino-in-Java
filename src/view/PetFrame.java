
package view;

import Controller.ReadSensor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PetFrame extends javax.swing.JFrame {

     public PetFrame() {
        initComponents();
        ReadSensor sensor = new ReadSensor(this);
        sensor.ConectionArduino();
    }

    public void updateStatus(String distance) {
        double dist = Double.parseDouble(distance);

        if (dist <= 50) { // Por ejemplo, 50 cm como umbral
            labelRound2.setBackground(Color.RED);  // Cambiar a rojo si está muy cerca
        } else {
            labelRound2.setBackground(Color.GREEN); // Verde si está lejos
        }

        // Actualizar fecha y hora
        String dateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        //jLabelDateTime.setText("Última detección: " + dateTime);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelRound2 = new ComponentRoundJilmar.LabelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 1, 24)); // NOI18N
        jLabel1.setText("Pet Status");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 170, 30));

        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 1, 24)); // NOI18N
        jLabel2.setText("Pet Jilander");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 190, 40));

        labelRound2.setBackground(new java.awt.Color(51, 255, 0));
        labelRound2.setRoundBottomLeft(50);
        labelRound2.setRoundBottomRight(50);
        labelRound2.setRoundTopLeft(50);
        labelRound2.setRoundTopRight(50);
        jPanel1.add(labelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 30, 30));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 360, 170));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/image.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private ComponentRoundJilmar.LabelRound labelRound2;
    // End of variables declaration//GEN-END:variables
}
