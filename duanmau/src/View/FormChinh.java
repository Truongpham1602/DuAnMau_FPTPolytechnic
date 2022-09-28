/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.NhanVien_DAO;
import JDBC.DateHelper;
import JDBC.NewClass;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author THIS PC
 */
public class FormChinh extends javax.swing.JFrame implements Runnable{
    /**
     * Creates new form CuaSoChinh
     */
    public FormChinh() {
        initComponents();
        Thread t = new Thread(this);
        t.start();
        setLocationRelativeTo(null);
        init();
    }

    void init(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);    //cho toàn màn hình 
//        Dimension desSize = DesktopPane.getSize();
//        Dimension interFrameSize = nv.getSize();
//        nv.setLocation((desSize.width - interFrameSize.width)/2,(desSize.height - interFrameSize.height)/2); sét ra giữa màn hình 
    }
   
    public void openX(JInternalFrame x) {
        for (JInternalFrame frmChild : DesktopPane.getAllFrames()) {
            frmChild.dispose();
        }
        x.setLocation(this.getWidth() / 2 - x.getWidth() / 2,
                (this.getHeight() - 20) / 2 - x.getHeight() / 2 - 60);
        DesktopPane.add(x);
        x.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        Pane1 = new javax.swing.JPanel();
        DesktopPane = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        btn_dangXuat = new javax.swing.JButton();
        btn_ketthuc = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btn_chuyende = new javax.swing.JButton();
        btn_nghoc = new javax.swing.JButton();
        btn_khoahoc = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btn_huongdan = new javax.swing.JButton();
        lbl_ongvang = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_dongho = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MItem_dangnhap = new javax.swing.JMenuItem();
        MItem_dangXuat = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MItem_doiMK = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MItem_Ketthuc = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MItem_nghoc = new javax.swing.JMenuItem();
        MItem_chuyenDe = new javax.swing.JMenuItem();
        MItem_khoahoc = new javax.swing.JMenuItem();
        MItem_NhanVien = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MItem_luongNgHoc = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MItem_bangDiem = new javax.swing.JMenuItem();
        MItem_DiemCD = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        MItem_doanhThu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        MItem_huongDanSD = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        MItem_GTSP = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        jMenuItem7.setText("jMenuItem7");

        jMenuItem8.setText("jMenuItem8");

        jMenuItem9.setText("jMenuItem9");

        jMenuItem10.setText("jMenuItem10");

        jMenuItem11.setText("jMenuItem11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HỆ THỐNG QUẢN LÝ ĐÀO TẠO");

        DesktopPane.setBackground(new java.awt.Color(204, 255, 255));
        DesktopPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DesktopPaneMouseReleased(evt);
            }
        });

        jToolBar1.setRollover(true);

        btn_dangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Exit.png"))); // NOI18N
        btn_dangXuat.setText("Đăng xuất");
        btn_dangXuat.setFocusable(false);
        btn_dangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_dangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_dangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangXuatActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_dangXuat);

        btn_ketthuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Stop.png"))); // NOI18N
        btn_ketthuc.setText("Kết thúc");
        btn_ketthuc.setFocusable(false);
        btn_ketthuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_ketthuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_ketthuc);
        jToolBar1.add(jSeparator6);

        btn_chuyende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Lists.png"))); // NOI18N
        btn_chuyende.setText("Chuyên đề");
        btn_chuyende.setFocusable(false);
        btn_chuyende.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_chuyende.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_chuyende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chuyendeActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_chuyende);

        btn_nghoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Conference.png"))); // NOI18N
        btn_nghoc.setText("Người học");
        btn_nghoc.setFocusable(false);
        btn_nghoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nghoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_nghoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nghocActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_nghoc);

        btn_khoahoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Certificate.png"))); // NOI18N
        btn_khoahoc.setText("Khóa học");
        btn_khoahoc.setFocusable(false);
        btn_khoahoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_khoahoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_khoahoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khoahocActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_khoahoc);
        jToolBar1.add(jSeparator7);

        btn_huongdan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Globe.png"))); // NOI18N
        btn_huongdan.setText("Hưỡng dẫn");
        btn_huongdan.setFocusable(false);
        btn_huongdan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_huongdan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_huongdan);

        lbl_ongvang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ongvang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/18198154_10208600482868814_3469513_n-234x375.png"))); // NOI18N

        DesktopPane.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(lbl_ongvang, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_ongvang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_ongvang, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Pane1Layout = new javax.swing.GroupLayout(Pane1);
        Pane1.setLayout(Pane1Layout);
        Pane1Layout.setHorizontalGroup(
            Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
        );
        Pane1Layout.setVerticalGroup(
            Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Info.png"))); // NOI18N
        jLabel1.setText("Hệ quản lý đào tạo");

        lbl_dongho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Alarm.png"))); // NOI18N
        lbl_dongho.setText("00:00:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 657, Short.MAX_VALUE)
                .addComponent(lbl_dongho, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_dongho)))
        );

        jMenu1.setText("Hệ thống");

        MItem_dangnhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        MItem_dangnhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Key.png"))); // NOI18N
        MItem_dangnhap.setText("Đăng nhập");
        jMenu1.add(MItem_dangnhap);

        MItem_dangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        MItem_dangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Log out.png"))); // NOI18N
        MItem_dangXuat.setText("Đăng xuất");
        MItem_dangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MItem_dangXuatActionPerformed(evt);
            }
        });
        jMenu1.add(MItem_dangXuat);
        jMenu1.add(jSeparator1);

        MItem_doiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Refresh.png"))); // NOI18N
        MItem_doiMK.setText("Đổi mật khẩu");
        MItem_doiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MItem_doiMKActionPerformed(evt);
            }
        });
        jMenu1.add(MItem_doiMK);
        jMenu1.add(jSeparator2);

        MItem_Ketthuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        MItem_Ketthuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Stop.png"))); // NOI18N
        MItem_Ketthuc.setText("Kết thúc");
        jMenu1.add(MItem_Ketthuc);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Quản lý");

        MItem_nghoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_MASK));
        MItem_nghoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Conference.png"))); // NOI18N
        MItem_nghoc.setText("Người học");
        MItem_nghoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MItem_nghocActionPerformed(evt);
            }
        });
        jMenu2.add(MItem_nghoc);

        MItem_chuyenDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        MItem_chuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Lists.png"))); // NOI18N
        MItem_chuyenDe.setText("Chuyên đề");
        MItem_chuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MItem_chuyenDeActionPerformed(evt);
            }
        });
        jMenu2.add(MItem_chuyenDe);

        MItem_khoahoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        MItem_khoahoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Certificate.png"))); // NOI18N
        MItem_khoahoc.setText("Khóa học");
        MItem_khoahoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MItem_khoahocActionPerformed(evt);
            }
        });
        jMenu2.add(MItem_khoahoc);

        MItem_NhanVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_MASK));
        MItem_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/User group.png"))); // NOI18N
        MItem_NhanVien.setText("Quản lý nhân viên");
        MItem_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MItem_NhanVienActionPerformed(evt);
            }
        });
        jMenu2.add(MItem_NhanVien);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Thống kê");

        MItem_luongNgHoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_MASK));
        MItem_luongNgHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Clien list.png"))); // NOI18N
        MItem_luongNgHoc.setText("Lượng người học");
        jMenu3.add(MItem_luongNgHoc);
        jMenu3.add(jSeparator4);

        MItem_bangDiem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_MASK));
        MItem_bangDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Card file.png"))); // NOI18N
        MItem_bangDiem.setText("Bảng điểm");
        jMenu3.add(MItem_bangDiem);

        MItem_DiemCD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_MASK));
        MItem_DiemCD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Bar chart.png"))); // NOI18N
        MItem_DiemCD.setText("Điểm chuyên đề");
        jMenu3.add(MItem_DiemCD);
        jMenu3.add(jSeparator8);

        MItem_doanhThu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_MASK));
        MItem_doanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Dollar.png"))); // NOI18N
        MItem_doanhThu.setText("Doanh thu");
        jMenu3.add(MItem_doanhThu);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Trợ giúp");

        MItem_huongDanSD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        MItem_huongDanSD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Globe.png"))); // NOI18N
        MItem_huongDanSD.setText("Hướng dẫn sử dụng");
        jMenu4.add(MItem_huongDanSD);
        jMenu4.add(jSeparator5);

        MItem_GTSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Brick house.png"))); // NOI18N
        MItem_GTSP.setText("Giới thiệu sản phẩm");
        jMenu4.add(MItem_GTSP);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Pane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoiMatKhau(){
        DoiMK j = new DoiMK();
        openX(j);
    }
    
    private void MItem_doiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MItem_doiMKActionPerformed
        this.DoiMatKhau();
    }//GEN-LAST:event_MItem_doiMKActionPerformed

    private void DangXuat(){
        int ret = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất không?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ret == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        } 
    }
    
    private void NguoiHoc(){
        IF_NguoiHoc ngh = new IF_NguoiHoc();
        openX(ngh);
    }
    
    private void QLNhanVien(){
//        Login l = new Login();
//        List<DateHelper> zxc = l.getvt();
//        for (DateHelper h : zxc) {
//            System.out.println(h.getVaitro());
//            System.out.println("da");
//            if (h.getVaitro() == 1) {
                IF_QLNV nv = new IF_QLNV();
                openX(nv);
//                return;
//            }else{
//                continue;
//            }
//        }
//            JOptionPane.showMessageDialog(this, "Vui lòng đăng nhập");
    }
    
    private void QLChuyenDe(){
        IF_QLCD cd = new IF_QLCD();
        openX(cd);
    }
    
    private void KhoaHoc(){
        IF_KhoaHoc kh = new IF_KhoaHoc();
        openX(kh);
    }
    
    private void showPopup(MouseEvent e) {
//        if (e.isPopupTrigger()) {
//            popupMenu.show(e.getComponent(),
//                    e.getX(), e.getY());
//        }
    }
    
    private void btn_dangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangXuatActionPerformed
        this.DangXuat();
    }//GEN-LAST:event_btn_dangXuatActionPerformed

    private void MItem_dangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MItem_dangXuatActionPerformed
        this.DangXuat();
    }//GEN-LAST:event_MItem_dangXuatActionPerformed

    private void MItem_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MItem_NhanVienActionPerformed
        this.QLNhanVien();
    }//GEN-LAST:event_MItem_NhanVienActionPerformed

    private void btn_chuyendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chuyendeActionPerformed
        this.QLChuyenDe();
    }//GEN-LAST:event_btn_chuyendeActionPerformed

    private void btn_khoahocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khoahocActionPerformed
        this.KhoaHoc();
    }//GEN-LAST:event_btn_khoahocActionPerformed

    private void MItem_khoahocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MItem_khoahocActionPerformed
        this.KhoaHoc();
    }//GEN-LAST:event_MItem_khoahocActionPerformed

    private void btn_nghocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nghocActionPerformed
        this.NguoiHoc();
    }//GEN-LAST:event_btn_nghocActionPerformed

    private void MItem_nghocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MItem_nghocActionPerformed
        this.NguoiHoc();
    }//GEN-LAST:event_MItem_nghocActionPerformed

    private void MItem_chuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MItem_chuyenDeActionPerformed
        this.QLChuyenDe();
    }//GEN-LAST:event_MItem_chuyenDeActionPerformed

    private void DesktopPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DesktopPaneMouseReleased
        this.showPopup(evt);
    }//GEN-LAST:event_DesktopPaneMouseReleased

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
            java.util.logging.Logger.getLogger(FormChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenuItem MItem_DiemCD;
    private javax.swing.JMenuItem MItem_GTSP;
    private javax.swing.JMenuItem MItem_Ketthuc;
    private javax.swing.JMenuItem MItem_NhanVien;
    private javax.swing.JMenuItem MItem_bangDiem;
    private javax.swing.JMenuItem MItem_chuyenDe;
    private javax.swing.JMenuItem MItem_dangXuat;
    private javax.swing.JMenuItem MItem_dangnhap;
    private javax.swing.JMenuItem MItem_doanhThu;
    private javax.swing.JMenuItem MItem_doiMK;
    private javax.swing.JMenuItem MItem_huongDanSD;
    private javax.swing.JMenuItem MItem_khoahoc;
    private javax.swing.JMenuItem MItem_luongNgHoc;
    private javax.swing.JMenuItem MItem_nghoc;
    private javax.swing.JPanel Pane1;
    private javax.swing.JButton btn_chuyende;
    private javax.swing.JButton btn_dangXuat;
    private javax.swing.JButton btn_huongdan;
    private javax.swing.JButton btn_ketthuc;
    private javax.swing.JButton btn_khoahoc;
    private javax.swing.JButton btn_nghoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_dongho;
    private javax.swing.JLabel lbl_ongvang;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
        while (true) {            
            Date d = new Date();
            this.lbl_dongho.setText(sdf.format(d));
        }
    }
}
