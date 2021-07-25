/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.client;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tramdb.armor.ArmorDTO;
import tramdb.armor.ArmorInterface;
import tramdb.util.MyValidation;

/**
 *
 * @author yiyangqianxi
 */
public class MainFrame extends javax.swing.JFrame {

    private Vector<ArmorDTO> listArmor = null;  //list armor
    private ArmorInterface server = null;       //interface to interact with server
    private DefaultTableModel model = null;     //table model
    private int position = -1;  //position selected from table

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        //connect to server via rmi
        try {
            server = (ArmorInterface) Naming.lookup("rmi://127.0.0.1:9999/armorServer");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Method load armor to table
     */
    private void loadArmor() {
        //check if server is not available
        if (server != null) {
            //add header
            Vector<String> headerTable = new Vector<>();
            headerTable.add("ID");
            headerTable.add("Classification");
            headerTable.add("TimeOfCreate");
            headerTable.add("Defense");
            //create data vector to store armor for add to table
            Vector dataTable = new Vector();
            //try catch error from server
            try {
                //load armor from server
                listArmor = (Vector<ArmorDTO>) server.findAllArmor();

            } catch (Exception e) {
                e.printStackTrace();
            }
            //add armor from to data vector
            for (ArmorDTO armorDTO : listArmor) {
                //create row vector to store each feild
                Vector rowTable = new Vector();
                //add field to row vector
                rowTable.add(armorDTO.getArmorID());
                rowTable.add(armorDTO.getClassification());
                rowTable.add(convertDateToString(armorDTO.getTimeOfCreate()));
                rowTable.add(armorDTO.getDefense());
                //add each row to data vector
                dataTable.add(rowTable);
            }
            //get Model from tblArmor
            model = (DefaultTableModel) tblArmor.getModel();
            //add data to model
            model.setDataVector(dataTable, headerTable);
        } else {
            //notify
            JOptionPane.showMessageDialog(this, "Server not founded");
        }
    }

    /**
     * Set each field on detail part
     *
     * @param armor
     */
    private void setField(ArmorDTO armor) {
        txtArmorID.setText(armor.getArmorID());
        txtArmorID.setEnabled(false);
        txtClassfication.setText(armor.getClassification());
        txtTimeOfCreate.setText(convertDateToString(armor.getTimeOfCreate()));
        txtDefense.setText("" + armor.getDefense());
        txtDescription.setText(armor.getDescription());
        txtStatus.setText(armor.getStatus());
    }

    /**
     * Convert date format to string format dd/MM/yyyy
     *
     * @param date
     * @return String
     */
    private String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    private Date convertStringToDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Validate each field inputted
     *
     * @param armorID
     * @param classification
     * @param defense
     * @param description
     * @return true or false
     */
    private boolean validateArmor(String armorID, String classification,
            String defense, String description) {
        if (!MyValidation.checkArmorID(armorID)) {
            JOptionPane.showMessageDialog(this, "ArmorID isn't valid. Not have "
                    + "(@, #, $) and not more than 10 characters");
            return false;
        } else if (!MyValidation.checkClassification(classification)) {
            JOptionPane.showMessageDialog(this, "Classification isn't valid. "
                    + "Not more than 30 characters");
            return false;
        } else if (!MyValidation.checkDefense(defense)) {
            JOptionPane.showMessageDialog(this, "Defense isn't valid. Number "
                    + " only and not less than 0");
            return false;
        } else if (!MyValidation.checkDescription(description)) {
            JOptionPane.showMessageDialog(this, "Description isn't valid. Not"
                    + " more than 300 characters");
            return false;
        }
        return true;
    }

    /**
     * Set all field to none
     */
    private void setNone() {
        txtArmorID.setText("");
        txtArmorID.setEnabled(true);
        txtClassfication.setText("");
        txtTimeOfCreate.setText("");
        txtDefense.setText("");
        txtDescription.setText("");
        txtStatus.setText("");
        position = -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArmorClient = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblArmor = new javax.swing.JTable();
        btnGetAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblEmpID = new javax.swing.JLabel();
        lblFullname = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        txtArmorID = new javax.swing.JTextField();
        txtClassfication = new javax.swing.JTextField();
        txtTimeOfCreate = new javax.swing.JTextField();
        txtDefense = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        JScrollPanle = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblArmorClient.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblArmorClient.setForeground(new java.awt.Color(0, 0, 255));
        lblArmorClient.setText("Armor Client");

        tblArmor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArmor.getTableHeader().setReorderingAllowed(false);
        tblArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArmorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblArmor);

        btnGetAll.setText("Get All");
        btnGetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetAllActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Armor's Detail"));
        jPanel1.setToolTipText("");
        jPanel1.setFocusable(false);
        jPanel1.setName(""); // NOI18N

        lblEmpID.setText("ArmorID:");

        lblFullname.setText("Classification:");

        lblPhone.setText("TimeOfCreate:");

        lblEmail.setText("Defense:");

        lblAddress.setText("Description:");

        lblDOB.setText("Status:");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnFind.setText("Find By ArmorID");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        JScrollPanle.setViewportView(txtDescription);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFullname)
                            .addComponent(lblEmpID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArmorID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClassfication, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCreate)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDOB, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JScrollPanle)
                                    .addComponent(txtTimeOfCreate)
                                    .addComponent(txtDefense)
                                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemove)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpID)
                    .addComponent(btnFind)
                    .addComponent(txtArmorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullname)
                    .addComponent(txtClassfication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimeOfCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JScrollPanle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblAddress)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDOB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove)
                    .addComponent(btnClear))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(lblArmorClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(504, 504, 504))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btnGetAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblArmorClient)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnGetAll)))
                .addGap(25, 25, 25))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetAllActionPerformed
        loadArmor();
    }//GEN-LAST:event_btnGetAllActionPerformed

    private void tblArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArmorMouseClicked
        position = tblArmor.getSelectedRow();
        String armorID = (String) tblArmor.getValueAt(position, 0);
        try {
            ArmorDTO armor = server.findByArmorID(armorID);
            setField(armor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblArmorMouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String armorID = txtArmorID.getText();
        ArmorDTO armor = null;
        try {
            armor = server.findByArmorID(armorID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (armor != null) {
            setField(armor);
        } else {
            JOptionPane.showMessageDialog(this, "Armor ID not founded");
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String armorID = txtArmorID.getText().trim();
        String classification = txtClassfication.getText().trim();
        Date date = new Date();
        String defense = txtDefense.getText().trim();
        String description = txtDescription.getText().trim();
        String status = txtStatus.getText().trim();

        boolean isValid = false;

        if (validateArmor(armorID, classification, defense, description)) {
            ArmorDTO armor = new ArmorDTO(armorID, classification, description,
                    status, date, Integer.parseInt(defense));
            try {
                isValid = server.createArmor(armor);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isValid) {
                JOptionPane.showMessageDialog(this, "Create succesful");
                loadArmor();
                setNone();
            } else {
                JOptionPane.showMessageDialog(this, "Armor ID already existed");
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (position != -1) {
            if (JOptionPane.showConfirmDialog(this, "Do you want to remove?")
                    == JOptionPane.OK_OPTION) {
                String armorID = txtArmorID.getText();
                boolean isRemoved = false;
                try {
                    isRemoved = server.removeArmor(armorID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (isRemoved) {
                    JOptionPane.showMessageDialog(this, "Remove successful");
                    setNone();
                    loadArmor();
                } else {
                    JOptionPane.showMessageDialog(this, "Remove fail");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Choose armor to remove");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        setNone();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (position != -1) {
            String armorID = txtArmorID.getText().trim();
            String classfication = txtClassfication.getText().trim();
            String date = txtTimeOfCreate.getText().trim();
            String defense = txtDefense.getText().trim();
            String description = txtDescription.getText().trim();
            String status = txtStatus.getText().trim();
            if (validateArmor(armorID, classfication, defense, description)
                    && MyValidation.checkDate(date)) {
                ArmorDTO armor = new ArmorDTO(armorID, classfication, description,
                        status, convertStringToDate(date), Integer.parseInt(defense));
                boolean isUpdated = false;
                try {
                    isUpdated = server.updateArmor(armor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "Update successful");
                    setNone();
                    loadArmor();
                } else {
                    JOptionPane.showMessageDialog(this, "Udpate fail");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Choose armor to update");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPanle;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnGetAll;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblArmorClient;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmpID;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTable tblArmor;
    private javax.swing.JTextField txtArmorID;
    private javax.swing.JTextField txtClassfication;
    private javax.swing.JTextField txtDefense;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTimeOfCreate;
    // End of variables declaration//GEN-END:variables
}
