package quy_hoach_dong.bai_tap.trang_172_khong_co_huong_dan;

/**
 * Created by AMBE on 24/4/2019 at 9:16 AM.
 * Tạo 1 xâu đối xứng chứa xâu con S cho trước.
 * F[i, j] = Số ký tự ít nhất cần thêm vào xâu S[i..j] để nó thành 1 xâu đối xứng.
 * Ta có công thức như sau:
 * F[i, i] = 0.
 * F[i, j] = F[i + 1, j - 1] nếu S[i] = S[j].
 * F[i, j] = min(F[i + 1, j], F[i, j - 1]) + 1 nếu S[i] <> S[j].
 * Kết quả sẽ được lưu ở F[1, n], với n là chiều dài của chuỗi S.
 */
public class BaiTap5 {

    String s;

    public BaiTap5(String s) {
        this.s = s;
    }

    private String optimize() {
        String maxPalindrome = "";

        int n = s.length();
        int[][] F = new int[n][n];

        for (int i = 0; i < n; i++) {
            F[i][i] = 0;
        }

        for (int k = 1; k < n; k++) {
            for (int i = 0; i < (n - k); i++) {
                int j = k + i;

                if (s.charAt(i) == s.charAt(j)) {
                    F[i][j] = F[i + 1][j - 1];
                } else {
                    F[i][j] = Math.min(F[i + 1][j], F[i][j - 1]) + 1;
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

        return maxPalindrome;
    }

    public static void main(String[] args) {
        String str = "jhd";
        BaiTap5 baiTap5 = new BaiTap5(str);
        baiTap5.optimize();
    }
}
