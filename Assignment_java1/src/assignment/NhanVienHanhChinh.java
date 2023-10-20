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
public class NhanVienHanhChinh extends NhanVien {

    private int ngayCong;

    public NhanVienHanhChinh() {
    }

    public NhanVienHanhChinh(String maNV, String hoTen, double luong, int ngayCong) {
        super(maNV, hoTen, luong, "Hanh Chinh");
        this.ngayCong = ngayCong;
    }

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }

    @Override
    public double getThuNhap() {
        return (getLuong() / 26) * this.ngayCong;
    }

    @Override
    public void xuatThongTin() {
        DecimalFormat temp = new DecimalFormat("#,###.##");
           super.xuatThongTin();
//        System.out.println("Ma NV: " + super.getMaNV());
//        System.out.println("Ten NV: " + super.getHoTen());
//        System.out.println("Phong Ban: " + super.getPhongBan());
//        System.out.println("Luong co ban: "+temp.format(super.getLuong()));
        //

        System.out.println("So ngay cong: " + this.ngayCong);
        System.out.println("Tong tien luong: " + temp.format(this.getThuNhap())+" VND");
        System.out.println("Tien thue phai dong: " + temp.format(super.getThueTN())+" VND");
        System.out.println("Luong thuc lanh: " + temp.format(this.getThuNhap() - super.getThueTN())+" VND");

    }
}
