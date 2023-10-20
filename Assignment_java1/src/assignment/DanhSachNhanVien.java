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
import java.util.ArrayList;
import java.text.DecimalFormat;
import kiemtra.kiemtra;
import java.util.Comparator;
import java.util.Collections;
import javafx.print.Collation;

public class DanhSachNhanVien {

    ArrayList<NhanVien> dsnv = new ArrayList<>();
    public void nhapNV() {
        Scanner scan = new Scanner(System.in);

        // nhap
        do{
        //
        System.out.println("1. Hanh Chinh | 2. Tiep Thi | 3.Truong Phong | 4. Huy thao tac!");
        System.out.printf("Bạn muon them nhan vien o phong ban nao(1,2,3,4): ");
        int phongban = kiemtra.kiemtraInt("Bạn muon them nhan vien o phong ban nao(1,2,3,4): ", 1, 4);
        if (phongban == 4) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!");
            System.out.println("");
            return;
        }
        String maNV = "";

        boolean nhaplai = false;
        // tao ma nhan vien tu dong
        do {
            nhaplai = false;
            String so4 = "";
            if (phongban == 1) {
                so4 = kiemtra.RanDomMaNV();
                maNV = "HC" + so4;
            } else if (phongban == 2) {
                so4 = kiemtra.RanDomMaNV();
                maNV = "TT" + so4;
            } else if (phongban == 3) {
                so4 = kiemtra.RanDomMaNV();
                maNV = "TP" + so4;
            }
            for (int i = 0; i < dsnv.size(); i++) {
                NhanVien temp = dsnv.get(i);
                if (so4.equals(temp.getMaNV().substring(2, 6))) {
                    nhaplai = true;
                    break;
                }
            }
        } while (nhaplai);

        System.out.printf("\nMa NV: " + maNV);

        System.out.printf("\nNhap Ten NV: ");
        String tenNV = kiemtra.nhapHoTen("Nhap Ten NV: ");
        if (tenNV.equals("")) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
            System.out.println("");
            return;
        }

