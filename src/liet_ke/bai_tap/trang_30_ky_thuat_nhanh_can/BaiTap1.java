package liet_ke.bai_tap.trang_30_ky_thuat_nhanh_can;

import java.util.Scanner;

/**
 * Created by AMBE on 30/04/2018.
 * Một dãy dấu ngoặc hợp lệ là 1 dãy các ký tự "(" và ")" được định nghĩa như sau:
 * - Dãy rỗng là 1 dãy dấu ngoặc kép hợp lệ độ sâu 0
 * - Nếu A là dãy dấu ngoặc hợp lệ độ sâu k thì ( A ) là dãy dấu ngoặc  hợp lệ độ sâu k+1
 * -  Nếu A và B là 2 dãy dấu ngoặc hợp lệ vs độ sâu lần lượt là p và q
 * thì AB là dãy dấu ngoặc hợp lệ độ sâu là max(p,q)
 * Độ dài của 1 dãy ngoặc là tống các ký tự " ( " và" ) "
 * Đề bài: Nhập 2 số n và k. Hãy liệt kê hết các dãy ngoặc hợp lệ có độ dài là n và độ sâu là k
 * Ban đầu độ sâu = 0, gặp ( độ sâu tăng lên 1, gặp ) độ sâu giảm 1
 */
public class BaiTap1 {
    private  int n; // do dai day ngoac
    private  int k; // do sau yeu cau
    private  int countOpen; // so luong ngoac mo
    private  int countClose; // so luong ngoac dong
    private  int leftover; // so luong ngoac con thua lai
    private  int max; // do sau dat duoc
    private  char[] arr; // mang de luu tru dau ngoac
    private  int[] x; // 0 la ( ; 1 la )

    private  int dem;
    private  int[] s;

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("n = ");
        n = scanner.nextInt();
        System.out.printf("k = ");
        k = scanner.nextInt();
        arr = new char[100];
        x = new int[n];
        s = new int[n];

    }

    public  int getMax() {
        int max = s[0];
        for (int i = 0; i < n; i++) {
            if (max < s[i]) {
                max = s[i];
            }

        }

        return max;
    }

    public  boolean check() {
        for (int i = 0; i < n; i++) {
            if (s[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public  void result() {
        if (x[0] == 0 && x[n - 1] == 1) {
            int count = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (x[i] == 0) {
                    count++;
                    max++;
                    s[i] = max;
                } else {
                    max--;
                    s[i] = max;
                }
            }
            if (count == n / 2 && getMax() == k && check()) {
                dem++;
                for (int i = 0; i < n; i++) {
                    if (x[i] == 0){
                        System.out.printf(" ( ");
                    } else {
                        System.out.printf(" ) ");
                    }
                }
                System.out.printf("\t");


                System.out.print("\t" + dem);
                System.out.println();
            }

        }
    }

    public  void giaiThuat(int i) {
        for (int j = 0; j <= 1; j++) {
            x[i] = j;
            if (i == n - 1) {
                result();

            } else {

                giaiThuat(i + 1);
            }

        }


    }

    public static void main(String[] args) {
        BaiTap1 baiTap1=new BaiTap1();
        baiTap1.init();
        baiTap1.giaiThuat(0);
    }

}
