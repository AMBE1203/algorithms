package liet_ke.bai_tap.trang_11_phuong_phap_sinh;

/**
 * Created by AMBE on 20/04/2018.
 * Liệt kê các chỉnh hợp không lặp chập k của n phần tử ( có quan tâm đến thứ tự xếp )
 * VD A B C vs C B A là 2 phần tử khác nhau
 * Dùng 2 cách:
 * Cách 1: phương pháp sinh
 * Cách 2: Liệt kê tất cả các tập con k phần tử của tập n phần tử, rồi in ra đủ k! hoán vị của nó.
 * ===> liệt kê các tổ hợp chập k của n, rồi in ra các hoán vị của nó
 */
public class BaiTap8 {

    public  boolean check(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    // 123 124 132 134 142 143 213 214

    public  void giaiThuat1(int n, int k) {
        int i;
        int[] arr = new int[n];
        for (i = 0; i < k; i++) {
            arr[i] = 0;
        }

        do {

            if (check(arr, k)) {
                for (i = 0; i < k; i++) {
                    System.out.print(arr[i]+1);
                }
                System.out.println();
            }

//            for (i = 0; i < k; i++) {
//                    System.out.print(arr[i] + 1);
//                }
//                System.out.println();
//

            i = k - 1;

            while (i >= 0 && arr[i] == n - 1) {
                i--;
            }

            if (i >= 0) {
                arr[i]++;
                for (int j = i + 1; j < n; j++) {
                    arr[j] = 0;
                }

            }


        } while (i >= 0);
    }




    public static void main(String[] args) {
        BaiTap8 baiTap8=new BaiTap8();
        baiTap8.giaiThuat1(4, 4);

    }

}
