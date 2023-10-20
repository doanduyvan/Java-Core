/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author DUYVAN
 */
import java.util.Scanner;
import kiemtra.kiemtra;

public class assignment_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DanhSachNhanVien ds1 = new DanhSachNhanVien();
        int chon = 0;
        System.out.print((char) 27 + "[32m" + "\t\t\tName: DOAN DUY VAN\n");
        System.out.print((char) 27 + "[32m" + "\t\t\t  Class: WD18401\n");
        System.out.print((char) 27 + "[32m" + "\t\t\t ASSIGNMENT JAVA 1\n");
        System.out.println("");
        do {
            System.out.println("************************MENU**********************************");
            System.out.println("* 1. Nhap danh sach nhan vien tu ban phim.                   *");
            System.out.println("* 2. Xuat danh dach nhan vien ra man hinh.                   *");
            System.out.println("* 3. Tim va hien thi nhan vien theo ma nhap tu ban phim.     *");
            System.out.println("* 4. Xoa nhan vien theo ma nhap tu ban phim.                 *");
            System.out.println("* 5. Cap nhat thong tin nhan vien theo ma nhap tu ban phim.  *");
            System.out.println("* 6. Tim cac nhan vien theo khoang luong nhap tu ban phim.   *");
            System.out.println("* 7. Sap xep nhan vien theo ho va ten.                       *");
            System.out.println("* 8. Sap xep nhan vien theo thu nhap.                        *");
            System.out.println("* 9. Xuat 5 nhan vien có thu nhap cao nhat.                  *");
            System.out.println("* 10. Thoat.                                                 *");
            System.out.println("**************************************************************");
            // su li chon chuc nang
            System.out.printf("Vui long chon chuc nang: ");
            chon = kiemtra.kiemtraInt("Vui long chon chuc nang: ", 1, 10);
            switch (chon) {
                case 1:
                    System.out.println("\n\tNhap danh sach nhan vien tu ban phim.\n");
                    ds1.nhapNV();
                    continue;

                case 2:
                    System.out.println("2. Xuat danh dach nhan vien ra man hinh.");
                    ds1.xuatNV();
                    break;
                case 3:
                    System.out.println("3. Tim va hien thi nhan vien theo ma nhap tu ban phim\n");
                    ds1.timNV();
                    break;
                case 4:
                    System.out.println("4. Xoa nhan vien theo ma nhap tu ban phim.\n");
                    ds1.xoaNV();
                    break;
                case 5:
                    System.out.println("5. Cap nhat thong tin nhan vien theo ma nhap tu ban phim.");
                    ds1.suaThongTinNV();
                    break;
                case 6:
                    System.out.println("6. Tim cac nhan vien theo khoang luong nhap tu ban phim.");
                    ds1.timKhoangLuong();
                    break;
                case 7:
                    System.out.println("7. Sap xep nhan vien theo ho va ten.");
                    ds1.sapXepHoTen();
                    break;
                case 8:
                    System.out.println("8. Sap xep nhan vien theo thu nhap.");
                    ds1.sapXepThuNhap();
                    break;
                case 9:
                    System.out.println("9. Xuat 5 nhan vien có thu nhap cao nhat.\n");
                    ds1.nhanVienThuNhapCao();
                    break;
            }

            if (chon != 10) {
                System.out.printf("\nBam Enter de tiep tuc, Bam bat N de thoat: ");
                if (kiemtra.enterTiepTuc("Bam Enter de tiep tuc, Bam bat N de thoat: ")) {
                    continue;
                } else {
                    chon = 10;
                }
            }
        } while (chon != 10);
        System.out.println("\n\tCAM ON QUY KHACH DA SU DUNG DICH VU.\n");
    }
}
