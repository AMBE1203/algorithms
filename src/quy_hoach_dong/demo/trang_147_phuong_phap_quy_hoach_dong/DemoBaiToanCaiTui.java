package quy_hoach_dong.demo.trang_147_phuong_phap_quy_hoach_dong;

/**
 * Created by AMBE on 08/13/2018 at 22:16.
 * Trong siêu thị có n <= 100 gói hàng, gói hàng thứ i có trọng lượng W[i] <= 100 và giá trị
 * V[i] <= 100. Có cái túi chứa được tối đa trọng lượng M<=100. Hỏi phải để những gói hàng nào
 * vào túi để tổng giá trị là lớn nhất ?
 */
public class DemoBaiToanCaiTui {
    //   int[] V, W; // V[i] gia tri goi thu i, W[i] khoi luong goi thu i


    // tinh bang phuong an bang cong thuc truy hoi
    private void optimize(int[] V, int[] W, int[][] F, int n, int M) {
        for (int i = 0; i < M; i++) {
            F[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                // tinh F[i,j]
                F[i][j] = F[i - 1][j]; //  giả sử k chọn gói thứ i
                if (j >= W[i] && (F[i][j] < F[i - 1][j - W[i]] + V[i])) {

                    F[i][j] = F[i - 1][j - W[i]] + V[i];

                }
            }
        }
    }


    // Truy vết tìm nghiệm tối ưu
    private void trade(int[] V, int[] W, int[][] F, int n, int M) {
        System.out.println("F = " + F[n - 1][M - 1]);

        while (n != 0) { // duyet nguoc tu hang n --> 0

            if (F[n][M] != F[n - 1][M]) { // neu 2 gia tri khac nhau thi thong bao co chon goi thu n
                System.out.println("n = " + n);
                M = M - W[n]; // nếu chọn gói n thì chỉ mang thêm được khối lượng M - W[n]
            }
            n--;
        }


    }

    public static void main(String[] args) {
        int[] V = new int[100];
        int[] W = new int[100];
        int[][] F = new int[100][100];
        int n = 5;
        int M = 11;
        V[1] = 3;
        V[2] = 4;
        V[3] = 4;
        V[4] = 10;
        V[5] = 4;
        W[1] = 3;
        W[2] = 4;
        W[3] = 5;
        W[4] = 9;
        W[5] = 4;
        DemoBaiToanCaiTui demoBaiToanCaiTui = new DemoBaiToanCaiTui();
        demoBaiToanCaiTui.optimize(V, W, F, n, M);
        demoBaiToanCaiTui.trade(V, W, F, n, M);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < M; j++) {
                // tinh F[i,j]
                System.out.print(F[i][j]);
            }

            System.out.println();


        }
    }

}
