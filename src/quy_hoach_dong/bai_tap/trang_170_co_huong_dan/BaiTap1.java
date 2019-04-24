package quy_hoach_dong.bai_tap.trang_170_co_huong_dan;

/**
 * Created by AMBE on 08/26/2018 at 23:56.
 * Nhập vào 2 số nguyên dương n,k <= 100.
 * Có bao nhiêu số nguyên dương có <=n chữ số mà tổng các chữ số = k. Nếu có hơn 1 tỉ số
 * thì thông báo có nhiều hơn 1 tỉ.
 * Ta sẽ đếm các số có n chữ số vs tổng các chữ số = k. tính cả số 0 ở đầu. ví dụ 0045 có tổng = 9.
 * F[n][k] là số các số có n chữ số có tổng các chữ số = k.
 * Biểu diễn các số = 1 mảng x[1..n] gồm các chữ số từ 0->9 mà x[1] +..+x[n]=k.
 * Nếu cố định x[1] = t. thì ta nhận thấy x[2..n] lập thành 1 số có n-1 chữ số mà tổng các chữ số = k -t.
 * vì x[1] có thể nhận các giá trị từ 0->9 nên F[n][k] = tổng xích ma F[n-1][k-t] với 0<=t<=9. và t <= k.
 * Nếu tại bước nào đó tính được F > 10^9 thì dặt F = 10^9 + 1 để tránh bị tràn số.
 * kết thúc quá trình tính toán, nếu F[n][k] = 10^9 + 1 thì in ra có > 1 tỉ số.
 * Cơ sở quy hoạch động là
 * F[1][k] = 1 với mọi 0<= k<=9
 * F[1][k] = 0 với mọi trường hợp khác.
 * Nhập vào số p < 1 tỷ.
 * In ra số thứ p ở trên.
 */
public class BaiTap1 {

    private int n;
    private int k;
    private int[][] F;

    public BaiTap1(int n, int k, int[][] f) {
        this.n = n;
        this.k = k;
        F = f;
    }

    private void optimize() {
        for (int i = 0; i <= k; i++) {
            if (i <= 9) {
                F[1][i] = 1;
            } else {
                F[1][i] = 0;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int t = 0;

                do {
                    if (t <= j) {
                        F[i][j] += F[i - 1][j - t];
                        if (F[i][j] > Math.pow(10, 9)) {
                            F[i][j] = (int) (Math.pow(10, 9) + 1);
                        }
                    }
                    t++;
                } while (t <= 9);


            }
        }

        if (F[n][k] == (int) (Math.pow(10, 9) + 1)) {
            System.out.println("co > 1 ti so");
        } else {
            System.out.println("F[" + n + "][" + k + "] = " + F[n][k]);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 10;

        int[][] F = new int[100][100];

        BaiTap1 baiTap1 = new BaiTap1(n, k, F);
        baiTap1.optimize();
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= k; j++) {

                System.out.printf(F[i][j] + "\t");

            }

            System.out.println();

        }
    }
}
