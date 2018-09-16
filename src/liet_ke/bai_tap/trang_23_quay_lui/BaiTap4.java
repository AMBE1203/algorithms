package liet_ke.bai_tap.trang_23_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 24/04/2018.
 * Liệt kê tổ hợp chập k của tập {1,2,3.....n}
 * Ta chứng minh đc X[i-1] + 1 <= X[i] <= n -k +i ( 1<= i<=k )
 * Ta giả thiết có thêm 1 số X[0]=0 khi xét i =1;
 */
public class BaiTap4 {

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
        arr = new int[k + 1];
//        arr[0] = 0;
        dem = 0;

    }

    public  void result() {
        dem++;
        for (int i = 1; i <= k; i++) {
            System.out.print(arr[i]);
        }
        System.out.print("\t" + dem);
        System.out.println();
    }

    public  void giaiThuat(int i) {
        for (int j = arr[i - 1] + 1; j <= n - k + i; j++) {
            arr[i] = j;
            if (i == k) {
                result();
            } else {
                giaiThuat(i + 1);
            }
        }
    }


    public static void main(String[] args) {
        BaiTap4 baiTap4=new BaiTap4();
        baiTap4.init();
        baiTap4.giaiThuat(1);
    }
}
