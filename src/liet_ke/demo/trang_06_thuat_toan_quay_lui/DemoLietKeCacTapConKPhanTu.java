package liet_ke.demo.trang_06_thuat_toan_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 23/04/2018.
 * Ta chứng minh đc X[i-1] + 1 <= X[i] <= n -k +i ( 1<= i<=k )
 * Ta giả thiết có thêm 1 số X[0]=0 khi xét i =1;
 */
public class DemoLietKeCacTapConKPhanTu {
    private  int[] arr;
    private  int n;
    private  int k;
    private  int dem;

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = scanner.nextInt();
        System.out.print("Nhập k: ");
        k = scanner.nextInt();
        arr = new int[k+1];
        arr[0] = 0;
        dem = 0;

    }

    public  void result(int[] arr) {
        dem++;
        for (int i = 1; i <= k; i++) {
            System.out.print(arr[i]);
        }
        System.out.print("\t" + dem);
        System.out.println();
    }

    public  void giaiThuat(int i) {
        for (int j = arr[i - 1] + 1; j <= n - k + i; j++) { // i=1; j=1--->j<=5-3 +1 =3 i=2;
            arr[i] = j;
            if (i == k) {
                result(arr);

            } else {
                giaiThuat(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        DemoLietKeCacTapConKPhanTu demoLietKeCacTapConKPhanTu=new DemoLietKeCacTapConKPhanTu();
        demoLietKeCacTapConKPhanTu.init();
        demoLietKeCacTapConKPhanTu.giaiThuat(1);
    }
}
