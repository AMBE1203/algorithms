package liet_ke.demo.trang_06_thuat_toan_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 23/04/2018.
 */
public class DemoLietKeDayNhiPhanDoDaiN {

    private  int[] arr;
    private  int n;
    private  int dem;

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = scanner.nextInt();
        arr = new int[n];
        dem = 0;

    }

    public  void result(int[] arr) {
        dem++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.print("\t" + dem);
        System.out.println();
    }

    public  void giaiThuat(int i) {
        for (int j = 0; j <= 1; j++) {
            arr[i] = j;
            if (i == n - 1) {
                result(arr);

            } else {
                giaiThuat(i + 1);
            }
        }


    }

    public static void main(String[] args) {
        DemoLietKeDayNhiPhanDoDaiN demoLietKeDayNhiPhanDoDaiN=new DemoLietKeDayNhiPhanDoDaiN();
        demoLietKeDayNhiPhanDoDaiN.init();
        demoLietKeDayNhiPhanDoDaiN.giaiThuat(0);
//        result(arr);

    }
}
