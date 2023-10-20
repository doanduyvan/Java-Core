/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.text.DecimalFormat;

/**
 *
 * @author DUYVAN
 */
public abstract class NhanVien {

    private String maNV;
    private String hoTen;
    private Double luong;
    private String phongBan;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, Double luong, String phongBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
        this.phongBan = phongBan;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    abstract double getThuNhap();

    public double getThueTN() {
        if (this.getThuNhap() < 9000000) {
            return 0.0;
        } else if (this.getThuNhap() >= 9000000 && this.getThuNhap() <= 15000000) {
            return this.getThuNhap() * 0.1;
        } else {
            return this.getThuNhap() * 0.12;
        }
    }

    public void xuatThongTin() {
        DecimalFormat temp = new DecimalFormat("#,###.##");
        System.out.println("Ma NV: " + this.maNV);
        System.out.println("Ten NV: " + this.hoTen);
        System.out.println("Phong Ban: " + this.phongBan);
        System.out.println("Luong co ban: " + temp.format(this.luong) + " VND");

    }
}
