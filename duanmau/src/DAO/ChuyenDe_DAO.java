/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.KetNoi;
import JDBC.jdbcHelper;
import Model.ChuyenDe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THIS PC
 */
public class ChuyenDe_DAO {

    public List<ChuyenDe> getAll() {
        List<ChuyenDe> lstCD = new ArrayList<>();
        try {
            String query = "SELECT * FROM ChuyenDe";

            PreparedStatement ps = KetNoi.prepare(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next() == true) {
                String macd = rs.getString("macd");
                String TenCD = rs.getString("TenCD");
                String Hinh = rs.getString("Hinh");
                String MoTa = rs.getString("MoTa");
                int ThoiLuong = rs.getInt("ThoiLuong");
                double HocPhi = rs.getDouble("HocPhi");

                ChuyenDe cd = new ChuyenDe(macd, TenCD, HocPhi, ThoiLuong, Hinh, MoTa);
                lstCD.add(cd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstCD;
    }

    public ChuyenDe insert(ChuyenDe cd) {
        try {
            String query = "INSERT INTO ChuyenDe values(?,?,?,?,?,?)";
            PreparedStatement ps = KetNoi.prepare(query);

            ps.setString(1, cd.getMaCD());
            ps.setString(2, cd.getTenCD());
            ps.setString(5, cd.getHinh());
            ps.setString(6, cd.getMoTa());
            ps.setInt(4, cd.getThoiLuong());
            ps.setDouble(3, cd.getHocPhi());

            ps.execute();
            ResultSet rs = ps.getResultSet();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cd;
    }

    public boolean delete(String macd) {
        try {

            String query = "DELETE FROM ChuyenDe WHERE maCD = ?";

            PreparedStatement ps = KetNoi.prepare(query);
            ps.setString(1, macd);

            int kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(ChuyenDe cd) {
        try {
            String query = "UPDATE ChuyenDe SET tenCD = ?, hinh = ?, moTa = ?, thoiLuong = ?, hocphi = ? WHERE maCD = ?";
            PreparedStatement ps = KetNoi.prepare(query);
            ps.setString(6, cd.getMaCD());
            ps.setString(1, cd.getTenCD());
            ps.setString(2, cd.getHinh());
            ps.setString(3, cd.getMoTa());
            ps.setInt(4, cd.getThoiLuong());
            ps.setDouble(5, cd.getHocPhi());

            ps.execute();
            ResultSet rs = ps.getResultSet();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    ///////////////////////////////////
    
    private ChuyenDe readFromResultSet(ResultSet rs) throws SQLException{
	ChuyenDe model=new ChuyenDe();
        model.setMaCD(rs.getString("MaCD"));
        model.setHinh(rs.getString("Hinh"));
        model.setHocPhi(rs.getDouble("HocPhi"));
        model.setMoTa(rs.getString("MoTa"));
        model.setTenCD(rs.getString("TenCD"));
        model.setThoiLuong(rs.getInt("ThoiLuong"));
        return model;
    }

    private List<ChuyenDe> select(String sql, Object...args){
        List<ChuyenDe> list=new ArrayList<>();
        try {
            ResultSet rs=null;
            try{
                rs=jdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    list.add(readFromResultSet(rs));
                }
            }finally{
                rs.getStatement().getConnection().close();
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
    public void insert1(ChuyenDe entity) {
        String sql="INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaCD(),
                entity.getTenCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getHinh(),
                entity.getMoTa());
    }

    /**
     * C???p nh???t th???c th??? v??o CSDL
     * @param entity l?? th???c th??? ch???a th??ng tin b???n ghi c???n c???p nh???t
     */
    public void update1(ChuyenDe entity) {
        String sql="UPDATE ChuyenDe SET TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?, MoTa=? WHERE MaCD=?";
        jdbcHelper.executeUpdate(sql,
                entity.getTenCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getHinh(),
                entity.getMoTa(),
                entity.getMaCD());
    }

    /**
     * X??a b???n ghi kh???i CSDL
     * @param id l?? m?? c???a b???n ghi c???n x??a
     */
    public void delete1(String id) {
        String sql="DELETE FROM ChuyenDe WHERE MaCD=?";
        jdbcHelper.executeUpdate(sql, id);
    }

    /**
     * Truy v???n t???t c??? c??c c??c th???c th???
     * @return list danh s??ch c??c th???c th???
     */
    public List<ChuyenDe> select() {
        String sql="SELECT * FROM ChuyenDe";
        return select(sql);
    }

    /**
     * Truy v???n th???c th??? theo m?? id
     * @param id l?? m?? c???a b???n ghi ???????c truy v???n
     * @return th???c th??? ch???a th??ng tin c???a b???n ghi
     */
    public ChuyenDe findById(String id) {
        String sql="SELECT * FROM ChuyenDe WHERE MaCD=?";
        List<ChuyenDe> list=select(sql,id);
        return list.size()>0?list.get(0):null;
    }
}
