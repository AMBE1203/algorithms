package quy_hoach_dong.demo.trang_145_cai_dat_de_quy;

import java.util.Scanner;

/**
 * Created by AMBE on 07/18/2018 at 23:28.
 */
public class DemoPhanTichSo {
    private int n = 100;
    private int[][] arr = new int[n + 1][n + 1];

    private int getF(int m, int v) {

        if (arr[m][v] == 0) { // neu F[m,v] chua biet thi di tinh
            // phan neo

            if (m == 0) {
                if (v == 0) {
                    arr[m][v] = 1;
                } else {
                    arr[m][v] = 0;
                }
            } else {
                // phan de quy
                if (m > v) {
                    arr[m][v] = getF(m - 1, v);
                } else {
                    arr[m][v] = getF(m - 1, v) + getF(m, v - m);
                }
            }

        }

        return arr[m][v];

    }

    public static void main(String[] args) {
        DemoPhanTichSo demoPhanTichSo = new DemoPhanTichSo();

        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        System.out.println("So cach phan tich n thanh tong cac do nguyen duong la: ");
        System.out.printf(demoPhanTichSo.getF(n, n) + " ");
    }
}
