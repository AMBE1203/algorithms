package liet_ke.bai_tap.trang_23_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 24/04/2018.
 * Liệt kê các tập con của tập S gồm n số nguyên với { S(1),....S(n)} bất kỳ được nhập từ bàn phím.
 */
public class BaiTap5 {

    private int[] arr;
    private int[] arrNhap;
    private int n;
    private int dem;

    public void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = scanner.nextInt();
        arrNhap = new int[n + 1];
        arr = new int[n + 1];
        arr[0] = 0;
        arrNhap[0] = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arrNhap[i] = scanner.nextInt();
        }

        dem = 0;

    }

    public void result(int k) {
        dem++;
        for (int i = 1; i <= k; i++) {
            System.out.print(arrNhap[arr[i]]);
        }
        System.out.print("\t" + dem);
        System.out.println();
    }

    public void demo() {
        for (int k = 1; k <= n; k++) {
            giaiThuat(1, k);
        }
    }


    public void giaiThuat(int i, int k) {


        for (int j = arr[i - 1] + 1; j <= n - k + i; j++) {
            arr[i] = j;
            if (i == k) {
                result(k);
            } else {
                giaiThuat(i + 1, k);
            }
        }


    }

    public static void main(String[] args) {
        BaiTap5 baiTap5 = new BaiTap5();
        baiTap5.init();
        baiTap5.demo();

    }

}
