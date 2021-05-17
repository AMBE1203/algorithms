package quy_hoach_dong.bai_tap.trang_172_khong_co_huong_dan;

/**
 * Created by cuongdt on 5/14/2021.
 * Có n loại tiền giấy: Tờ giấy bạc loại i có mệnh giá là V[i] (n<= 20, 1<= V[i]<= 10000)
 * Hỏi muốn mua 1 món hàng giá trị M thì có bao nhiêu cách trả số tiền đó bằng những loại giấy bạc đã cho.
 * Trường hợp có >1 tỷ cách thì chỉ cần thông báo có nhiều hơn 1 tỷ.
 * Nếu tồn tại cách trả, cho biết cách trả phải dùng ít tờ tiền nhất.
 **/
public class BaiTap6 {
    private int n;
    private int M;
    private int[] V;
    private static int MAX = 999999999;

    public BaiTap6(int n, int m, int[] v) {
        this.n = n;
        M = m;
        V = v;
    }

    private void optimize() {
        int[] F = new int[M + 1];
        F[0] = 0;
        for (int i = 1; i < F.length; i++) {
            F[i] = MAX;
        }

        for (int i = 1; i < F.length; i++) {
            for (int j = 0; j < V.length; j++) {
                if (V[j] <= i && F[i - V[j]] + 1 < F[i]) {
                    F[i] = F[i - V[j]] + 1;
                }
            }
        }

        for (int i : F) {
            System.out.printf(i + "\t");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int M = 11;
        int[] V = {1, 3, 5};

        BaiTap6 baiTap6 = new BaiTap6(n, M, V);
        baiTap6.optimize();
    }
}
