package view;

import javax.swing.JOptionPane;
import managers.Master;
import models.User;
import structures.linkedlist.LinkedList;

public class top_5 extends javax.swing.JFrame {

    Master m;
    LinkedList<User> l;
    public top_5(Master m) {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.m = m;
        this.l = m.getUm().getTop5();
        update();
    }
    
    private void update(){
        try{
        user_1.setText(l.get(0).getName());
        score_1.setText("" + l.get(0).getTopScore());
        }catch(Exception e){}
        try{
        user_2.setText(l.get(1).getName());
        score_2.setText("" + l.get(1).getTopScore());
        }catch(Exception e){}
        try{
        user_3.setText(l.get(2).getName());
        score_3.setText("" + l.get(2).getTopScore());
        }catch(Exception e){}
        try{
        user_4.setText(l.get(3).getName());
        score_4.setText("" + l.get(3).getTopScore());
        }catch(Exception e){}
        try{
        user_5.setText(l.get(4).getName());
        score_5.setText("" + l.get(4).getTopScore());
        }catch(Exception e){}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        score_1 = new javax.swing.JLabel();
        user_1 = new javax.swing.JLabel();
        score_2 = new javax.swing.JLabel();
        user_2 = new javax.swing.JLabel();
        score_3 = new javax.swing.JLabel();
        user_3 = new javax.swing.JLabel();
        score_4 = new javax.swing.JLabel();
        user_4 = new javax.swing.JLabel();
        score_5 = new javax.swing.JLabel();
        user_5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 380));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Adivinator-09.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jPanel3.setBackground(new java.awt.Color(27, 132, 187));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setBackground(new java.awt.Color(27, 117, 187));
        button1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Menu");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel3.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -6, 380, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 360, 60));

        score_1.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        score_1.setForeground(new java.awt.Color(102, 102, 102));
        score_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(score_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 100, -1));

        user_1.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_1.setForeground(new java.awt.Color(27, 117, 187));
        user_1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(user_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 330, -1));

        score_2.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        score_2.setForeground(new java.awt.Color(102, 102, 102));
        score_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(score_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 100, -1));

        user_2.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_2.setForeground(new java.awt.Color(27, 117, 187));
        user_2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(user_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 330, -1));

        score_3.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        score_3.setForeground(new java.awt.Color(102, 102, 102));
        score_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(score_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 100, -1));

        user_3.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_3.setForeground(new java.awt.Color(27, 117, 187));
        user_3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(user_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 330, -1));

        score_4.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        score_4.setForeground(new java.awt.Color(102, 102, 102));
        score_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(score_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 100, -1));

        user_4.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_4.setForeground(new java.awt.Color(27, 117, 187));
        user_4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(user_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 330, -1));

        score_5.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        score_5.setForeground(new java.awt.Color(102, 102, 102));
        score_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(score_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, 100, -1));

        user_5.setFont(new java.awt.Font("Trebuchet MS", 1, 56)); // NOI18N
        user_5.setForeground(new java.awt.Color(27, 117, 187));
        user_5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(user_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 330, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new Main_menu(m);
        this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel score_1;
    private javax.swing.JLabel score_2;
    private javax.swing.JLabel score_3;
    private javax.swing.JLabel score_4;
    private javax.swing.JLabel score_5;
    private javax.swing.JLabel user_1;
    private javax.swing.JLabel user_2;
    private javax.swing.JLabel user_3;
    private javax.swing.JLabel user_4;
    private javax.swing.JLabel user_5;
    // End of variables declaration//GEN-END:variables
}