        System.out.printf("Nhap luong NV: ");
        String SluongNV = kiemtra.nhapSoStringDouble("Nhap luong NV: ");
        if (SluongNV.equals("")) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
            System.out.println("");
            return;
        }
        double luongNV = Double.parseDouble(SluongNV);

        if (phongban == 1) {
            System.out.printf("Nhap so ngay cong: ");
            String Sngaycong = kiemtra.nhapSoStringInt("Nhap so ngay cong: ", 0, 31);
            if (Sngaycong.equals("")) {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                System.out.println("");
                return;
            }
            int ngaycong = Integer.parseInt(Sngaycong);

            NhanVien newNV = new NhanVienHanhChinh(maNV, tenNV, luongNV, ngaycong);
            dsnv.add(newNV);

        } else if (phongban == 2) {
            System.out.printf("Danh so ban hang: ");
            String Sdoanhso = kiemtra.nhapSoStringDouble("Danh so ban hang: ");
            if (Sdoanhso.equals("")) {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                System.out.println("");
                return;
            }
            double doanhso = Integer.parseInt(Sdoanhso);
            System.out.print("Ti le hoa hong (0% -> 100%): ");
            String Stile = kiemtra.nhapSoStringDouble("Ti le hoa hong (0% -> 100%): ",0,100);
            if (Stile.equals("")) {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                System.out.println("");
                return;
            }
            double tile = Integer.parseInt(Stile);
            NhanVien newNV = new NhanVienTiepThi(maNV, tenNV, luongNV, doanhso, tile);
            dsnv.add(newNV);

        } else if (phongban == 3) {
            System.out.printf("Nhap tien trach nhiem: ");
            String StienTN = kiemtra.nhapSoStringDouble("Nhap tien trach nhiem: ");
            if (StienTN.equals("")) {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                System.out.println("");
                return;
            }
            double tienTN = Integer.parseInt(StienTN);
            NhanVien newNV = new TruongPhong(maNV, tenNV, luongNV, tienTN);
            dsnv.add(newNV);
        }
        System.out.println("\nBan da them nhan vien thanh cong.\n");
        //
        System.out.printf("Bam Enter de tiep tuc them nhan vien, Bam N de thoat: ");
        if(!kiemtra.enterTiepTuc("Bam Enter de tiep tuc them nhan vien, Bam N de thoat: ")){
            break;
        }
            System.out.println("");
        }while(true);
        //
    }

    // xuat
    public void xuatNV() {
        if (dsnv.isEmpty()) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tKhong co nhan vien nao trong danh sach!");
            System.out.println("");
            return;
        }
        for (NhanVien temp : dsnv) {
            System.out.println("");
            temp.xuatThongTin();
            System.out.println("");
        }
        System.out.println("\tCo " + dsnv.size() + " nhan vien trong danh sach.");
    }

    // tim ma nhan vien va hien thi
    public void timNV() {
        if (dsnv.isEmpty()) {
            System.out.print((char) 27 + "[31m" + "\tKhong co nhan vien nao trong danh sach!");
            System.out.println("");
            return;
        }
        boolean ok = true;
        System.out.printf("Nhap ma nhan vien ban muon tim: ");
        String tim = new Scanner(System.in).nextLine();
        for (int i = 0; i < dsnv.size(); i++) {
            NhanVien temp = dsnv.get(i);
            if (tim.equalsIgnoreCase(temp.getMaNV())) {
                System.out.println("");
                temp.xuatThongTin();
                ok = false;
                break;
            }
        }
        if (ok) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tKhong tim thay nhan vien nao co ma la " + tim);
            System.out.println("");
        }
    }

    // xoa nhan vien
    public void xoaNV() {
        if (dsnv.isEmpty()) {
        
            System.out.print((char) 27 + "[31m" + "\tKhong co nhan vien nao trong danh sach!");
            System.out.println("");
            return;
        }
        boolean ok = true;
        System.out.printf("Nhap ma nhan vien ban muon xoa: ");
        String tim = new Scanner(System.in).nextLine();
        for (int i = 0; i < dsnv.size(); i++) {
            NhanVien temp = dsnv.get(i);
            if (tim.equalsIgnoreCase(temp.getMaNV())) {
                System.out.println("");
                temp.xuatThongTin();
                System.out.println("");
                System.out.printf("Ban co muon xoa nhan vien nay khong (Y/N): ");
                String kt = kiemtra.yesno("Ban co muon xoa nhan vien nay khong (Y/N): ");
                if (kt.equalsIgnoreCase("y")) {
                    dsnv.remove(i);
                    System.out.println("\nBan da xoa thanh cong nhan vien nay!");
                } else {
                    System.out.println("\nBan da huy xoa!");
                }
                ok = false;
                break;
            }
        }
        if (ok) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tKhong tim thay nhan vien nao co ma la " + tim);
            System.out.println("\n");
        }
    }

    // sua thong tin nhan vien
    public void suaThongTinNV() {
        if (dsnv.isEmpty()) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tKhong co nhan vien nao trong danh sach!");
            System.out.println("");
            return;
        }
        System.out.printf("Nhap ma nhan vien muon sua: ");
        String edit = new Scanner(System.in).nextLine();
        if (edit.equals("")) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
            System.out.println("");
            return;
        }
        boolean ok = true;
        for (int i = 0; i < dsnv.size(); i++) {
            NhanVien temp = dsnv.get(i);
            if (edit.equalsIgnoreCase(temp.getMaNV())) {
                ok = false;

                do {
                    temp = dsnv.get(i);
                    System.out.println("");
                    temp.xuatThongTin();
                    System.out.println("");
                    boolean conti = false;
                    
                    if (temp.getPhongBan().equalsIgnoreCase("hanh chinh")) {
                        System.out.println("1. Ten NV | 2. Phong Ban | 3. Tien luong | 4. Ngay cong | 5. EXIT");
                        System.out.printf("Chon thong tin ban muon sua: ");
                        int editThongTin = kiemtra.kiemtraInt("Chon thong tin ban muon sua: ", 1, 5);
                        if (editThongTin == 5) {
                            System.out.println("");
                            System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                            System.out.println("");
                            return;
                        }
                        System.out.println("");
                        switch (editThongTin) {
                            case 1:
                                System.out.printf("Nhap ten nhan vien: ");
                                String tenNV = kiemtra.nhapHoTen("Nhap ten nhan vien: ");
                                if (tenNV.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                temp.setHoTen(tenNV);

                                break;
                            case 2:
                                System.out.println("Ban dang la nhan vien hanh chinh!\n");
                                System.out.println("1. Tiep thi | 2. Truong phong | 3. Huy chuyen phong ban.");
                                System.out.printf("Chon phong ban muon chuyen den: ");
                                int chon12 = kiemtra.kiemtraInt("Chon phong ban muon chuyen den: ", 1, 3);
                                if (chon12 == 1) {
                                    String newMaNV = "TT" + temp.getMaNV().substring(2, 6);
                                    System.out.println("\nBan da chuyen tu phong hanh chinh sang phong tiep thi thanh cong");
                                    System.out.println("Vui long cap nhat them doanh so va ti le hoa hong.\n");
                                    NhanVien newNV = new NhanVienTiepThi(newMaNV, temp.getHoTen(), temp.getLuong(), 0.0, 0.0);
                                    dsnv.set(i, newNV);
                                    conti = true;
                                } else if (chon12 == 2) {
                                    String newMaNV = "TP" + temp.getMaNV().substring(2, 6);
                                    System.out.println("\nBan da chuyen tu phong hanh chinh sang truong phong thanh cong");
                                    System.out.println("Vui long cap nhat them luong trach nhiem nhe.\n");
                                    NhanVien newNV = new TruongPhong(newMaNV, temp.getHoTen(), temp.getLuong(), 0.0);
                                    dsnv.set(i, newNV);
                                    conti = true;
                                } else {
                                    System.out.println("\nBan da huy thay doi thong tin!\n");
                                }
                                break;
                            case 3:
                                System.out.printf("Nhap tien luong: ");
                                String Stienluong = kiemtra.nhapSoStringDouble("Nhap tien luong: ");
                                if (Stienluong.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                double tienLuong = Double.parseDouble(Stienluong);
                                temp.setLuong(tienLuong);
                                break;
                            case 4:
                                System.out.printf("Nhap ngay cong: ");
                                String Sngaycong = kiemtra.nhapSoStringInt("Nhap ngay cong: ", 0, 31);
                                if (Sngaycong.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                int ngayCong = Integer.parseInt(Sngaycong);
                                ((NhanVienHanhChinh) temp).setNgayCong(ngayCong);
                                break;
                        }
                    } else if (temp.getPhongBan().equalsIgnoreCase("tiep thi")) {
                        System.out.println("1. Ten NV | 2. Phong Ban | 3. Tien luong | 4. Doanh so | 5. Ti le hue hong | 6. EXIT");
                        System.out.printf("Chon thong tin ban muon sua: ");
                        int editThongTin = kiemtra.kiemtraInt("Chon thong tin ban muon sua: ", 1, 6);
                        if (editThongTin == 6) {
                            System.out.println("");
                            System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                            System.out.println("");
                            return;
                        }
                        switch (editThongTin) {
                            case 1:
                                System.out.printf("Nhap ten nhan vien: ");
                                String tenNV = kiemtra.nhapHoTen("Nhap ten nhan vien: ");
                                if (tenNV.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                temp.setHoTen(tenNV);

                                break;
                            case 2:

                                System.out.println("Ban dang la Tiep Thi!\n");
                                System.out.println("1. Hanh Chinh | 2. Truong Phong | 3. Huy chuyen phong ban.");
                                System.out.printf("Chon phong ban muon chuyen den: ");
                                int chon12 = kiemtra.kiemtraInt("Chon phong ban muon chuyen den: ", 1, 3);
                                if (chon12 == 1) {
                                    String newMaNV = "HC" + temp.getMaNV().substring(2, 6);
                                    System.out.println("\nBan da chuyen tu phong tiep thi sang phong hanh chinh thanh cong");
                                    System.out.println("Vui long cap nhat them ngay cong ban nhe!\n");
                                    NhanVien newNV = new NhanVienHanhChinh(newMaNV, temp.getHoTen(), temp.getLuong(), 0);
                                    dsnv.set(i, newNV);
                                    conti = true;
                                } else if (chon12 == 2) {
                                    String newMaNV = "TP" + temp.getMaNV().substring(2, 6);
                                    System.out.println("Ban da chuyen tu phong tiep thi sang truong phong thanh cong");
                                    System.out.println("Vui long cap nhat them luong trach nhiem nhe!.");
                                    NhanVien newNV = new TruongPhong(newMaNV, temp.getHoTen(), temp.getLuong(), 0.0);
                                    dsnv.set(i, newNV);
                                    conti = true;
                                } else {
                                    System.out.println("\nBan da huy thay doi thong tin!\n");
                                }
                                break;

                            case 3:
                                System.out.printf("Nhap tien luong: ");
                                String Stienluong = kiemtra.nhapSoStringDouble("Nhap tien luong: ");
                                if (Stienluong.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                double tienLuong = Double.parseDouble(Stienluong);
                                temp.setLuong(tienLuong);

                                break;
                            case 4:
                                System.out.printf("Nhap doanh so: ");
                                String Sdoanhso = kiemtra.nhapSoStringDouble("Nhap doanh so: ");
                                if (Sdoanhso.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                double doanhSo = Double.parseDouble(Sdoanhso);
                                ((NhanVienTiepThi) temp).setDoanhSo(doanhSo);

                                break;
                            case 5:
                                System.out.print("Nhap ti le hue hong(0% -> 100%): ");
                                String Stile = kiemtra.nhapSoStringDouble("Nhap ti le hue hong(0% -> 100%): ", 0, 100);
                                if (Stile.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                double tile = Double.parseDouble(Stile);
                                ((NhanVienTiepThi) temp).setTiLeHueHong(tile);
                                break;
                        }
                    } else if (temp.getPhongBan().equalsIgnoreCase("truong phong")) {
                        System.out.println("1. Ten NV | 2. Phong Ban | 3. Tien luong | 4. Tien trach nhiem | 5. EXIT");
                        System.out.printf("Chon thong tin ban muon sua: ");
                        int editThongTin = kiemtra.kiemtraInt("Chon thong tin ban muon sua: ", 1, 5);
                        if (editThongTin == 5) {
                            System.out.println("");
                            System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                            System.out.println("");
                            return;
                        }
                        switch (editThongTin) {
                            case 1:
                                System.out.printf("Nhap ten nhan vien: ");
                                String tenNV = kiemtra.nhapHoTen("Nhap ten nhan vien: ");
                                if (tenNV.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                temp.setHoTen(tenNV);

                                break;
                            case 2:
                                System.out.println("Ban dang la Truong Phong!\n");
                                System.out.println("1. Hanh Chinh | 2. Tiep Thi | 3. Huy chuyen phong ban.");
                                System.out.printf("Chon phong ban muon chuyen den: ");
                                int chon12 = kiemtra.kiemtraInt("Chon phong ban muon chuyen den: ", 1, 3);
                                if (chon12 == 1) {
                                    String newMaNV = "HC" + temp.getMaNV().substring(2, 6);
                                    System.out.println("\nBan da chuyen tu truong phong sang phong hanh chinh thanh cong");
                                    System.out.println("Vui long cap nhat them ngay cong ban nhe!\n");
                                    NhanVien newNV = new NhanVienHanhChinh(newMaNV, temp.getHoTen(), temp.getLuong(), 0);
                                    dsnv.set(i, newNV);
                                    conti = true;
                                } else if (chon12 == 2) {
                                    String newMaNV = "TT" + temp.getMaNV().substring(2, 6);
                                    System.out.println("\nBan da chuyen tu truong phong sang phong tiep thi thanh cong");
                                    System.out.println("Vui long cap nhat them doanh so va ti le hue hong ban nhe!.\n");
                                    NhanVien newNV = new NhanVienTiepThi(newMaNV, temp.getHoTen(), temp.getLuong(), 0.0, 0.0);
                                    dsnv.set(i, newNV);
                                    conti = true;
                                } else {
                                    System.out.println("\nBan da huy thay doi thong tin!\n");
                                }
                                break;
                            case 3:
                                System.out.printf("Nhap tien luong: ");
                                String Stienluong = kiemtra.nhapSoStringDouble("Nhap tien luong: ");
                                if (Stienluong.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                double tienLuong = Double.parseDouble(Stienluong);
                                temp.setLuong(tienLuong);

                                break;
                            case 4:
                                System.out.printf("Nhap tien trach nhiem: ");
                                String StienTrachNhiem = kiemtra.nhapSoStringDouble("Nhap tien trach nhiem: ");
                                if (StienTrachNhiem.equals("")) {
                                    System.out.println("");
                                    System.out.print((char) 27 + "[31m" + "\tBan da huy thao tac nay!\n");
                                    System.out.println("");
                                    return;
                                }
                                double tienTrachNhiem = Double.parseDouble(StienTrachNhiem);
                                ((TruongPhong) temp).setTienTrachNhiem(tienTrachNhiem);

                                break;
                        }
                    }
                    // sau khi sua 
                    if (conti) {
                        continue;
                    }
                    dsnv.set(i, temp);

                    System.out.printf("\nBan co muon tiep tuc sua hay khong (Y/N): ");
                    String yn = kiemtra.yesno("Ban co muon tiep tuc sua hay khong (Y/N): ");
                    if (yn.equalsIgnoreCase("n")) {
                        System.out.println("\nHoan tat thay doi thong tin\n");
                        return;
                    }
                } while (true);
            }
        }
        if (ok) {
            System.out.println("\nMa nhan vien khong ton tai!");
        }
    }

    // sap xep nhan vien theo ho va ten
    public void sapXepHoTen() {

        if (dsnv.isEmpty()) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tKhong co nhan vien nao trong danh sach!");
            System.out.println("");
        } else if (dsnv.size() == 1) {
            System.out.println("\nChi có 1 nhan vien, nen khong can sap xep!\n");
        } else {
            System.out.println("");
            System.out.println("1. Sap xep theo ho nhan vien | 2. Sap xep theo ten nhan vien. | 3. Huy sap xep.");
            System.out.printf("Chon chuc nang: ");
            int chon = kiemtra.kiemtraInt("Chon chuc nang: ", 1, 3);
            if (chon == 1) {
                Comparator<NhanVien> sortHo = new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        String kt1 = o1.getHoTen().trim();
                        String kt2 = o2.getHoTen().trim();
                        String n1 = kt1.split(" ")[0];
                        String n2 = kt2.split(" ")[0];
                        return n1.compareToIgnoreCase(n2);
                    }
                };
                Collections.sort(dsnv, sortHo);
                System.out.println("\nBan da sap xep ho nhan vien tu A-Z thanh cong.\n");
            } else if (chon == 2) {
                Comparator<NhanVien> sortTen = new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        String[] n1 = o1.getHoTen().split(" ");
                        String[] m1 = o2.getHoTen().split(" ");
                        String n2 = n1[n1.length - 1];
                        String m2 = m1[m1.length - 1];
                        return n2.compareToIgnoreCase(m2);
                    }

                };
                Collections.sort(dsnv, sortTen);
                System.out.println("\nBan da sap xep ten nhan vien tu A-Z thanh cong.\n");
            } else {
                System.out.println("\nBan da huy thao tac nay!");
            }
        }
    }

    // tim nhan vien theo khoang luong
    public void timKhoangLuong() {
        DecimalFormat fm = new DecimalFormat("#,###.##");
        if (dsnv.isEmpty()) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tKhong co nhan vien nao trong danh sach!");
            System.out.println("");
            return;
        } else {
            boolean tim = true;
            int dem = 0;
            System.out.println("Nhap khoang luong ban muon tim.");
            System.out.printf("Luong Min: ");
            double luongMin = kiemtra.kiemtraDouble("Luong Min: ");
            System.out.printf("Luong Max: ");
            double luongMax = kiemtra.kiemtraDouble("Luong Max: ");
            System.out.println("");
            for (int i = 0; i < dsnv.size(); i++) {
                NhanVien temp = dsnv.get(i);
                if (temp.getThuNhap() >= luongMin && temp.getThuNhap() <= luongMax) {
                    temp.xuatThongTin();
                    System.out.println("");
                    tim = false;
                    dem++;
                }
            }
            if (tim) {
                System.out.println("Khong tim thay nhan vien nao co luong tu " + fm.format(luongMin) + "VND den " + fm.format(luongMax) + "VND");
            } else {
                System.out.println("Da tim thay " + dem + " nhan vien co thu nhap tu " + fm.format(luongMin) + "VND den " + fm.format(luongMax) + "VND");
            }
        }
    }

    // sap xep nhan vien theo thu nhap
    public void sapXepThuNhap() {
        if (dsnv.isEmpty()) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tKhong co nhan vien nao trong danh sach!");
            System.out.println("");
        } else if (dsnv.size() == 1) {
            System.out.println("\nChi co 1 nhan vien trong danh sach nen khong can sap xep!\n");
        } else {
            System.out.println("");
            System.out.println("1. Sap xep luong tu Min - Max | 2. Sap xep luong tu Max - Min | 3. Huy sap xep!");
            System.out.printf("Chon chuc nang: ");
            int chon = kiemtra.kiemtraInt("Chon chuc nang: ", 1, 3);
            if (chon == 1) {
                Comparator<NhanVien> sortLuong = new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        if (o1.getThuNhap() > o2.getThuNhap()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                };
                Collections.sort(dsnv, sortLuong);
                System.out.println("\nLuong nhan vien da duoc sap xep tang dan!\n");
            } else if (chon == 2) {
                Comparator<NhanVien> sortLuong = new Comparator<NhanVien>() {
                    @Override
                    public int compare(NhanVien o1, NhanVien o2) {
                        if (o1.getThuNhap() > o2.getThuNhap()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                };
                Collections.sort(dsnv, sortLuong);
                System.out.println("\nLuong nhan vien da duoc sap xep giam dan!\n");
            } else {
                System.out.println("\nBan da huy thao tac nay!\n");
            }
        }
    }

    // xuat 5 nhan vien co thu nhap cao nhat
    public void nhanVienThuNhapCao() {
        if (dsnv.isEmpty()) {
            System.out.println("");
            System.out.print((char) 27 + "[31m" + "\tKhong co nhan vien nao trong danh sach!");
            System.out.println("");
        } else {
            ArrayList<NhanVien> copy = new ArrayList<NhanVien>(dsnv);

            Comparator<NhanVien> sortMax = new Comparator<NhanVien>() {
                @Override
                public int compare(NhanVien o1, NhanVien o2) {
                    if (o1.getThuNhap() > o2.getThuNhap()) {
                        return -1;

                    } else {
                        return 1;
                    }
                }
            };
            Collections.sort(copy, sortMax);
            for (int i = 0; i < copy.size(); i++) {
                NhanVien temp = copy.get(i);
                temp.xuatThongTin();
                System.out.println("");
                if (i == 4) {
                    break;
                }
            }
        }
    }
}
