package quy_hoach_dong.demo.trang_142_cong_thuc_truy_hoi;

import java.util.Scanner;

/**
 * Created by AMBE on 07/18/2018 at 22:01.
 * Dùng 2 mảng 1 chiều.
 * Mảng current để lưu dòng hiện thời đang xét ( dòng k )
 * Mảng next để lưu dòng kể tiếp ( dòng k + 1)
 * Sau đó gán current = next ...
 */
public class DemoPhanTichSoCaiTienThuNhat {

    private int analyse(int n) {
        int[] current = new int[n + 1];
        int[] next = new int[n + 1];
        int m, v;

        current[0] = 1;
        for (m = 1; m <= n; m++) {
            for (v = 0; v <= n; v++) {
                if (v < m) {
                    next[v] = current[v];
                } else {
                    next[v] = current[v] + next[v - m];
                }
            }
            current = next;
        }

        return current[n];
    }

    public static void main(String[] args) {
        DemoPhanTichSoCaiTienThuNhat demoPhanTichSoCaiTienThuNhat = new DemoPhanTichSoCaiTienThuNhat();

        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        System.out.println("So cach phan tich n thanh tong cac do nguyen duong la: ");
        System.out.printf(demoPhanTichSoCaiTienThuNhat.analyse(n) + " ");
    }
}
