package quy_hoach_dong.bai_tap.trang_172_khong_co_huong_dan;

import quy_hoach_dong.palindrome.BaiTap4;

/**
 * Created by AMBE on 11/13/2018 at 11:39 AM.
 * Một xâu ký tự X gọi là chứa xâu ký tự Y nếu như có thể xóa bớt 1 số ký tự trong xâu X
 * để được xâu Y: Ví dụ xâu 1a2b3c45d chứa xâu 12345. Một xâu ký tự gọi là đối xứng nếu nó không
 * thay đổi khi ta viết các ký tự trong xâu theo thứ tự ngược lại.
 * Nhập 1 xâu ký tự S có độ dài không quá 128, hãy tìm xâu ký tự T thỏa mãn 3 điều kiện
 * Đối xứng
 * Chứa xâu S
 * Có ít ký tự nhất ( độ dài ngắn nhất )
 *  * F[i, j] = Số ký tự ít nhất cần thêm vào xâu S[i..j] để nó thành 1 xâu đối xứng.
 *  * Ta có công thức như sau:
 *  * F[i, i] = 0.
 *  * F[i, j] = F[i + 1, j - 1] nếu S[i] = S[j].
 *  * F[i, j] = min(F[i + 1, j], F[i, j - 1]) + 1 nếu S[i] <> S[j].
 *  * Kết quả sẽ được lưu ở F[1, n], với n là chiều dài của chuỗi S.
 */
public class BaiTap3 {

    String s;

    public BaiTap3(String s) {
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
        String s = "madamq";
        BaiTap3 baiTap3 = new BaiTap3(s);
        int result = baiTap3.optimize();
        System.out.printf("Result: " + result);
    }
}
