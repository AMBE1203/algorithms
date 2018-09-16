package liet_ke.bai_tap.trang_30_ky_thuat_nhanh_can;

import java.util.Scanner;

/**
 * Created by AMBE on 02/05/2018.
 * Cho 1 bãi mìn kích thước mxn ô vuông, trên 1 ô có thể có mìn hoặc không.Để biểu diễn bản đồ mìn có 2 cách:
 * Cách 1: dùng bản đồ mật độ, sử dụng lưới ô vuông kích thước mxn trên đó tại ô (i,j)
 * ghi 1 số từ 0-->8 cho biết tổng số mìn trong các ô lân cận với ô (i,j)
 * Cách 2: dùng bản đồ đánh dấu, sử dụng lưới ô vuông kích thước mxn, trên đó tại ô (i,j)
 * ghi số 1 nếu ô đó có mìn, ghi số 0 nếu ô đó không có mìn
 * Đề bài: chuyển từ bản đồ cách 1--> bản đồ cách 2
 */
public class BaiTap2 {
    private  int n;
    private  int m;
    private  int[][] broad;
    private  int[][] mine;
    private  int[][] neighbour;
    private  int[] h = {-1, -1, 0, 1, 1, 1, 0};
    private  int[] c = {-1, 0, 1, 1, 1, 0, -1, -1};


    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("n = ");
        n = scanner.nextInt();
        System.out.printf("m = ");
        m = scanner.nextInt();
        broad = new int[n][m];
        mine = new int[n][m];
        neighbour = new int[n][m];

    }

    private  void checkMine(int i, int j) {
        int dem = 0;
        for (int t = 0; t < 8; t++) {
            int x = i + h[t];
            int y = i + c[t];
            if (neighbour[x][y] == 1) {
                dem++;

            }
        }
        if (dem == broad[i][j]) {

        }

    }

    private  void result() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mine[i][j]);
            }
            System.out.println();
        }
    }

    private  void giaiThuat(int i, int j, int k) {
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                mine[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        BaiTap2 baiTap2=new BaiTap2();
        baiTap2.init();
        baiTap2.result();
    }

}
