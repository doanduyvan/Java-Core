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
public class NhanVienTiepThi extends NhanVien {

    private Double doanhSo;
    private Double hueHong;
    private Double tiLeHueHong;

    public NhanVienTiepThi() {
    }

    public NhanVienTiepThi(String maNV, String hoTen, Double luong, Double doanhSo, Double tiLeHueHong) {
        super(maNV, hoTen, luong, "Tiep Thi");
        this.doanhSo = doanhSo;
        this.tiLeHueHong = tiLeHueHong;
    }

//    public NhanVienTiepThi(String maVN,String hoTen,double luong,String phongBan,double doanhSo,double tile) {
//        super(maNV,hoTen,luong,phongBan);
//        this.doanhSo = doanhSo;
//        this.tiLeHueHong = tile;
//    }
    public double getTiLeHueHong() {
        return tiLeHueHong;
    }

    public void setTiLeHueHong(double tiLeHueHong) {
        this.tiLeHueHong = tiLeHueHong;
    }

    public Double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(Double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHueHong() {
        return this.doanhSo * (this.tiLeHueHong / 100);
    }

    @Override
    public double getThuNhap() {
        return super.getLuong() + this.getHueHong();

    }

    @Override
    public void xuatThongTin() {
        DecimalFormat temp = new DecimalFormat("#,###.##");
            super.xuatThongTin();
//        System.out.println("Ma NV: " + super.getMaNV());
//        System.out.println("Ten NV: " + super.getHoTen());
//        System.out.println("Phong Ban: " + super.getPhongBan());
//        System.out.println("Luong co ban: " + temp.format(super.getLuong()) + " VND");

        System.out.println("Doanh so: " + temp.format(this.doanhSo) + " VND");
        System.out.println("Hue Hong: " + temp.format(this.getHueHong()) + " VND");
        System.out.println("Tong thu nhap: " + temp.format(this.getThuNhap()) + " VND");
        System.out.println("Tien thue phai dong: " + temp.format(super.getThueTN()) + " VND");
        System.out.println("Tien thuc lanh: " + temp.format(this.getThuNhap() - super.getThueTN()) + " VND");

    }

}
