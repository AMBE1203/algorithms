package cau_truc_du_lieu_va_giai_thuat.demo.trang_51_de_quy;

import java.util.Scanner;

/**
 * Created by AMBE on 03/05/2018.
 */
public class DemoThapHaNoi {
    private int n = 0;

    private void giaiThuat(int k, int x, int y) {

        if (k == 1) {
            n++;
            System.out.println("Chuyen 1 dia tu " + x + " sang " + y  + "\t" + n);



        } else {

            giaiThuat(k - 1, x, 6 - x - y);
            giaiThuat(1, x, y);
            giaiThuat(k - 1, 6 - x - y, y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("n = ");
        int n = scanner.nextInt();
        DemoThapHaNoi demoThapHaNoi = new DemoThapHaNoi();
        demoThapHaNoi.giaiThuat(n, 1, 3);
    }
}
