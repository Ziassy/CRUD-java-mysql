/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

/**
 *
 * @author 5470
 */
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class formData extends javax.swing.JFrame {

    /**
     * Creates new form formData
     */
    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.KoneksiDatabase.BukaKoneksi();
    
    public formData() {
        initComponents();
        ShowData();
    }
    
    //untuk clear field
    private void Clear(){
        txtNIK.setText("");
        txtName.setText("");
        txtTanggalLahir.setText("");
        txtAlamat.setText("");
        
        btnSave.setText("Simpan");
        txtNIK.setEditable(true);

    }
    
    private void ShowData() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM patient_tp2.pasien");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Nama Pasien");
            model.addColumn("NIK");
            model.addColumn("Tanggal Lahir");
            model.addColumn("Alamat");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MMM-dd");
            
            while (rs.next()) {
            Date tglLahir = rs.getDate("tgl_lahir"); // Retrieve the date from the result set
            String tglLahirStr = outputDateFormat.format(tglLahir); // Convert date to string in the desired format
            Object[] dataPasien = {
                rs.getString("no"),
                rs.getString("nama_pasien"),
                rs.getString("nik"),
                tglLahirStr, // Use the converted date string,
                rs.getString("alamat")
            };
            model.addRow(dataPasien);
            TableData.setModel(model); // Set table model outside of the loop
        }

            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam get data: " + e.getMessage());

         }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNIK = new javax.swing.JTextField();
        txtTanggalLahir = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableData = new javax.swing.JTable();
        btnDeleteData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("NIK");

        jLabel3.setText("Tangal Lahir");

        jLabel4.setText("Alamat");

        jLabel5.setText("Nama Pasien");

        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });

        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        TableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama Pasien", "NIK", "Tanggal Lahir", "Alamat"
            }
        ));
        TableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableData);

        btnDeleteData.setText("Hapus");
        btnDeleteData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(26, 26, 26)
                                .addComponent(btnDeleteData)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtName)
                            .addComponent(txtNIK)
                            .addComponent(txtAlamat)
                            .addComponent(txtTanggalLahir))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addComponent(txtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(txtTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnReset)
                    .addComponent(btnDeleteData))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
        try {
            st = cn.createStatement();
            if(txtNIK.getText().isEmpty() || txtName.getText().isEmpty() || txtTanggalLahir.getText().isEmpty() || txtAlamat.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong",  "Validasi data", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            // Untuk simpan data
            if (btnSave.getText().equals("Simpan")) {

                String cek = "SELECT * FROM patient_tp2.pasien WHERE nik = '" + txtNIK.getText() + "'";
                rs = st.executeQuery(cek);

                if(rs.next()) {
                    JOptionPane.showMessageDialog(null, "Nik sudah terdaftar");
                } else {
                    String sql = "INSERT INTO patient_tp2.pasien (nama_pasien, nik, tgl_lahir, alamat) VALUES ('" + txtName.getText() + 
                            "','" + txtNIK.getText() + 
                            "','" + txtTanggalLahir.getText() +
                            "','" + txtAlamat.getText() + "')";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
                    Clear();
                    ShowData();

                }
            } else {
                // untuk update data
                try {
                    String updateData = "UPDATE patient_tp2.pasien SET nama_pasien = '" + txtName.getText() + 
                        "', nik = '" + txtNIK.getText() +
                        "', tgl_lahir = '" + txtTanggalLahir.getText() +
                        "', alamat = '" + txtAlamat.getText() +
                        "' WHERE nik = '" + txtNIK.getText() + "'";
                    st.executeUpdate(updateData);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah");
                    Clear();
                    ShowData();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam update data :  " + e.getMessage()); 
                    
                }
                
            }
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam save data : " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam konversi angka: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void TableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDataMouseClicked
        // TODO add your handling code here:
        txtName.setText(TableData.getValueAt(TableData.getSelectedRow(), 1).toString());
        txtNIK.setText(TableData.getValueAt(TableData.getSelectedRow(), 2).toString());
//        txtTanggalLahir.setText(TableData.getValueAt(TableData.getSelectedRow(), 3).toString());
            String txtTanggalLahirValue = TableData.getValueAt(TableData.getSelectedRow(), 3).toString();
        // Convert txtTanggalLahir to yyyy-MM-dd format
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MMM-dd"); // Update the pattern to match txtTanggalLahir format
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = new Date(inputFormat.parse(txtTanggalLahirValue).getTime()); // Convert to java.sql.Dat
            String formattedDate = outputFormat.format(date);
            txtTanggalLahir.setText(formattedDate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } 

        txtAlamat.setText(TableData.getValueAt(TableData.getSelectedRow(), 4).toString());
        
        // buat nik disable
        txtNIK.setEditable(false);
        btnSave.setText("Ubah Data");   
        
    }//GEN-LAST:event_TableDataMouseClicked

    private void btnDeleteDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDataActionPerformed
        // TODO add your handling code here:
        if (txtNIK.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan di hapus !");
        } else {
            int answer = JOptionPane.showConfirmDialog(null, "Apakah ingin menhapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(answer == 0) {
                try {
                    st = cn.createStatement();
                    String sql = "DELETE FROM patient_tp2.pasien WHERE nik = '" + txtNIK.getText()+ "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                    ShowData();
                    Clear();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                }
            }
        }
    }//GEN-LAST:event_btnDeleteDataActionPerformed

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
            java.util.logging.Logger.getLogger(formData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableData;
    private javax.swing.JButton btnDeleteData;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTanggalLahir;
    // End of variables declaration//GEN-END:variables
}
