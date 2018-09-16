package liet_ke.bai_tap.trang_11_phuong_phap_sinh;

/**
 * Created by AMBE on 21/04/2018.
 * Liệt kê tất cả các hoán vị chữ cái trong từ MISSISSIPPI theo thứ tự từ điển.
 * ý tường: M=1,I=2,S=3,P=4 ===> 12332332442
 */
public class BaiTap9 {

    public  void giaiThuat() {
        int[] arr = {1, 2, 2,2,2 ,3, 3,3, 3, 4, 4};
        int n = arr.length;
        int i, k, temp, x, y;
        int dem=1;


        do {
            for (i = 0; i < n; i++) {
                if (arr[i] == 1) {
                    System.out.print("M");
                } else if (arr[i] == 2) {
                    System.out.print("I");

                } else if (arr[i] == 3) {
                    System.out.print("S");


                } else if (arr[i] == 4) {
                    System.out.print("P");

                }

            }
            System.out.print("\t"+ dem);
            System.out.println();
            i = n - 2;
            while (i >= 0 && arr[i] >= arr[i + 1]) {
                i--;
            }
            if (i >= 0) {
                k = n - 1;
                while (arr[i] >= arr[k]) {
                    k--;

                }

                temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;

                x = i + 1;
                y = n - 1;
                while (x < y) {
                    temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                    x++;
                    y--;
                }


            }
            dem++;

        } while (i >= 0);


    }

    public static void main(String[] args) {
        BaiTap9 baiTap9=new BaiTap9();
        baiTap9.giaiThuat();

    }
}
