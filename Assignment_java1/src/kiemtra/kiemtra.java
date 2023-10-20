/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiemtra;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DUYVAN
 */
// ASM
public class kiemtra {

    public static int kiemtraInt() {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        while (true) {
            try {
                x = scan.nextInt();
            } catch (Exception ex) {
                scan.nextLine();
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("Nhập lại: ");
                continue;
            }
            return x;
        }
    }

    public static int kiemtraInt(String y) {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        while (true) {
            try {
                x = scan.nextInt();
            } catch (Exception ex) {
                scan.nextLine();
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("%s", y);
                continue;
            }
            return x;
        }
    }

    public static int kiemtraInt(String y, int batdau, int ketthuc) {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        while (true) {
            try {
                x = scan.nextInt();
            } catch (Exception ex) {
                scan.nextLine();
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("%s", y);
                continue;
            }
            if (!(x >= batdau && x <= ketthuc)) {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tKhong tim thay chuc nang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("%s", y);
                continue;
            }
            return x;
        }
    }

    public static double kiemtraDouble() {
        Scanner scan = new Scanner(System.in);
        double x = 0;
        while (true) {
            try {
                x = scan.nextDouble();
            } catch (Exception ex) {
                scan.nextLine();
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("Nhập lại: ");
                continue;
            }
            return x;
        }
    }

    public static double kiemtraDouble(String y) {
        Scanner scan = new Scanner(System.in);
        double x = 0;
        while (true) {
            try {
                x = scan.nextDouble();
            } catch (Exception ex) {
                scan.nextLine();
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("%s", y);
                continue;
            }
            return x;
        }
    }

    public static String RanDomMaNV() {
        Random random = new Random();
        StringBuilder so = new StringBuilder();
        for (int j = 0; j < 4; j++) {
            int rd = random.nextInt(10);
            so.append(rd);
        }
        String nn = so.toString();
        return nn;
    }

    public static String yesno() {
        do {
            String yes = new Scanner(System.in).nextLine();
            if (yes.equalsIgnoreCase("y") || yes.equalsIgnoreCase("n")) {
                return yes;
            } else {
                System.out.printf("Nhap lai: ");
            }
        } while (true);
    }

    public static String yesno(String menu) {
        do {
            String yes = new Scanner(System.in).nextLine();
            if (yes.equalsIgnoreCase("y") || yes.equalsIgnoreCase("n")) {
                return yes;
            } else {
                System.out.print((char) 27 + "[31m" + menu);
            }
        } while (true);
    }

    public static String nhapSoStringDouble(String y) {
        String a = "";
        do {
            try {
                a = new Scanner(System.in).nextLine();
                if (!a.equals("")) {
                    double b = Double.parseDouble(a);
                }
            } catch (Exception ex) {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("%s", y);
                continue;
            }
            return a;
        } while (true);

    }
//

    public static String nhapSoStringDouble(String y, int min, int max) {
        String a = "";
        do {
            try {
                a = new Scanner(System.in).nextLine();
                if (!a.equals("")) {
                    double b = Double.parseDouble(a);
                }
            } catch (Exception ex) {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("%s", y);
                continue;
            }
            if (!a.equals("")) {
                double c = Double.parseDouble(a);
                if (!(c >= min && c <= max)) {
                    System.out.println("");
                    System.out.print((char) 27 + "[31m" + "\tHoa hong tu 0% den 100%!\n");
                    System.out.println("");
                    System.out.printf("%s", y);
                    continue;
                }
            }

            return a;
        } while (true);

    }
//

    public static String nhapSoStringInt(String y) {
        String a = "";
        do {
            try {
                a = new Scanner(System.in).nextLine();
                if (!a.equals("")) {
                    int b = Integer.parseInt(a);
                }
            } catch (Exception ex) {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("%s", y);
                continue;
            }
            return a;
        } while (true);

    }

    public static String nhapSoStringInt(String y, int min, int max) {
        String a = "";
        do {
            try {
                a = new Scanner(System.in).nextLine();
                if (!a.equals("")) {
                    int b = Integer.parseInt(a);
                }
            } catch (Exception ex) {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("%s", y);
                continue;
            }
            if (!a.equals("")) {
                int c = Integer.parseInt(a);
                if (!(c >= min && c <= max)) {
                    System.out.println("");
                    System.out.print((char) 27 + "[31m" + "\tSo ngay cong tu 0 den 31 ngay!\n");
                    System.out.println("");
                    System.out.printf("%s", y);
                    continue;
                }
            }

            return a;
        } while (true);

    }

    public static String nhapHoTen(String y) {
        String pattern = "[a-zA-Z ]{2,25}";

        while (true) {
            String hoten = new Scanner(System.in).nextLine();
            if (hoten.matches(pattern) || hoten.equals("")) {
                return hoten;
            } else {
                System.out.println("");
                System.out.print((char) 27 + "[31m" + "\tNhap sai dinh dang, vui long nhap lai!\n");
                System.out.println("");
                System.out.printf("%s", y);
            }
        }
    }

    public static boolean enterTiepTuc(String y) {
        do{
        String a = new Scanner(System.in).nextLine();
        if (a.equals("")) {
            return true;
        } else if(a.equalsIgnoreCase("n")){
            return false;
        }else{
            System.out.printf("%s",y);
        }
        }while(true);
    }

    // test main
    public static void main(String[] args) {

//        while (true) {
//            System.out.printf("Nhap a: ");
//            String a = nhapSoDouble("Nhap a: ");
//
//            System.out.println("\ngia tri cua a la: " + a);
//            if (a.equals("")) {
//                break;
//            }
//        }
//        int x = 3;
//        System.out.printf("Nhap họ ten: ");
//        String hoten = nhapHoTen("nhap ho ten: ");
//        System.out.println("ho ten cua ban la: " + hoten);
//        System.out.printf("Nhap so ngay cong: ");
//        String Sngaycong = nhapSoStringInt("Nhap so ngay cong: ");
//        int ngaycong = Integer.parseInt(Sngaycong);
//        System.out.println("so ngay cong la" + ngaycong);
        System.out.print("Ti le hoa hong (0% -> 100%): ");
    }

    //
}
