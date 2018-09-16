package liet_ke.bai_tap.trang_23_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 28/04/2018.
 * Một dãy x[1..n] gọi là 1 hoán vị hoàn toàn của tập {1,2,...,n}
 * nếu nó là 1 hoán vị thỏa mãn x[i] != i với 1<= i<=n.
 * Hãy viết ct liệt kê tất cả các hoán vị hoàn toàn của tập trên (n vào từ bàn phím)
 */
public class BaiTap7 {

    private  int n;
    private  int[] arr;
    private  boolean[] check;
    private  int dem;

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = scanner.nextInt();
        arr = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            check[i] = true;
        }
    }

    public  void result() {
        dem++;
        for (int i = 0; i < n; i++) {

            System.out.print(arr[i]);
        }
        System.out.print("\t" + dem);
        System.out.println();

    }

    public  void giaiThuat(int i) {
        for (int j = 0; j < n; j++) {
            if (check[j]  ) {

                arr[i] = j;
                if (arr[i] != i) {

                    if (i == n - 1) {
                        result();
                    } else {
                        check[j] = false;
                        giaiThuat(i + 1);
                        check[j] = true;

                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        BaiTap7 baiTap7=new BaiTap7();
        baiTap7.init();

        baiTap7.giaiThuat(0);

    }
}
