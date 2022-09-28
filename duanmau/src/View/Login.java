/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.NhanVien_DAO;
import JDBC.DateHelper;
import JDBC.dialogHelper;
import JDBC.shareHelper;
import Model.NhanVien;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author THIS PC
 */
public class Login extends javax.swing.JFrame {
    private FormChinh FormChinh;
    private ImageIcon icOff, icOn;
    private boolean showpass;
    private NhanVien nv;

    public Login() {
        initComponents();
        this.FormChinh = new FormChinh();
        this.icOn = new ImageIcon("src/Image/visibility.png");
        this.icOff = new ImageIcon("src/Image/visibility_lock.png");
        setLocationRelativeTo(null);
        nv = nv;
    }
    
    NhanVien_DAO dao=new NhanVien_DAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenNhap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassWord = new javax.swing.JPasswordField();
        btnDangnhap = new javax.swing.JButton();
        btnketthuc = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_show = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/security.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tên đăng nhập");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mật khẩu");

        txtPassWord.setAutoscrolls(false);
        txtPassWord.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPassWord.setMinimumSize(new java.awt.Dimension(6, 27));

        btnDangnhap.setText("Đăng Nhập");
        btnDangnhap.setIconTextGap(6);
        btnDangnhap.setMaximumSize(new java.awt.Dimension(150, 60));
        btnDangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangnhapActionPerformed(evt);
            }
        });

        btnketthuc.setText("Kết Thúc");
        btnketthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnketthucActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("ĐĂNG NHẬP");

        lbl_show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/visibility.png"))); // NOI18N
        lbl_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_showMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnketthuc))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(txtPassWord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_show)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(txtTenNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassWord, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnketthuc))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    void login() {
        String manv = txtTenNhap.getText();
        String matKhau = new String(txtPassWord.getPassword());
        try {
            NhanVien nhanVien = dao.findById(manv); 
            /*
            manv là tên đăng nhập
            nhanVien findbyId(String manv)
            */
            if(nhanVien != null){    //nếu manv đúng
                String matKhau2 = nhanVien.getMatKhau();
                if(matKhau.equals(matKhau2)){  //nếu mật khẩu đúng
                    shareHelper.USER = nhanVien;
                    dialogHelper.alert(this, "Đăng nhập thành công!");
                    this.dispose();
                }
                else{
                    dialogHelper.alert(this, "Sai mật khẩu!");
                }
            }
            else{
                dialogHelper.alert(this, "Sai tên đăng nhập!");
            }
        }
        catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
 }
    
    private void btnDangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangnhapActionPerformed
//        if (kiemtra()) {
//            try {
//                String sql = "SELECT * FROM NhanVien WHERE manv = ? and MatKhau = ?";
//                PreparedStatement ps = JDBC.KetNoi.prepare(sql);
//                ps.setString(1, this.txtTenNhap.getText());
//                ps.setString(2, String.valueOf(this.txtPassWord.getPassword()));
//                ResultSet rs = ps.executeQuery();
//                if (rs.next() == true) {
//                    int vaitro = rs.getInt("vaiTro");
//                    if (vaitro == 1) {
//                        JOptionPane.showMessageDialog(this, "Login succesfully!");
//                        new FormChinh().setVisible(true);
//                        this.dispose();
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Login succesfully!");
//                        new FormChinh().setVisible(true);
//                        this.dispose();
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "Login Failed!");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        
            //////////////////
            txtTenNhap.setBackground(white);
        txtPassWord.setBackground(white);
        if(txtTenNhap.getText().trim().length()>0){
            if(txtPassWord.getPassword().length>0){
                login();
                new FormChinh().setVisible(true);
            }else{
                txtPassWord.setBackground(pink);
                dialogHelper.alert(this, "Không được để trống tên mật khẩu");
            }
        }else{
            txtTenNhap.setBackground(pink);
            dialogHelper.alert(this, "Không được để trống tên đăng nhập");
        }
    }//GEN-LAST:event_btnDangnhapActionPerformed

//    public List<DateHelper> getvt(){
//        List<DateHelper> a = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM NhanVien WHERE manv = ? and MatKhau = ?";
//            PreparedStatement ps = JDBC.KetNoi.prepare(sql);
//            ps.setString(1, this.txtTenNhap.getText());
//            ps.setString(2, String.valueOf(this.txtPassWord.getPassword()));
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                int vt = rs.getInt("vaiTro");
//                DateHelper d = new DateHelper(vt);
//                a.add(d);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return a;
//    }
    
    private void btnketthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnketthucActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát hay không?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ret == JOptionPane.YES_OPTION) {
            System.exit(0);
        } 
    }//GEN-LAST:event_btnketthucActionPerformed

    private void lbl_showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_showMouseClicked
        this.showpass = !this.showpass;
        if (this.showpass) {
            this.lbl_show.setIcon(icOff);
            this.txtPassWord.setEchoChar((char)0);
        }else{
            this.lbl_show.setIcon(icOn);
            this.txtPassWord.setEchoChar('*');
        }
    }//GEN-LAST:event_lbl_showMouseClicked

    public boolean kiemtra() {
        if (this.txtTenNhap.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống Username");
            return false;
        } else if (this.txtPassWord.getPassword().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống Password");
            return false;
        }
        return true;
    }
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangnhap;
    private javax.swing.JButton btnketthuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_show;
    private javax.swing.JPasswordField txtPassWord;
    private javax.swing.JTextField txtTenNhap;
    // End of variables declaration//GEN-END:variables
}
