package liet_ke.bai_tap.trang_23_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 23/04/2018.
 * Viết chương trình liệt kê các chỉnh hợp lặp chập k của n
 */
public class BaiTap2 {

    private  int[] arr;
    private  int n;
    private  int dem;
    private  int k;

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = scanner.nextInt();
        System.out.print("Nhập k: ");
        k = scanner.nextInt();
        arr = new int[n];
        dem = 0;

    }

    public  void result() {
        dem++;
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + 1);
        }
        System.out.print("\t" + dem);
        System.out.println();
    }


    public  void giaiThuat(int i) {
        for (int j = 0; j < n; j++) {
            arr[i] = j;
            if (i == k -1) {
                result();
            } else {
                giaiThuat(i + 1);
            }

        }
    }

    public static void main(String[] args) {
        BaiTap2 baiTap2=new BaiTap2();
        baiTap2.init();
        baiTap2.giaiThuat(0);
    }
}
