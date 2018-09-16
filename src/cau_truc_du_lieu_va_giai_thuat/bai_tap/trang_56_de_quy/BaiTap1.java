package cau_truc_du_lieu_va_giai_thuat.bai_tap.trang_56_de_quy;

import java.util.Scanner;

/**
 * Created by AMBE on 03/05/2018.
 * Tìm UCLN dùng đệ quy
 */
public class BaiTap1 {
    private  int a, b;

    private  int UCLN(int x, int y) {

        return y == 0 ? x : UCLN(y, x % y);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("a = ");
        int a = scanner.nextInt();
        System.out.printf("b = ");
        int b = scanner.nextInt();
        BaiTap1 baiTap1=new BaiTap1();
        System.out.printf("UCLN = " + baiTap1.UCLN(a, b));
    }
}
