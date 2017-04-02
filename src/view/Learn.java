package view;

import javax.swing.JOptionPane;
import managers.Master;

public class Learn extends javax.swing.JFrame {

    Master m;
    in_game_base g;
    public Learn(Master m, in_game_base g) {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.m = m;
        this.g = g;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        button3 = new java.awt.Button();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 380));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Adivinator-09.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button3.setBackground(new java.awt.Color(27, 117, 187));
        button3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("Irelevante");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel3.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -11, 560, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 550, 60));

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(27, 117, 187));
        jTextField1.setText("Digite una pregunta que diferencia su animal");
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 540, -1));

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(27, 117, 187));
        jTextField2.setText("Digite su animal");
        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 540, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        m.getTm().learnInSelectedTree(jTextField1.getText(), jTextField2.getText());
        g.setVisible(true);
        g.update();
        this.dispose();
    }//GEN-LAST:event_button3ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
