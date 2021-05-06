package quy_hoach_dong.bai_tap.trang_170_co_huong_dan;

/**
 * Created by AMBE on 09/16/2018 at 18:00.
 */
public class BaiTap4 {


    private int max(int x, int y, int z) {
        int max;
        if (x < y) {
            max = y;
        } else {
            max = x;
        }
        if (z > max) {
            max = z;
        }
        return max;
    }

    private int maxArr(int[] A) {
        int max = A[0];
        int x = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                x = i;
            }
        }

        return x;
    }


    // tính bảng phương án
    private void optimize(int m, int n, int[][] A, int[][] B) {
        for (int i = 1; i < m; i++) {
            B[i][1] = A[i][1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 2; j < n; j++) {
                B[i][j] = max(B[i][j - 1], B[i - 1][j - 1], B[i + 1][j - 1]) + A[i][j];
            }
        }
    }

    private void trace(int[][] B, int m, int n) {
        int[] X = new int[m];

        for (int i = 1; i < m; i++) {
            X[i] = B[i][n - 1];
        }
        int k = maxArr(X);
        System.out.println("Gia tri lon nhat la: " + X[maxArr(X)]);
        System.out.println("------------------------");

        while (n - 1 != 0) {
            if (max(B[k][n - 1], B[k - 1][n - 1], B[k + 1][n - 1]) == B[k][n - 1]) {
                k += 0;
            } else if (max(B[k][n - 1], B[k - 1][n - 1], B[k + 1][n - 1]) == B[k - 1][n - 1]) {
                k -= 1;
            } else if (max(B[k][n - 1], B[k - 1][n - 1], B[k + 1][n - 1]) == B[k + 1][n - 1]) {
                k += 1;
            }
            System.out.print("A[" + k + "][" + (n - 1) + "]" + " \t");
            n--;
        }

    }

    public static void main(String[] args) {
        int m = 5;
        int n = 6;
        int[][] A = new int[10][10];
        int[][] B = new int[10][10];
        A[1][1] = 10;
        A[1][2] = 2;
        A[1][3] = 6;
        A[1][4] = 7;
        A[1][5] = 9;
        A[2][1] = 21;
        A[2][2] = 6;
        A[2][3] = 5;
        A[2][4] = 6;
        A[2][5] = 7;
        A[3][1] = 1;
        A[3][2] = 2;
        A[3][3] = 3;
        A[3][4] = 4;
        A[3][5] = 2;
        A[4][1] = 4;
        A[4][2] = 7;
        A[4][3] = 8;
        A[4][4] = 7;
        A[4][5] = 22;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                System.out.printf(A[i][j] + " \t");
            }
            System.out.println();
        }


        BaiTap4 baiTap4 = new BaiTap4();
        baiTap4.optimize(m, n, A, B);

        System.out.println("------------------------");
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                System.out.printf(B[i][j] + " \t");
            }
            System.out.println();
        }
        System.out.println("------------------------");
        baiTap4.trace(B, m, n);


    }
}
