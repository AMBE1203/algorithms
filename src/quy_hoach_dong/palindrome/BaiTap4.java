package quy_hoach_dong.palindrome;

/**
 * Created by cuongdt on 5/6/2021.
 * Bài toán: Cho một xâu độ dài không quá 500, hỏi phải thêm vào nó ít nhất bao nhiêu xâu kí tự để nó trở thành một palindrome.
 * Gọi F[i, j] là số phép biến đổi ít nhất cần thêm vào đoạn [i, j] để nó trở thành palindrome.
 * Ta có:
 * F[i, i] = 0;
 * Nếu Si = Sj thì F[i, j] = F[i+1, j-1]
 * Nếu Si != Sj thì F[i, j] = min(F[i+1, j] , F[i, j-1]) + 1.
 **/
public class BaiTap4 {
    String s;

    public BaiTap4(String s) {
        this.s = s;
    }

    private int optimize() {
        int n = s.length();
        int[][] F = new int[n][n];

        for (int i = 0; i < n; i++) {
            F[i][i] = 0;
        }

        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j)) {
                    F[i][j] = F[i + 1][j - 1];
                } else {
                    F[i][j] = Math.min(F[i + 1][j], F[i][j - 1]) + 1;
                }
            }
        }
        return F[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "abacqa";
        BaiTap4 baiTap4 = new BaiTap4(s);
        int result = baiTap4.optimize();
        System.out.printf("Result: " + result);
    }
}
