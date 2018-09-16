package liet_ke.bai_tap.trang_23_quay_lui;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by AMBE on 24/04/2018.
 * Liệt kê tất cả các tập con của S vs giá trị nhập từ bàn phím nhưng chỉ liệt kê các tập con
 * thỏa mãn điều kiện max - min <= T ( với T cho trước )
 */
public class BaiTap6 {

    private  int[] arr;
    private  int[] arrNhap;
    private  int n;
    private  int dem;
    private  int t;


    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = scanner.nextInt();
        System.out.print("Nhập T: ");
        t = scanner.nextInt();

        arrNhap = new int[n + 1];
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arrNhap[i] = scanner.nextInt();
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                if (arrNhap[i] > arrNhap[j]) {
//                    int temp = arrNhap[i];
//                    arrNhap[i] = arrNhap[j];
//                    arrNhap[j] = temp;
//                }
//            }
//        }
        Arrays.sort(arrNhap);
        for (int i = 1; i < arrNhap.length; i++) {
            System.out.print(arrNhap[i]);
        }
        System.out.println();


        dem = 0;

    }

    public  void result(int k) {

        dem++;

        for (int i = 1; i <= k; i++) {
            System.out.print(arrNhap[arr[i]]);
        }
        System.out.print("\t" + dem);
        System.out.println();


    }


    public  void giaiThuat(int i, int k) {


        for (int j = arr[i - 1] + 1; j <= n - k + i; j++) {
            arr[i] = j;


            if (i == k) {

                if (arrNhap[arr[k]] - arrNhap[arr[1]] <= t) {
                    result(k);
                }
            } else {
                giaiThuat(i + 1, k);
            }

        }


    }

    public void demo(){
        for (int k = 2; k <= n; k++) {
            giaiThuat(1, k);
        }

        System.out.println("T= " + t);

    }

    public static void main(String[] args) {
        BaiTap6 baiTap6=new BaiTap6();
        baiTap6.init();
        baiTap6.demo();

    }
}
