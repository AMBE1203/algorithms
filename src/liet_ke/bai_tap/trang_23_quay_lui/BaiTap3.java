package liet_ke.bai_tap.trang_23_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 23/04/2018.
 * Cho 2 số nguyên dương k, n. Hãy liệt kê các xâu nhị phân độ dài n có tính chất
 * bất kỳ 2 xâu con nào có độ dài k liền nhau đều khác nhau.
 */
public class BaiTap3 {
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
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
        System.out.print("\t" + dem);
        System.out.println();
    }

    public  boolean check(int i) {


        if (i >= 2 * k - 1) {

            int sluong = 0;


            for (int j = i - 2 * k + 1; j < i - k + 1; j++) {
                if (arr[j] == arr[j + k]) {
                    sluong++;
                }
            }

            if (sluong == k) {
                return false;
            } else {
                return true;
            }
        }
        return true;


    }

    public  void giaiThuat(int i) {
        for (int j = 0; j <= 1; j++) {
            arr[i] = j;
            if (check(i)) {

                if (i == n - 1) {
                    result();
                } else {

                    giaiThuat(i + 1);
                }
            }


        }

    }

    public static void main(String[] args) {
        BaiTap3 baiTap3=new BaiTap3();
        baiTap3.init();
        baiTap3.giaiThuat(0);

    }

}
