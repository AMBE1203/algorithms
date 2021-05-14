package quy_hoach_dong.bai_tap.trang_172_khong_co_huong_dan;

/**
 * Created by AMBE on 24/4/2019 at 9:12 AM.
 * Tìm xâu con đối xứng dài nhất của 1 xâu cho trước
 * Cách 1: đảo lại xâu đã cho, dùng thuật toán tìm xâu con chung dài nhất.
 * Cách 2: gọi f[i,j] là chuỗi đối xứng dài nhất từ i đến j (i<=j)
 * nếu s[i]=s[j] thì f[i,j]=f[i+1,j-1] + 2
 * ngược lại f[i,j]=max (f[i+1,j],f[i,j-1])
 */
public class BaiTap4 {

    String s;

    public BaiTap4(String s) {
        this.s = s;
    }

    private int optimize() {
        String maxPalindrome = "";

        int n = s.length();
        int[][] F = new int[n][n];

        for (int i = 0; i < n; i++) {
            F[i][i] = 1;
        }

        for (int k = 1; k < n; k++) {
            for (int i = 0; i < (n - k); i++) {
                int j = k + i;

                if (s.charAt(i) == s.charAt(j)) {
                    F[i][j] = F[i + 1][j - 1] + 2;
                } else {
                    F[i][j] = Math.max(F[i + 1][j], F[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(F[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(F[0][n - 1]);


        return F[0][n - 1];
    }

    public static void main(String[] args) {
        String str = "jhdjskh";
        BaiTap4 baiTap4 = new BaiTap4(str);
        baiTap4.optimize();
    }
}
