package liet_ke.bai_tap.trang_11_phuong_phap_sinh;

import java.util.Scanner;

/**
 * Created by AMBE on 19/04/2018.
 * Nhap vao 1 danh sach n ten nguoi, liet ke tat ca cac cach chon ra dung k nguoi trong so n nguoi do
 * tổ hợp chập k của n ( tổ hợp thì không quan tâm đến thứ tự xếp, còn chỉnh hợp thì có ) tức là với tổ hợp thì A B C vs C B A là 1
 */
public class BaiTap4 {

    public  void giaiThuat(int n, int k) {
        int i;
        String[] arrTen = new String[n];
        int[] arr = new int[n];

        for (i = 0; i < n; i++) {
            arr[i] = i;
        }
        Scanner scanner = new Scanner(System.in);
        for (i = 0; i < n; i++) {
            System.out.print("Nhập tên người: ");
            arrTen[i] = scanner.nextLine();
        }


        do {
            for (i = 0; i < k; i++) {
                System.out.print(arrTen[arr[i]] + "\t");
            }
            System.out.println();

            i = k - 1;
            while (i >= 0 && arr[i] == n - k + i) {
                i--;

            }

            if (i >= 0) {
                arr[i]++;
                for (int j = i + 1; j < k; j++) {
                    arr[j] = arr[j - 1] + 1;
                }
            }


        } while (i >= 0);

    }

    public static void main(String[] args) {
        BaiTap4 baiTap4=new BaiTap4();
        baiTap4.giaiThuat(5, 3);

    }
}
