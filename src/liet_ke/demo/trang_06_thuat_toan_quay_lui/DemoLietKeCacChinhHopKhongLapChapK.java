package liet_ke.demo.trang_06_thuat_toan_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 23/04/2018.
 */
public class DemoLietKeCacChinhHopKhongLapChapK {
    private  int[] arr;
    private  int n;
    private  int k;
    private  int dem;
    private  boolean[] check;

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = scanner.nextInt();
        System.out.print("Nhập k: ");
        k = scanner.nextInt();
        arr = new int[k];
        check = new boolean[n];
        for (int j = 0; j < n; j++) {
            check[j] = true;
        }


    }

    public  void giaiThuat(int i) {
        for (int j = 0; j < n; j++) {

            if (check[j]) {
                arr[i] = j;
                if (i == k -1) {
                    result(arr);
                } else {
                    check[j] = false;
                    giaiThuat(i + 1);
                    check[j] = true;
                }
            }
        }
    }

    public  void result(int[] arr) {
        dem++;
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]+1);
        }
        System.out.print("\t" + dem);
        System.out.println();
    }

    public static void main(String[] args) {
        DemoLietKeCacChinhHopKhongLapChapK demoLietKeCacChinhHopKhongLapChapK=new DemoLietKeCacChinhHopKhongLapChapK();
        demoLietKeCacChinhHopKhongLapChapK.init();
        demoLietKeCacChinhHopKhongLapChapK.giaiThuat(0);
    }


}
