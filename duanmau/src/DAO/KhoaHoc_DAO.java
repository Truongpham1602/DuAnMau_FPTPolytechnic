/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.KetNoi;
import JDBC.jdbcHelper;
import Model.KhoaHoc;
import Model.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author THIS PC
 */
public class KhoaHoc_DAO {
//    public List<KhoaHoc> getAll (){
//        List<KhoaHoc> lstKH = new ArrayList<>();
//        try {
//            String query = "SELECT * FROM KhoaHoc";
//            
//            PreparedStatement ps = KetNoi.prepare(query);
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next() == true) {                
//                int makh = rs.getInt("makh");
//                String macd = rs.getString("macd");
//                String manv = rs.getString("MaNV");
//                float Hocphi = rs.getFloat("HocPhi");
//                int thoiluong = rs.getInt("ThoiLuong");
//                String ghichu = rs.getString("ghichu");
//                Date NgayKG = rs.getDate("NgayKG");
//                Date ngayTao = rs.getDate("NgayTao");
//                
//                KhoaHoc kh = new KhoaHoc(macd, manv, ghichu, makh, thoiluong, Hocphi, NgayKG, ngayTao);
//                lstKH.add(kh);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lstKH;
//    }
//    
//    public NhanVien insert(NhanVien nv){
//        try {
//            String query = "INSERT INTO NhanVien values(?,?,?,?)";
//            PreparedStatement ps = KetNoi.prepare(query);
//            ps.setString(1, nv.getMaNV());
//            ps.setString(2, nv.getMatKhau());
//            ps.setString(3, nv.getHoTen());
//            ps.setInt(4, nv.getVaiTro());
//           
//            ps.execute();
//            ResultSet rs = ps.getResultSet();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return nv;
//    }
//    
//    public boolean delete(String manv){
//        try {
//            
//            String query = "DELETE FROM NhanVien WHERE manv = ?";
//            
//            
//            PreparedStatement ps = KetNoi.prepare(query);
//            ps.setString(1, manv);
//            
//            int kq = ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//    
//    public boolean update(NhanVien nv){
//        try {
//            String query = "UPDATE NhanVien SET matkhau = ?, hoten = ?, vaitro = ? WHERE manv = ?";
//            PreparedStatement ps = KetNoi.prepare(query);
//            ps.setString(1, nv.getMatKhau());
//            ps.setString(2, nv.getHoTen());
//            ps.setInt(3, nv.getVaiTro());
//            ps.setString(4, nv.getMaNV());
//            
//            ps.execute();
//            ResultSet rs = ps.getResultSet();
//            
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
    
    //?????c 1 nh??n vi??n t??? 1 b???n ghi (1 ResultSet)
    public KhoaHoc readFromResultSet(ResultSet rs) throws SQLException{
        KhoaHoc model = new KhoaHoc();
         model.setMaKH(rs.getInt("MaKH"));
         model.setHocPhi(rs.getDouble("HocPhi"));
         model.setThoiLuong(rs.getInt("ThoiLuong"));
         model.setNgayKG(rs.getDate("NgayKG"));
         model.setGhiChu(rs.getString("GhiChu"));
         model.setMaNV(rs.getString("MaNV"));
         model.setNgayTao(rs.getDate("NgayTao"));
         model.setMaCD(rs.getString("MaCD"));
         return model;
    }
    
    //th???c hi???n truy v???n l???y v??? 1 t???p ResultSet r???i ??i???n t???p ResultSet ???? v??o 1 List
    public List<KhoaHoc> select(String sql,Object...args){
        List<KhoaHoc> list=new ArrayList<>();
        try {
            ResultSet rs=null;
            try{
                rs = jdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    list.add(readFromResultSet(rs));
                }
            }finally{
                rs.getStatement().getConnection().close();      //????ng k???t n???i t??? resultSet
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }
    
    /**
     * Th??m m???i th???c th??? v??o CSDL
     * @param model
     */
    public void insert(KhoaHoc model) {
        String sql="INSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                model.getMaCD(),
                 model.getHocPhi(),
                 model.getThoiLuong(),
                 model.getNgayKG(),
                 model.getGhiChu(),
                 model.getMaNV());
    }

    /**
     * C???p nh???t th???c th??? v??o CSDL
     * @param model
     */
    public void update(KhoaHoc model) {
        String sql="UPDATE KhoaHoc SET MaCD=?, HocPhi=?, ThoiLuong=?, NgayKG=?, GhiChu=?, MaNV=? WHERE MaKH=?";
        jdbcHelper.executeUpdate(sql,
                model.getMaCD(),
                 model.getHocPhi(),
                 model.getThoiLuong(),
                 model.getNgayKG(),
                 model.getGhiChu(),
                 model.getMaNV(),
                 model.getMaKH());
    }

    /**
     * X??a b???n ghi kh???i CSDL
     * @param MaKH
     */
     public void delete(Integer MaKH){
     String sql="DELETE FROM KhoaHoc WHERE MaKH=?";
     jdbcHelper.executeUpdate(sql, MaKH);
     }

    /**
     * Truy v???n t???t c??? c??c c??c th???c th???
     * @return danh s??ch c??c th???c th???
     */
    public List<KhoaHoc> select() {
        String sql="SELECT * FROM KhoaHoc";
        return select(sql);             //trong 1 class c?? th??? c?? 2 method tr??ng t??n (nh??ng param kh??c nhau)
    }

     public KhoaHoc findById(Integer makh){
     String sql="SELECT * FROM KhoaHoc WHERE MaKH=?";
     List<KhoaHoc> list = select(sql, makh);
     return list.size() > 0 ? list.get(0) : null;
     }    
}
