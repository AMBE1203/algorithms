package liet_ke.demo.trang_06_thuat_toan_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 23/04/2018.
 * Với n <= 30, phân tích số nguyên n thành tổng các số nguyên nhở hơn n.
 * Các hoán vị của nhau chỉ tính là một cách
 * Ví dụ với n = 5
 * 5
 * 4 1
 * 3 2
 * 3 1 1
 * 2 2 1
 * 2 1 1 1
 * 1 1 1 1 1
 */
public class DemoPhanTichSo {

    private  int[] arr;
    private  int[] sum;
    private  int n;
    private  int dem;

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = scanner.nextInt();
        arr = new int[n + 1];
        sum = new int[n + 1];
        arr[0] = 1;
        sum[0] = 0;


    }

    public  void result(int k) {
        dem++;
        for (int i = 1; i <= k; i++) {
            System.out.print(arr[i] +"\t");
        }
        System.out.print("\t i=" + dem);
        System.out.println();
    }

    public  void giaiThuat(int i) {
        for (int j = arr[i - 1]; j <= (n - sum[i - 1]) / 2; j++) {
            arr[i] = j;
            sum[i] = sum[i - 1] + j;
            giaiThuat(i + 1);
        }
        arr[i] = n - sum[i - 1];
        result(i);


    }

    public static void main(String[] args) {
        DemoPhanTichSo demoPhanTichSo=new DemoPhanTichSo();
        demoPhanTichSo.init();
        demoPhanTichSo.giaiThuat(1);
    }


}
