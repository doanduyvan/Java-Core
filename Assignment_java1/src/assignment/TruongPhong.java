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
public class TruongPhong extends NhanVien {

    private Double tienTrachNhiem;

    public TruongPhong() {
    }

    public TruongPhong(String maNV, String hoTen, Double luong, double tienTrachNhiem) {
        super(maNV, hoTen, luong, "Truong Phong");
        this.tienTrachNhiem = tienTrachNhiem;
    }

    public Double getTienTrachNhiem() {
        return tienTrachNhiem;
    }

    public void setTienTrachNhiem(Double tienTrachNhiem) {
        this.tienTrachNhiem = tienTrachNhiem;
    }

    @Override
    public double getThuNhap() {
        return getLuong() + this.tienTrachNhiem;
    }

    @Override
    public void xuatThongTin() {
        DecimalFormat temp = new DecimalFormat("#,###.##");
          super.xuatThongTin();
//        System.out.println("Ma NV: " + super.getMaNV());
//        System.out.println("Ten NV: " + super.getHoTen());
//        System.out.println("Phong Ban: " + super.getPhongBan());
//        System.out.println("Luong co ban: " + temp.format(super.getLuong()) + " VND");

        System.out.println("Tien trach nhiem: " + temp.format(this.tienTrachNhiem) + " VND");
        System.out.println("Tong tien luong: " + temp.format(this.getThuNhap()) + " VND");
        System.out.println("Tien thue phai dong: " + temp.format(super.getThueTN()) + " VND");
        System.out.println("Luong thuc lanh: " + temp.format(this.getThuNhap() - super.getThueTN()) + " VND");
    }
}
