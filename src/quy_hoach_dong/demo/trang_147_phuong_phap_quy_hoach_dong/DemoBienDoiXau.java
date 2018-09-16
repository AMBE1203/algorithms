package quy_hoach_dong.demo.trang_147_phuong_phap_quy_hoach_dong;

import java.util.Arrays;

/**
 * Created by AMBE on 08/20/2018 at 23:01.
 */
public class DemoBienDoiXau {

    private int[][] F;
    private String[] X, Y;
    private int m, n;

    public DemoBienDoiXau(int[][] f, String[] x, String[] y, int m, int n) {
        F = f;
        X = x;
        Y = y;
        this.m = m;
        this.n = n;
    }

    private int min(int x, int y, int z) {
        int min;
        if (x < y) {
            min = x;
        } else {
            min = y;
        }
        if (z < min) {
            min = z;
        }
        return min;
    }

    private void optimize() {

        for (int i = 0; i <= m; i++) {
            F[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            F[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i].equals(Y[j])) {
                    F[i][j] = F[i - 1][j - 1];
                } else {
                    F[i][j] = min(F[i][j - 1], F[i - 1][j - 1], F[i - 1][j]) + 1;
                }
            }
        }

    }

    private void trade() {
        System.out.println("So cach nho nhat la n = " + F[m][n]);
        while (m != 0 || n != 0) {
            if (X[m].equals(Y[n])) {
                m--;
                n--;
            } else {
                if (F[m][n] == F[m][n - 1] + 1) { // neu la phep chen
                    System.out.println("insert(" + m + "," + Y[n] + ")");
                    X[m + 1] = Y[n]; // truy sang phai
                    n--;
                } else if (F[m][n] == F[m - 1][n - 1]) { // neu la phep thay
                    System.out.println("replace(" + m + "," + Y[n] + ")");
                    X[m] = Y[n];
                    m--; // truy cheo len tren
                    n--;
                } else {
                    System.out.println("delete(" + m + ")"); // neu la phep xoa
                    X[m] = "";
                    m--; // truy len tren
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] F = new int[100][100];
        String[] X = {"", "A", "B", "C", "D"};
        String[] Y = {"", "E", "A", "B", "D"};
        int m = X.length - 1;
        int n = Y.length - 1;

        DemoBienDoiXau demoBienDoiXau = new DemoBienDoiXau(F, X, Y, m, n);
        demoBienDoiXau.optimize();
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf(F[i][j] + "");
            }
            System.out.println();
        }
             demoBienDoiXau.trade();
    }

}
