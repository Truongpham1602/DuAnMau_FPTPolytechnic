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
    //?????c 1 nh??n vi??n t??? 1 b???n ghi (1 ResultSet)
    public NhanVien readFromResultSet(ResultSet rs) throws SQLException{
        NhanVien model=new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }
    
    //th???c hi???n truy v???n l???y v??? 1 t???p ResultSet r???i ??i???n t???p ResultSet ???? v??o 1 List
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
                rs.getStatement().getConnection().close();      //????ng k???t n???i t??? resultSet
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }
    
    /**
     * Th??m m???i th???c th??? v??o CSDL
     * @param entity l?? th???c th??? ch???a th??ng tin b???n ghi m???i
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
     * C???p nh???t th???c th??? v??o CSDL
     * @param entity l?? th???c th??? ch???a th??ng tin b???n ghi c???n c???p nh???t
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
     * X??a b???n ghi kh???i CSDL
     * @param maNV l?? m?? c???a b???n ghi c???n x??a
     */
    public void delete1(String maNV) {
        String sql="DELETE FROM NhanVien WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql, maNV);
    }

    /**
     * Truy v???n t???t c??? c??c c??c th???c th???
     * @return danh s??ch c??c th???c th???
     */
    public List<NhanVien> select() {
        String sql="SELECT * FROM NhanVien";
        return select(sql);             //trong 1 class c?? th??? c?? 2 method tr??ng t??n (nh??ng param kh??c nhau)
    }

    /**
     * Truy v???n th???c th??? theo m?? id
     * @param id l?? m?? c???a b???n ghi ???????c truy v???n
     * @return th???c th??? ch???a th??ng tin c???a b???n ghi
     */
    public NhanVien findById(String id) {
        String sql="SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, id);
        return list.size()>0?list.get(0):null;               //c?? th??? tr??? v??? l?? null
    }
}
