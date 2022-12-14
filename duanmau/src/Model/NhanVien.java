/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DELL-PC
 */
public class NhanVien {

    private String maNV;
    private String matKhau;
    private String hoTen;
    private boolean vaiTro = false;

    @Override
    public String toString() {
        return this.hoTen;
    }

    public NhanVien() {
    }

    public NhanVien(String maNV, String matKhau, String hoTen, boolean vaiTro) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.vaiTro = vaiTro;
    }
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String setVaiTro(){
        if (vaiTro == true) {
            return "Trưởng phòng";
        }else{
            return "Nhân viên";
        }
    }
    
    public int getVaitro() {
        if (vaiTro == true) {
            return 1;
        }else{
            return 0;
        }
    }
}
