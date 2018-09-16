package quy_hoach_dong.demo.trang_142_cong_thuc_truy_hoi;

import java.util.Scanner;

/**
 * Created by AMBE on 07/18/2018 at 21:19.
 * Cho số tự nhiên n <= 100. Hãy cho biết có bao nhiêu cách phân tích số n thành tổng
 * của các dãy số nguyên dương, các cách phân tích là hoán vị của nhau chỉ tính là 1 cách.
 * Gọi F[m,v] là số cách phân tích số v thành tổng cách số nguyên dương <= m.
 * if m > v
 * F[m,v] = F[m-1,v]
 * ngược lại
 * F[m,v] = F[m-1,v] + F[m,v-m]
 * <p>
 * quy ước F[0,0]=1
 * F[0,v] = 0 với mọi v > 0
 */
public class DemoPhanTichSo {

    private int analysel(int n) {

        int m, v;
        int[][] arr = new int[n + 1][n + 1];
        arr[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[0][i] = 0;
        }
        for (m = 1; m <= n; m++) {
            for (v = 0; v <= n; v++) {
                if (v < m) {
                    arr[m][v] = arr[m - 1][v];
                } else {
                    arr[m][v] = arr[m - 1][v] + arr[m][v - m];
                }
            }
        }

        return arr[n][n];


    }

    public static void main(String[] args) {
        DemoPhanTichSo demoPhanTichSo = new DemoPhanTichSo();

        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        System.out.println("So cach phan tich n thanh tong cac do nguyen duong la: ");
        System.out.printf(demoPhanTichSo.analysel(n) + " ");

    }
}
