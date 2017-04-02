package view;

import javax.swing.JOptionPane;
import managers.Master;

public class Main_menu extends javax.swing.JFrame {

    Master m;
    public Main_menu(Master m) {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.m = m;
        user_label.setText(m.getUm().getSelectedUser().getName());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        button2 = new java.awt.Button();
        jPanel3 = new javax.swing.JPanel();
        button3 = new java.awt.Button();
        user_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 380));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Adivinator-09.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jPanel4.setBackground(new java.awt.Color(27, 117, 187));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setBackground(new java.awt.Color(27, 117, 187));
        button1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Start");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel4.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -6, 380, 70));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 360, 60));

        jPanel2.setBackground(new java.awt.Color(27, 117, 187));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button2.setBackground(new java.awt.Color(27, 117, 187));
        button2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("High Scores");
        jPanel2.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, -5, 390, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 360, 60));

        jPanel3.setBackground(new java.awt.Color(27, 132, 187));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button3.setBackground(new java.awt.Color(27, 132, 187));
        button3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("Quit");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel3.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 390, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 360, 60));

        user_label.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        user_label.setForeground(new java.awt.Color(27, 117, 187));
        user_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_label.setText("Username");
        jPanel1.add(user_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 360, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new in_game_base(m);
        this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        m.close();
        this.dispose();
    }//GEN-LAST:event_button3ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel user_label;
    // End of variables declaration//GEN-END:variables
}
