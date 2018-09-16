package liet_ke.demo.trang_24_ky_thuat_nhanh_can;

import java.util.Scanner;

/**
 * Created by AMBE on 30/04/2018.
 * Cho trước 1 số nguyên dương N <= 100.
 * Hãy tìm 1 xâu chỉ gồm các ký tự ABC thỏa mãn 3 điều kiện:
 * - Có độ dài N
 * - Hai đoạn con bất kỳ liền nhau đều khác nhau ( đoạn con là 1 dãy ký tự liên tiếp của xâu)
 * - Có ít ký tự C nhất
 * - A=1; B=2; C=3;
 * Kỹ thuật nhánh cận:
 * Nếu dây x[1..n] thỏa mãn 2 đoạn con bất kỳ liền nhau đều khác nhau, thì trong 4 ký tự liên tiếp
 * bất kỳ bao giờ cũng phải có 1 kỳ tự C
 * Như vậy 1 dãy con gồm k ký tự liên tiếp của dãy x thì số ký tự trong dãy con đó bắt buộc phải >= k div 4
 * ---> dùng minC > t[i] + (n-i) div 4 để đánh giá nhánh cận tại bước i
 **/
public class DemoDayABC {
    private  int n;
    private  int max = 100;
    private  int minC;
    private  int[] x;
    private  int[] best;
    private  int[] t; // t[i] cho biet so ky tu c trong doan tu x[1] den x[i]

    // ham nay cho biet xau gom l ky tu ket thuc tai x[i] co trung voi xau l ky tu lien truoc no k
    public  boolean same(int i, int l) {
        int j = i - l;
        for (int k = 0; k <= l - 1; k++) {
            if (x[i - k] != x[j - k]) {
                return false;
            }
        }
        return true;

    }

    // ham nay cho biet x[i] co lam hong tinh khong lap cua day x[1...i] hay k

    public  boolean check(int i) {
        for (int l = 1; l <= i / 2; l++) { // thu cac do dai l

            if (same(i, l)) {
                return false;
            }

        }

        return true;

    }

    // ham giu lai ket qua vua tim duoc vao bestConfig

    public  void keepResult() {
        minC = t[n];
        for (int i = 1; i <= n; i++) {
            best[i] = x[i];
        }
    }

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        n = scanner.nextInt();
        x = new int[max+1];
        best = new int[max+1];
        t = new int[max+1];
        t[0] = 0;
        minC = n; // khoi tao cau hinh bestConfig ban dau rat tồi
    }

    public  void result() {
        System.out.printf("Dap an la: ");
        for (int i = 1; i <= n; i++) {
            //      System.out.printf(best[i] + "  ");
            switch (best[i]) {
                case 1:
                    System.out.printf(" A ");
                    break;
                case 2:
                    System.out.printf(" B ");
                    break;
                case 3:
                    System.out.printf(" C ");
                    break;
            }

        }

        System.out.println();
        System.out.printf("So ky tu C: " + minC);
    }

    public  void giaiThuat(int i) {
        for (int j = 1; j <= 3; j++) {
            x[i] = j;
            if (check(i)) { // neu gia tri thu i khong lam hong tinh khong lap
                if (j == 3) {
                    t[i] = t[i - 1] + 1; // dem so luong ky tu c
                } else {
                    t[i] = t[i - 1];
                }
                if (t[i] + ((n - i) / 4) < minC) { // danh gia nhanh can
                    if (i == n) {
                        keepResult();
                    } else {
                        giaiThuat(i + 1);
                    }

                }
            }
        }

    }

    public static void main(String[] args) {
        DemoDayABC demoDayABC=new DemoDayABC();
        demoDayABC.init();
        demoDayABC.giaiThuat(1);
        demoDayABC.result();
    }

}
