package cau_truc_du_lieu_va_giai_thuat.demo.trang_51_de_quy;

import java.util.Scanner;

/**
 * Created by AMBE on 03/05/2018.
 */
public class DemoTinhGiaiThua {

    private int n;

    public int giaiThuat(int x) {
        if (x == 0) return 1;
        else return x * giaiThuat(x - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("n = ");
        int n = scanner.nextInt();
        DemoTinhGiaiThua demoTinhGiaiThua = new DemoTinhGiaiThua();
        System.out.printf("n! = " + demoTinhGiaiThua.giaiThuat(n));

    }
}
