/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ChuyenDe_DAO;
import DAO.KhoaHoc_DAO;
import JDBC.DateHelper;
import JDBC.dialogHelper;
import JDBC.shareHelper;
import JDBC.utilityHelper;
import Model.ChuyenDe;
import Model.KhoaHoc;
import Model.NhanVien;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THIS PC
 */
public class IF_KhoaHoc extends javax.swing.JInternalFrame {
//    private List<KhoaHoc> lstKH;
//    private KhoaHoc_DAO KH_DAO;
//    private DefaultTableModel model;
//    private int vitri;
    /**
     * Creates new form IF_KhoaHoc
     */
    public IF_KhoaHoc() {
        initComponents();
//        this.KH_DAO = new KhoaHoc_DAO();
//        this.model = (DefaultTableModel) this.tbl_Table.getModel();
//        this.getAll();
        this.tab.setSelectedIndex(1);
    }
    
    int index = 0;  //vị trí khoaHoc đang được chọn    
    KhoaHoc_DAO dao = new KhoaHoc_DAO();
    ChuyenDe_DAO cddao = new ChuyenDe_DAO();

//    private void QLHocVien(){
////        Integer id = Integer.valueOf(this.cbb_chuyende.getToolTipText());
//        new IF_QLHocVien().setVisible(true);
//        this.getAll();
//    }
    
//    private void getAll(){
//        this.model.setRowCount(0);
//        this.lstKH = this.KH_DAO.getAll();
//        for (KhoaHoc kh : lstKH) {
//            Object [] r = new Object[]{
//                kh.getMaKH(),
//                kh.getMaCD(),
//                kh.getThoiLuong(),
//                kh.getHocPhi(),
//                kh.getNgayKG(),
//                kh.getMaNV(),
//                kh.getNgayTao(),
//            };
//            this.model.addRow(r);
//        }
//    }
    
