/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.KetNoi;
import JDBC.jdbcHelper;
import Model.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THIS PC
 */
public class NhanVien_DAO {
    public List<NhanVien> getAll (){
        List<NhanVien> lstNV = new ArrayList<>();
        try {
            String query = "SELECT * FROM NhanVien";
            
            PreparedStatement ps = KetNoi.prepare(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() == true) {                
                String manv = rs.getString("manv");
                String Matkhau = rs.getString("MatKhau");
                String hoten = rs.getString("HoTen");
                int vaitro = rs.getInt("VaiTro");
                boolean vTro;
                if (vaitro == 1) {
                    vTro = true;
                }else{
                    vTro = false;
                }
                
                NhanVien nv = new NhanVien(manv, Matkhau, hoten, vTro);
                lstNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstNV;
    }
    
    public NhanVien insert(NhanVien nv){
        try {
            String query = "INSERT INTO NhanVien values(?,?,?,?)";
            PreparedStatement ps = KetNoi.prepare(query);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getMatKhau());
            ps.setString(3, nv.getHoTen());
            ps.setInt(4, nv.getVaitro());
           
            ps.execute();
            ResultSet rs = ps.getResultSet();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }
    
    public boolean delete(String manv){
        try {
            
            String query = "DELETE FROM NhanVien WHERE manv = ?";
            
            
            PreparedStatement ps = KetNoi.prepare(query);
            ps.setString(1, manv);
            
            int kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean update(NhanVien nv){
        try {
            String query = "UPDATE NhanVien SET matkhau = ?, hoten = ?, vaitro = ? WHERE manv = ?";
            PreparedStatement ps = KetNoi.prepare(query);
            ps.setString(1, nv.getMatKhau());
            ps.setString(2, nv.getHoTen());
            ps.setInt(3, nv.getVaitro());
            ps.setString(4, nv.getMaNV());
            
            ps.execute();
            ResultSet rs = ps.getResultSet();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    ///////////////////////////
    //đọc 1 nhân viên từ 1 bản ghi (1 ResultSet)
    public NhanVien readFromResultSet(ResultSet rs) throws SQLException{
        NhanVien model=new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }
    
    //thực hiện truy vấn lấy về 1 tập ResultSet rồi điền tập ResultSet đó vào 1 List
    public List<NhanVien> select(String sql,Object...args){
        List<NhanVien> list=new ArrayList<>();
        try {
            ResultSet rs=null;
            try{
                rs=jdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    list.add(readFromResultSet(rs));
                }
            }finally{
                rs.getStatement().getConnection().close();      //đóng kết nối từ resultSet
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }
    
    /**
     * Thêm mới thực thể vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi mới
     */
    public void insert1(NhanVien entity) {
        String sql="INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaNV(),
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.getVaiTro());
    }

    /**
     * Cập nhật thực thể vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update1(NhanVien entity) {
        String sql="UPDATE NhanVien SET MatKhau=?, HoTen=?, VaiTro=? WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql,
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.getVaiTro(),
                entity.getMaNV());
    }

    /**
     * Xóa bản ghi khỏi CSDL
     * @param maNV là mã của bản ghi cần xóa
     */
    public void delete1(String maNV) {
        String sql="DELETE FROM NhanVien WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql, maNV);
    }

    /**
     * Truy vấn tất cả các các thực thể
     * @return danh sách các thực thể
     */
    public List<NhanVien> select() {
        String sql="SELECT * FROM NhanVien";
        return select(sql);             //trong 1 class có thể có 2 method trùng tên (nhưng param khác nhau)
    }

    /**
     * Truy vấn thực thể theo mã id
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public NhanVien findById(String id) {
        String sql="SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, id);
        return list.size()>0?list.get(0):null;               //có thể trả về là null
    }
}
