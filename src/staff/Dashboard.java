
package staff;

import Login.LoginPage;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Dashboard extends javax.swing.JFrame {
    private ArrayList<JLabel> labels;
//    private List<Jlabel> imageLabels; // Jlabel tampilkan gbr
//    private List<String> imagePaths; // daftar path gbr
    
    public Dashboard() {
        initComponents();
        
        this.setVisible(true);
        this.setLocation(10,5);
        this.setSize(1350, 680);
        this.setResizable(false); 
        
        init();
        
    }
    
    private void initIcon(){
        labels = new ArrayList<>();
        for (int i = 0; i < labels.size(); i++) {
            JLabel label = new JLabel();
            
            
        }
//        Jpanel panel = new Jpanel();
//        panel.setLayout(new FlowLayout());
//        this.add(panel);
        
        //Jlabel tampung gbr
//        imageLabels= new ArrayList<>();
//        for (int i = 0; i < imageLabels.size(); i++) {
//            JLabel label = newJlabel();
//            label.setPreferredSize(new Dimension(160,140));
//            
//            imageLabels.add(label);
//            panel.add(label); //tambah ke panel
//            
//        }
        
    }
    
    public void init(){
        setImage();
    }
    
    public void reset(){
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layerPanel1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        NameCafeLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        DoneButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        baseStrukPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        totalLabel1 = new javax.swing.JLabel();
        paidLabel = new javax.swing.JLabel();
        paidLabel1 = new javax.swing.JLabel();
        PayButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        nameLabel1 = new javax.swing.JLabel();
        priceLabel1 = new javax.swing.JLabel();
        JLabel6 = new javax.swing.JLabel();
        mainTitleLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        nameLabel2 = new javax.swing.JLabel();
        priceLabel2 = new javax.swing.JLabel();
        JLabel2 = new javax.swing.JLabel();
        meatballPanel = new javax.swing.JPanel();
        nameLabel3 = new javax.swing.JLabel();
        priceLabel3 = new javax.swing.JLabel();
        JLabel3 = new javax.swing.JLabel();
        steakPanel = new javax.swing.JPanel();
        nameLabel4 = new javax.swing.JLabel();
        priceLabel4 = new javax.swing.JLabel();
        JLabel4 = new javax.swing.JLabel();
        eggTPanel = new javax.swing.JPanel();
        nameLabel5 = new javax.swing.JLabel();
        priceLabel5 = new javax.swing.JLabel();
        JLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        nameLabel6 = new javax.swing.JLabel();
        priceLabel6 = new javax.swing.JLabel();
        JLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        nameLabel7 = new javax.swing.JLabel();
        priceLabel7 = new javax.swing.JLabel();
        JLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        nameLabel8 = new javax.swing.JLabel();
        priceLabel8 = new javax.swing.JLabel();
        JLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        nameLabel9 = new javax.swing.JLabel();
        priceLabel9 = new javax.swing.JLabel();
        JLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        nameLabel10 = new javax.swing.JLabel();
        priceLabel10 = new javax.swing.JLabel();
        JLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        nameLabel11 = new javax.swing.JLabel();
        priceLabel11 = new javax.swing.JLabel();
        JLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        layerPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(236, 226, 213));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        NameCafeLabel.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        NameCafeLabel.setText("Journey Cafe");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(NameCafeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(NameCafeLabel)
                .addGap(20, 20, 20))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        DoneButton.setBackground(new java.awt.Color(234, 255, 234));
        DoneButton.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        DoneButton.setText("DONE");
        DoneButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });

        ResetButton.setBackground(new java.awt.Color(252, 230, 209));
        ResetButton.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        ResetButton.setText("RESET");
        ResetButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        ExitButton.setBackground(new java.awt.Color(239, 220, 220));
        ExitButton.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        ExitButton.setText("EXIT");
        ExitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        baseStrukPanel.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout baseStrukPanelLayout = new javax.swing.GroupLayout(baseStrukPanel);
        baseStrukPanel.setLayout(baseStrukPanelLayout);
        baseStrukPanelLayout.setHorizontalGroup(
            baseStrukPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseStrukPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );
        baseStrukPanelLayout.setVerticalGroup(
            baseStrukPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseStrukPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(102, 102, 102));

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

        totalLabel1.setBackground(new java.awt.Color(255, 255, 255));
        totalLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalLabel1.setForeground(new java.awt.Color(255, 255, 255));
        totalLabel1.setText("Total :");

        paidLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paidLabel.setForeground(new java.awt.Color(255, 255, 255));
        paidLabel.setText("Paid : ");

        paidLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paidLabel1.setForeground(new java.awt.Color(255, 255, 255));
        paidLabel1.setText("BALANCE : ");

        PayButton.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        PayButton.setText("PAY");
        PayButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paidLabel1)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(PayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paidLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paidLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 2, true));
        jPanel2.setAutoscrolls(true);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel1.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel1.setText("Grilled Salmon");

        priceLabel1.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel1.setText("130.000");

        JLabel6.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel1)
                    .addComponent(priceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(JLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(JLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel1)
                .addContainerGap())
        );

        mainTitleLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        mainTitleLabel.setForeground(new java.awt.Color(102, 0, 102));
        mainTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitleLabel.setText("Order Menu");

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel2.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel2.setText("Spagetti");

        priceLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel2.setText("25.000");

        JLabel2.setText(" ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(JLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(JLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel2)
                .addContainerGap())
        );

        meatballPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel3.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel3.setText("Meatball");

        priceLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel3.setText("25.000");

        JLabel3.setText(" ");

        javax.swing.GroupLayout meatballPanelLayout = new javax.swing.GroupLayout(meatballPanel);
        meatballPanel.setLayout(meatballPanelLayout);
        meatballPanelLayout.setHorizontalGroup(
            meatballPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meatballPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(meatballPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(JLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        meatballPanelLayout.setVerticalGroup(
            meatballPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, meatballPanelLayout.createSequentialGroup()
                .addComponent(JLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel3)
                .addContainerGap())
        );

        steakPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel4.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel4.setText("Steak");

        priceLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel4.setText("95.000");

        JLabel4.setText(" ");

        javax.swing.GroupLayout steakPanelLayout = new javax.swing.GroupLayout(steakPanel);
        steakPanel.setLayout(steakPanelLayout);
        steakPanelLayout.setHorizontalGroup(
            steakPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(steakPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(steakPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel4)
                    .addComponent(priceLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(JLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        steakPanelLayout.setVerticalGroup(
            steakPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, steakPanelLayout.createSequentialGroup()
                .addComponent(JLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel4)
                .addContainerGap())
        );

        eggTPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel5.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel5.setText("Egg Toast");

        priceLabel5.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel5.setText("55.000");

        JLabel5.setText(" ");

        javax.swing.GroupLayout eggTPanelLayout = new javax.swing.GroupLayout(eggTPanel);
        eggTPanel.setLayout(eggTPanelLayout);
        eggTPanelLayout.setHorizontalGroup(
            eggTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eggTPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eggTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(JLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        eggTPanelLayout.setVerticalGroup(
            eggTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eggTPanelLayout.createSequentialGroup()
                .addComponent(JLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel5)
                .addContainerGap())
        );

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel6.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel6.setText("Pizza");

        priceLabel6.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel6.setText("100.000");

        JLabel1.setText(" ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceLabel6)
                    .addComponent(nameLabel6)))
            .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel6)
                .addContainerGap())
        );

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel7.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel7.setText("Mango Cake     ");

        priceLabel7.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel7.setText("20.000");

        JLabel7.setText(" ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel7)
                    .addComponent(priceLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(JLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(JLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel7)
                .addContainerGap())
        );

        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel8.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel8.setText("Chicken Steak");

        priceLabel8.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel8.setText("60.000");

        JLabel8.setText(" ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel8)
                    .addComponent(priceLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(JLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(JLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel8)
                .addContainerGap())
        );

        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel9.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel9.setText("Kimchi");

        priceLabel9.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel9.setText("20.000");

        JLabel9.setText(" ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(JLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(JLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel9)
                .addContainerGap())
        );

        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel10.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel10.setText("Lemonade");

        priceLabel10.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel10.setText("18.000");

        JLabel10.setText(" ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(JLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(JLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel10)
                .addContainerGap())
        );

        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));

        nameLabel11.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nameLabel11.setText("Hot Choco");

        priceLabel11.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        priceLabel11.setText("25.000");

        JLabel11.setText(" ");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel11)
                            .addComponent(priceLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(JLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel11)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 169, Short.MAX_VALUE)
                        .addGap(189, 189, 189))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(eggTPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(meatballPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(steakPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meatballPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(steakPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(eggTPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layerPanel1Layout = new javax.swing.GroupLayout(layerPanel1);
        layerPanel1.setLayout(layerPanel1Layout);
        layerPanel1Layout.setHorizontalGroup(
            layerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baseStrukPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layerPanel1Layout.setVerticalGroup(
            layerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layerPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(baseStrukPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoneButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginPage();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PayButtonActionPerformed

    public void setImage(){
//        // tampung file image
//        List<String> imagePaths = Arrays.asList(
//            "src/images/main_pizza.jpg",
//            "src/images/main_meatballSpaggetti.jpg",
//            "src/images/main_meatballSoup.jpg",
//            "src/images/main_steak.jpg",
//            "src/images/main_eggToast.jpg",
//            "src/images/main_mushroomSalmon.jpg",
//            "src/images/d_mangoCake.jpg",
//            "src/images/main_friedChicken.jpg",
//            "src/images/dr_hotChoco.jpg",
//            "src/images/dr_lemonade.jpg"
//        );
//        
//         // List untuk menampung JLabel
//        List<JLabel> labels = Arrays.asList(new JLabel(), new JLabel());
//        
//        // Iterasi untuk memproses tiap gambar dan memasangnya di JLabel
//        for (int i = 0; i < imagePaths.size(); i++) {
//            String imagePath = imagePaths.get(i);
//            JLabel label = labels.get(i);
//
//            // Membuat objek Imagemenu dan mendapatkan image
//            Imagemenu icon = new Imagemenu(imagePath);
//            Image img = icon.getImage().getScaledInstance(label.getWidth(), 140, Image.SCALE_SMOOTH);
//
//            // Set gambar ke JLabel
//            label.setIcon(new ImageIcon(img));
//        }
//        
//        JFrame frame = new JFrame("Image Menu Example");
//        frame.setLayout(new FlowLayout());
//
//        for (JLabel label : labels) {
//            frame.add(label);
//        }
                 
        //manual
        Imagemenu icon1 = new Imagemenu("src/images/main_pizza.jpg");
        Imagemenu icon2 = new Imagemenu("src/images/main_meatballSpaggetti.jpg");
        Imagemenu icon3 = new Imagemenu("src/images/main_meatballSoup.jpg");
        Imagemenu icon4 = new Imagemenu("src/images/main_steak.jpg");
        Imagemenu icon5 = new Imagemenu("src/images/main_eggToast.jpg");
        Imagemenu icon6 = new Imagemenu("src/images/main_mushroomSalmon.jpg");
        Imagemenu icon7 = new Imagemenu("src/images/d_mangoCake.jpg");
        Imagemenu icon8 = new Imagemenu("src/images/main_friedChicken.jpg");
        Imagemenu icon9 = new Imagemenu("src/images/k_kimchi.jpg");
        Imagemenu icon10 = new Imagemenu("src/images/dr_lemonade.jpg");
        Imagemenu icon11 = new Imagemenu("src/images/dr_hotChoco.jpg");
//        169, 180
        Image img1 = icon1.getImage().getScaledInstance(169, 180, Image.SCALE_SMOOTH);
        Image img2 = icon2.getImage().getScaledInstance(169, 180, Image.SCALE_SMOOTH);
        Image img3 = icon3.getImage().getScaledInstance(169, 200, Image.SCALE_SMOOTH);
        Image img4 = icon4.getImage().getScaledInstance(169, 140, Image.SCALE_SMOOTH);
        Image img5 = icon5.getImage().getScaledInstance(169, 140, Image.SCALE_SMOOTH);
        Image img6 = icon6.getImage().getScaledInstance(169, 180, Image.SCALE_SMOOTH);
        Image img7 = icon7.getImage().getScaledInstance(169, 180, Image.SCALE_SMOOTH);
        Image img8 = icon8.getImage().getScaledInstance(169, 180, Image.SCALE_SMOOTH);
        Image img9 = icon9.getImage().getScaledInstance(169, 180, Image.SCALE_SMOOTH);
        Image img10 = icon10.getImage().getScaledInstance(169, 180, Image.SCALE_SMOOTH);
        Image img11 = icon11.getImage().getScaledInstance(169, 180, Image.SCALE_SMOOTH);
        
        JLabel1.setIcon(new ImageIcon(img1));
        JLabel2.setIcon(new ImageIcon(img2));
        JLabel3.setIcon(new ImageIcon(img3));
        JLabel4.setIcon(new ImageIcon(img4));
        JLabel5.setIcon(new ImageIcon(img5));
        JLabel6.setIcon(new ImageIcon(img6));
        JLabel7.setIcon(new ImageIcon(img7));
        JLabel8.setIcon(new ImageIcon(img8));
        JLabel9.setIcon(new ImageIcon(img9));
        JLabel10.setIcon(new ImageIcon(img10));
        JLabel11.setIcon(new ImageIcon(img11));
    }
    public static void main(String args[]) throws IOException {
        

        // Menampilkan gambar di JFrame
//        JFrame frame = new JFrame("Image Menu Example");
//        frame.setLayout(new FlowLayout());
        
        // Label untuk gambar 1
//        JLabel label1 = new JLabel(new ImageIcon(img1));
//        frame.add(label1);
//        JFrame frame = new JFrame();
//        String[] imgPaths ={
//            "src/images/main_pizza.jpg",
//            "src/images/main_meatballSpaggetti.jpg",
//            "src/images/main_meatballSoup.jpg",
//            "src/images/main_steak.jpg",
//            "src/images/main_eggToast.jpg",
//            "src/images/main_mushroomSalmon.jpg",
//            "src/images/d_mangoCake.jpg",
//            "src/images/main_friedChicken.jpg",
//            "src/images/dr_hotChoco.jpg",
//            "src/images/dr_lemonade.jpg"
//
//        };
        
//        List<Image> images = new ArrayList<>();
//
//        for(String path : imgPaths){
//            try{
//                Image img = ImageIO.read(new File(path));
//                images.add(img.getScaledInstance(16, 3, Image.SCALE_SMOOTH));
//            }
//            catch(IOException e) {
//                System.err.println("Tidak dapat memuat gambar " + path);
//                e.printStackTrace();
//            }
//        }
//        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Dashboard().setVisible(true);
                
                
                //jframe gambar menu
//                JFrame frame = new JFrame();
//                frame.setLayout(new GridLayout(2, 5)); // Contoh: 2 baris, 5 kolom
//                frame.setSize(178, 143); // Sesuaikan ukuran frame
//                for (Image img : images) {
//                    JLabel label = new JLabel(new ImageIcon(img));
//                    frame.add(label);
//                }
//        
//                frame.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DoneButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JLabel JLabel1;
    private javax.swing.JLabel JLabel10;
    private javax.swing.JLabel JLabel11;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JLabel JLabel4;
    private javax.swing.JLabel JLabel5;
    private javax.swing.JLabel JLabel6;
    private javax.swing.JLabel JLabel7;
    private javax.swing.JLabel JLabel8;
    private javax.swing.JLabel JLabel9;
    private javax.swing.JLabel NameCafeLabel;
    private javax.swing.JButton PayButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JPanel baseStrukPanel;
    private javax.swing.JPanel eggTPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel layerPanel1;
    private javax.swing.JLabel mainTitleLabel;
    private javax.swing.JPanel meatballPanel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel nameLabel10;
    private javax.swing.JLabel nameLabel11;
    private javax.swing.JLabel nameLabel2;
    private javax.swing.JLabel nameLabel3;
    private javax.swing.JLabel nameLabel4;
    private javax.swing.JLabel nameLabel5;
    private javax.swing.JLabel nameLabel6;
    private javax.swing.JLabel nameLabel7;
    private javax.swing.JLabel nameLabel8;
    private javax.swing.JLabel nameLabel9;
    private javax.swing.JLabel paidLabel;
    private javax.swing.JLabel paidLabel1;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JLabel priceLabel10;
    private javax.swing.JLabel priceLabel11;
    private javax.swing.JLabel priceLabel2;
    private javax.swing.JLabel priceLabel3;
    private javax.swing.JLabel priceLabel4;
    private javax.swing.JLabel priceLabel5;
    private javax.swing.JLabel priceLabel6;
    private javax.swing.JLabel priceLabel7;
    private javax.swing.JLabel priceLabel8;
    private javax.swing.JLabel priceLabel9;
    private javax.swing.JPanel steakPanel;
    private javax.swing.JLabel totalLabel1;
    // End of variables declaration//GEN-END:variables

    private void setDefaultCloseOperation(JFrame jframe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