    void load() {
        DefaultTableModel model = (DefaultTableModel) tbl_Table.getModel();
        model.setRowCount(0);
        try {
            List<KhoaHoc> list = dao.select();
            for (KhoaHoc kh : list) {
                Object[] row = {
                    kh.getMaKH(),
                    kh.getMaCD(),
                    kh.getThoiLuong(),
                    kh.getHocPhi(),
                    DateHelper.toString(kh.getNgayKG()),
                    kh.getMaNV(),
                    DateHelper.toString(kh.getNgayTao())
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    void insert() {
        KhoaHoc model = getModel();
        model.setNgayTao(DateHelper.now());
        try {
            dao.insert(model);
            this.load();
            this.clear();
            dialogHelper.alert(this, "Thêm mới thành công!");
        } catch (HeadlessException e) {
            dialogHelper.alert(this, "Thêm mới thất bại!");
        }
    }
    
    //lấy thông tin trên form cho vào đt khoaHoc
    //cập nhật bản ghi trong CSDL theo maKH và thông tin khác từ đt khoaHoc
    //load lại bảng
    void update() {
        KhoaHoc model = getModel();
        try {
            dao.update(model);
            this.load();
            this.clear();
            dialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            dialogHelper.alert(this, "Cập nhật thất bại!");
        }
    }

    //xóa bản ghi trong CSDL theo maKH lấu trên form
    //load lại bảng, xóa trắng form, chuyển sang insertable
    void delete() {
        if (dialogHelper.confirm(this, "Bạn thực sự muốn xóa khóa học này?")) {
            Integer makh = Integer.valueOf(cbb_chuyende.getToolTipText()); //maKH để nhờ ở toolTipText
            try {
                dao.delete(makh);
                this.load();
                this.clear();
                dialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                dialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    public void setTrang(){
        txt_ngayKG.setBackground(white);
    }
    //xóa trắng form, chuyển sang insertable
    void clear() {
        setTrang();
        KhoaHoc model = new KhoaHoc();
        ChuyenDe chuyenDe = (ChuyenDe) cbb_chuyende.getSelectedItem();//lấy chuyenDe đang đc chọn ở combobox
        cbb_chuyende.setToolTipText(""); //tự viết thêm, ko cần thiết
        model.setMaCD(chuyenDe.getMaCD()); 
        model.setMaNV(shareHelper.USER.getMaNV());   //người tạo là nhanVien đang đăng nhập
        model.setNgayKG(DateHelper.add(30));  //ngày khai giảng sau ngày tạo 30 ngày
        model.setNgayTao(DateHelper.now());   //ngày tạo là ngày hiện tại
        this.setModel(model);
        setStatus(true); //tự thêm
    }

    //lấy maKH từ bảng theo index, lấy đt khoaHoc từ CSDL theo maKH
    // đưa thông tin từ đt khoaHoc lên form, chuyển sang editable
    void edit() {
        setTrang();
        try {
            Integer makh = (Integer) tbl_Table.getValueAt(this.index, 0);
            KhoaHoc model = dao.findById(makh);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    //điền thông tin từ đt khoaHoc vào form
    void setModel(KhoaHoc model) {
       cbb_chuyende.setToolTipText(String.valueOf(model.getMaKH()));    
        //để nhờ maKH ở tooltipText vì ko có chỗ để trên form
        //vì maKH này trong CSDL là tự sinh từ 1 đến hết ko cần nhập trên form
        cbb_chuyende.getModel().setSelectedItem(cddao.findById(model.getMaCD())); 
        //lưu ý thêm getModel() khi áp dụng với đối tượng, ko cần thêm khi dùng với String VD: cbo.setSelectedItem("Item A");
        //tìm đt chuyenDe theo maCD rồi setSelectedItem cho combobox
        txt_ngayKG.setText(DateHelper.toString(model.getNgayKG()));
        txt_hocphi.setText(String.valueOf(model.getHocPhi()));
        txt_thoiluong.setText(String.valueOf(model.getThoiLuong()));
        txt_nguoitao.setText(model.getMaNV());
        txt_ngaytao.setText(DateHelper.toString(model.getNgayTao()));
        txt_ghichu.setText(model.getGhiChu());
    }
    
    public boolean check5Ngay(JTextField txt, JTextField txt2) {
        txt.setBackground(white);
        Date date = DateHelper.toDate(txt.getText());
        Date date2 = DateHelper.toDate(txt2.getText());
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date);
        c2.setTime(date2);
        long a = (c1.getTime().getTime() - c2.getTime().getTime()) / (24 * 3600 * 1000);
        if (a >= 5) {
            return true;
        } else {
            txt.setBackground(pink);
            dialogHelper.alert(this, txt.getName() + " phải sau cách ngày tạo ít nhất 5 ngày.");
            return false;
        }
    }
    
    //lấy đt khoaHoc từ form, return khoaHoc
    KhoaHoc getModel() {
        KhoaHoc model = new KhoaHoc();
        ChuyenDe chuyenDe = (ChuyenDe) cbb_chuyende.getSelectedItem();
        model.setMaCD(chuyenDe.getMaCD());
        model.setNgayKG(DateHelper.toDate(this.txt_ngayKG.getText()));
        model.setHocPhi(Double.valueOf(txt_hocphi.getText()));
        model.setThoiLuong(Integer.valueOf(txt_thoiluong.getText()));
        model.setGhiChu(txt_ghichu.getText());
        model.setMaNV(shareHelper.USER.getMaNV());
        model.setNgayTao(DateHelper.toDate(txt_ngaytao.getText()));
        model.setMaKH(Integer.valueOf(cbb_chuyende.getToolTipText()));      
        return model;
    }

    //2 chế độ như các form trước
    //nút btnStudents chỉ hiển thị ở chế độ editable
    void setStatus(boolean insertable) {
        btn_them.setEnabled(insertable);
        btn_update.setEnabled(!insertable);
        btn_xoa.setEnabled(!insertable);
        boolean first = this.index > 0;
        boolean last = this.index < tbl_Table.getRowCount() - 1;
        btn_first.setEnabled(!insertable && first);
        btn_back.setEnabled(!insertable && first);
        btn_last.setEnabled(!insertable && last);
        btn_next.setEnabled(!insertable && last);
        btn_hocvien.setVisible(!insertable);   //chỉ nhìn thấy nút này ở chế độ Editable
    }

    //thay đổi thời lượng vào học phí trên form theo chuyên đề đc chọn ở combobox
    void selectComboBox() {
        ChuyenDe chuyenDe = (ChuyenDe) cbb_chuyende.getSelectedItem(); 
        //lấy 1 Object được chọn từ combobox
        //có thể điền và lấy 1 Object từ combobox
        txt_thoiluong.setText(String.valueOf(chuyenDe.getThoiLuong()));
        txt_hocphi.setText(String.valueOf(chuyenDe.getHocPhi()));
    }

    //mở hocVienJFrame với tham số là maKH
    void openHocVien() {
        Integer id = Integer.valueOf(cbb_chuyende.getToolTipText());
        new IF_QLHocVien().setVisible(true);
    }
    
    //
    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbb_chuyende.getModel(); //kết nối model với cbo
        model.removeAllElements();   //xóa toàn bộ item của cbo
        try {
            List<ChuyenDe> list = cddao.select();
            for (ChuyenDe cd : list) {
                model.addElement(cd);    //thêm đối tượng (Object) vào model
                //chỉ thêm đc đối tượng đối với model, cbo chỉ được cbo.addItem(String);
                //lấy đối tượng thì từ cbo cũng được: cbo.getSelectedItem();
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
//    private void getCD(){
//        this.cbb_chuyende.removeAll();
//        this.lstKH = this.KH_DAO.getAll();
//        for (KhoaHoc kh : lstKH) {
//            this.cbb_chuyende.addItem(kh.getMaCD());
//        }
//    }
//    
//    private boolean check(){
//        String passs = String.valueOf(this.txt_matkhau.getPassword());
//        String XNpasss = String.valueOf(this.txt_xnmk.getPassword());
//        if (this.txt_manv.getText().trim().equals("") || this.txt_hoten.getText().trim().equals("") ||
//            passs.trim().equals("") || XNpasss.trim().equals("")    
//                ) {
//            JOptionPane.showMessageDialog(this, "Chưa nhập đầy đủ thông tin!");
//            return false;
//        }else if(passs.trim().length() < 3 || XNpasss.trim().length() < 3){
//            JOptionPane.showMessageDialog(this, "Mật khẩu ít nhất 3 ký tự!");
//            return false;
//        }else if(!XNpasss.equals(passs)){
//            JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu không khớp với mật khẩu!");
//            return false;
//        }
//        return true;
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbb_chuyende = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_hocphi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nguoitao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ghichu = new javax.swing.JTextArea();
        btn_back = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        txt_thoiluong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_ngaytao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_ngayKG = new javax.swing.JTextField();
        btn_hocvien = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Table = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("QUẢN LÝ KHÓA HỌC");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Quản Lý Khóa Học");

        jLabel2.setText("Chuyên đề");

        cbb_chuyende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_chuyendeActionPerformed(evt);
            }
        });

        jLabel3.setText("Học phí");

        jLabel4.setText("Người tạo");

        jLabel5.setText("Ghi chú");

        txt_ghichu.setColumns(20);
        txt_ghichu.setRows(5);
        jScrollPane1.setViewportView(txt_ghichu);

        btn_back.setText("<<");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_first.setText("|<");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Add to basket.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Notes.png"))); // NOI18N
        btn_update.setText("Sửa");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_moi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Unordered list.png"))); // NOI18N
        btn_moi.setText("Mới");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        btn_last.setText(">|");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày tạo");

        jLabel7.setText("Ngày khai giảng");

        jLabel8.setText("Thời lượng (giờ)");

        btn_hocvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/User.png"))); // NOI18N
        btn_hocvien.setText("Học Viên");
        btn_hocvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hocvienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_nguoitao)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(cbb_chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(txt_hocphi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(txt_thoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_ngayKG, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_xoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_moi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hocvien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_first)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_last)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbb_chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hocphi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nguoitao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_ngayKG, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_thoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_update)
                    .addComponent(btn_xoa)
                    .addComponent(btn_moi)
                    .addComponent(btn_last)
                    .addComponent(btn_next)
                    .addComponent(btn_back)
                    .addComponent(btn_first)
                    .addComponent(btn_hocvien))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        tab.addTab("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/Image/Edit.png")), jPanel2); // NOI18N

        tbl_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Chuyên Đề", "Thơi Lượng", "Học Phí", "Khai Giảng", "Tạo bởi", "Ngày Tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        tab.addTab("Danh sách", new javax.swing.ImageIcon(getClass().getResource("/Image/List.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hocvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hocvienActionPerformed
//        this.QLHocVien();
        this.openHocVien();
    }//GEN-LAST:event_btn_hocvienActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
//        if (this.check()) {
//            try {
////                for (KhoaHoc kh : lstKH) {
////                    if (this.txt_manv.getText().equals(kh.getMaCD())) {
////                        JOptionPane.showMessageDialog(this, "Mã nhân viên này đã tồn tại!");
////                        return;
////                    }
////                }
//                String macd = this.cbb_chuyende.getSelectedItem().toString();
//                String ngtao = this.txt_nguoitao.getText();
//                String ghichu = this.txt_ghichu.getText();
//                double hocphi = Double.parseDouble(this.txt_hocphi.getText());
//                int thoiluong = Integer.parseInt(this.txt_thoiluong.getText());
//                
////                NhanVien nv = new NhanVien(manv, password, hoten, vaitro);
////                this.NVDAO.insert(nv);
////                JOptionPane.showMessageDialog(this, "Thêm thành công!");
////                this.getAll();
////                this.clear();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        
        if(utilityHelper.checkNullText(txt_ngayKG)){
            if(utilityHelper.checkDate(txt_ngayKG)){
                if(check5Ngay(txt_ngayKG,txt_ngaytao)){
                    insert();
                }
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        clear();
    }//GEN-LAST:event_btn_moiActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
//        this.getCD();
        this.fillComboBox();
        this.load();
        this.clear();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        this.index++;
        this.edit();
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        this.index = tbl_Table.getRowCount() - 1;
        this.edit(); 
    }//GEN-LAST:event_btn_lastActionPerformed

    private void tbl_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TableMouseClicked
//        if (evt.getClickCount() == 2) {
            this.index = tbl_Table.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
                tab.setSelectedIndex(0);
            }
//        }
    }//GEN-LAST:event_tbl_TableMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(utilityHelper.checkNullText(txt_ngayKG)){
            if(utilityHelper.checkDate(txt_ngayKG)){
                if(check5Ngay(txt_ngayKG,txt_ngaytao)){
                    update();
                }
            }
        }  
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        if(shareHelper.USER.getVaiTro()){
            delete();
        }else{
            dialogHelper.alert(this, "Chỉ trưởng phòng mới được phép xóa");
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        this.index = 0;
        this.edit();
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.index--;
        this.edit();
    }//GEN-LAST:event_btn_backActionPerformed

    private void cbb_chuyendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_chuyendeActionPerformed
        selectComboBox();  
    }//GEN-LAST:event_cbb_chuyendeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_hocvien;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_chuyende;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tbl_Table;
    private javax.swing.JTextArea txt_ghichu;
    private javax.swing.JTextField txt_hocphi;
    private javax.swing.JTextField txt_ngayKG;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_nguoitao;
    private javax.swing.JTextField txt_thoiluong;
    // End of variables declaration//GEN-END:variables
}
