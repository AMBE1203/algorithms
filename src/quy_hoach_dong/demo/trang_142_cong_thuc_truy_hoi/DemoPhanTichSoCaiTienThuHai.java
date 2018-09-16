package quy_hoach_dong.demo.trang_142_cong_thuc_truy_hoi;

import java.util.Scanner;

/**
 * Created by AMBE on 07/18/2018 at 23:06.
 * Dùng 1 mảng để lưu giá trị current và next
 */
public class DemoPhanTichSoCaiTienThuHai {
    private int analyse(int n) {
        int[] arr = new int[n + 1];
        int m, v;
        arr[0] = 1;
        for (m = 1; m <= n; m++) {
            for (v = m; v <= n; v++) {
                arr[v] = arr[v] + arr[v - m];
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        DemoPhanTichSoCaiTienThuHai demoPhanTichSoCaiTienThuHai = new DemoPhanTichSoCaiTienThuHai();

        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        System.out.println("So cach phan tich n thanh tong cac do nguyen duong la: ");
        System.out.printf(demoPhanTichSoCaiTienThuHai.analyse(n) + " ");
    }
}
