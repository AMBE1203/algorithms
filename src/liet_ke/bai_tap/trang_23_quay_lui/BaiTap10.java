package liet_ke.bai_tap.trang_23_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 29/04/2018.
 * Xét sơ đồ giao thông gồm n nút giao thông đánh số từ 1--> n và m đoạn đường nối chung, mỗi đoạn đường nối 2 nút giao thông.
 * Hãy nhập dữ liệu về mạng lưới giao thông đó, nhập số hiệu 2 nút giao thông s và d.
 * Hãy in ra tất cả các cách đi từ s tới d mà mỗi cách không được qua nút giao thông nào quá 1 lần.
 * ý tưởng: liệt kê tất cả các tập con của tập {1,2...,n} và các hoán vị của nó.
 * Chỉ in ra những cấu hình bắt đầu = s và kết thúc = d.
 */
public class BaiTap10 {
    private  int n;
    private  int s;
    private  int d;
    private  int dem;
    private  int[] arr;
    private  boolean[] check;


    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        n = scanner.nextInt();
        System.out.print("s = ");
        s = scanner.nextInt();
        System.out.print("d = ");
        d = scanner.nextInt();
        arr = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            check[i] = true;
        }

    }

    public  void result(int k) {
        if (arr[0] == s - 1 && arr[k - 1] == d - 1) {
            dem++;

            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + 1);
            }
            System.out.print("\t" + dem);
            System.out.println();
        }
    }

    public  void giaiThuat(int i, int k) {
        for (int j = 0; j < n; j++) {
            if (check[j]) {
                arr[i] = j;
                if (i == k - 1) {
                    result(k);
                } else {
                    check[j] = false;
                    giaiThuat(i + 1, k);
                    check[j] = true;
                }
            }
        }
    }
    public void demo(){
        for (int k = 2; k <= n; k++) {
            giaiThuat(0, k);
        }
    }

    public static void main(String[] args) {
        BaiTap10 baiTap10=new BaiTap10();
        baiTap10.init();
        baiTap10.demo();

    }
}
