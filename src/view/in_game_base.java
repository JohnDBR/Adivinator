package view;

import javax.swing.JOptionPane;
import managers.Master;

public class in_game_base extends javax.swing.JFrame {

    Master m;
    public in_game_base(Master m) {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.m = m;
    }
    
    private void update(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        button2 = new java.awt.Button();
        jPanel5 = new javax.swing.JPanel();
        button5 = new java.awt.Button();
        jPanel6 = new javax.swing.JPanel();
        button4 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        button3 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 380));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(27, 117, 187));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setBackground(new java.awt.Color(27, 117, 187));
        button1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Si");
        jPanel4.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -10, 630, 80));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 550, 60));

        jPanel2.setBackground(new java.awt.Color(27, 117, 187));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button2.setBackground(new java.awt.Color(27, 117, 187));
        button2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("No");
        jPanel2.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -10, 630, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 550, 60));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button5.setBackground(new java.awt.Color(27, 117, 187));
        button5.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setLabel("Posiblemente no");
        jPanel5.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -10, 630, 80));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 550, 60));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button4.setBackground(new java.awt.Color(27, 117, 187));
        button4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setLabel("Posiblemente si");
        jPanel6.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -10, 630, 80));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 550, 60));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jEditorPane1.setEditable(false);
        jEditorPane1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jEditorPane1.setForeground(new java.awt.Color(27, 117, 187));
        jEditorPane1.setText("¿Pregunta de prueba?");
        jScrollPane2.setViewportView(jEditorPane1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 480, 130));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Adivinator-10.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button3.setBackground(new java.awt.Color(27, 117, 187));
        button3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("Irelevante");
        jPanel3.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -11, 560, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 550, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
