package view;

import javax.swing.JOptionPane;
import managers.Master;

public class end_game extends javax.swing.JFrame {

    Master m;

    public end_game(Master m) {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.m = m;
        user_label1.setText(m.getUm().getSelectedUser().getName());
        user_label2.setText(m.getPoints() + "");
        m.getUm().scoreToSelectedUser(m.getPoints());
        user_label.setText(m.getTime());
        set_Score();
    }
    
    private void set_Score(){
        if(m.getPoints() <= 15) user_label4.setText("Perdiste");
        else user_label4.setText("Ganaste");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        button3 = new java.awt.Button();
        user_label = new javax.swing.JLabel();
        user_label1 = new javax.swing.JLabel();
        user_label2 = new javax.swing.JLabel();
        user_label3 = new javax.swing.JLabel();
        user_label4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 380));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Adivinator-09.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jPanel3.setBackground(new java.awt.Color(27, 132, 187));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button3.setBackground(new java.awt.Color(27, 132, 187));
        button3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("Menu");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel3.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 390, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 360, 60));

        user_label.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_label.setForeground(new java.awt.Color(102, 102, 102));
        user_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_label.setText("01:56");
        jPanel1.add(user_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 360, -1));

        user_label1.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_label1.setForeground(new java.awt.Color(27, 117, 187));
        user_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_label1.setText("Username");
        jPanel1.add(user_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 360, -1));

        user_label2.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_label2.setForeground(new java.awt.Color(102, 102, 102));
        user_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_label2.setText("99999");
        jPanel1.add(user_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 360, -1));

        user_label3.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_label3.setForeground(new java.awt.Color(27, 117, 187));
        user_label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_label3.setText("Score");
        jPanel1.add(user_label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 360, -1));

        user_label4.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_label4.setForeground(new java.awt.Color(102, 102, 102));
        user_label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_label4.setText("99999");
        jPanel1.add(user_label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 360, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        new Main_menu(m);
        this.dispose();
    }//GEN-LAST:event_button3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel user_label;
    private javax.swing.JLabel user_label1;
    private javax.swing.JLabel user_label2;
    private javax.swing.JLabel user_label3;
    private javax.swing.JLabel user_label4;
    // End of variables declaration//GEN-END:variables
}
