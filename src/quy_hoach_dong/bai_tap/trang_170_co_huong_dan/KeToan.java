package quy_hoach_dong.bai_tap.trang_170_co_huong_dan;

import java.util.ArrayList;

/**
 * Created by cuongdt on 5/10/2021.
 **/
public class KeToan {

    private int sum;
    private int[] A;
    private int[] x;
    private float[] maxA;
    private float[] minA;
    private ArrayList<ArrayList<Integer>> results;
    private int[][] F;
    private int ucln;

    public static void main(String[] args) {
        int M = 76318276;
        int[] A = {14545, 18182, 10909, 16364, 22727, 24545, 21818, 23636};
        float[] max = {1000, 1500, 1200, 665, 622, 200, 250, 300};
        float[] min = {0, 0, 0, 0, 0, 0, 0, 0};


        KeToan keToan = new KeToan(M, A, max, min);
        keToan.run();
    }

    public KeToan(int sum, int[] a, float[] maxA, float[] minA) {
        this.sum = sum;
        A = a;
        this.maxA = maxA;
        this.minA = minA;
        results = new ArrayList<>();
    }

    private void run() {
        int[] AA = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            AA[i] = A[i];
        }
        AA[A.length] = sum;

        ucln = UCLN(AA);
        x = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            x[i] = AA[i];
            maxA[i] = maxA[i] / ucln;
            minA[i] = minA[i] / ucln;
        }
        sum = AA[A.length];

        optimize();
    }

    private void optimize() {
        F = new int[A.length][sum + 1];

        for (int n = 0; n < A.length; n++) {
            if (0 >= minA[n]) {
                F[n][0] = 1;
            } else {
                break;
            }
        }
        for (int m = 1; m <= sum; m++) {
            if (m % x[0] == 0 && m / x[0] >= minA[0] && m / x[0] <= maxA[0]) {
                F[0][m] = 1;
            } else {
                F[0][m] = 0;
            }
        }
        for (int n = 1; n < A.length; n++) {
            for (int m = 1; m <= sum; m++) {
                int s = 0;
                for (int k = 0; m - k * x[n] >= 0; k++) {
                    if (k >= minA[n] && k <= maxA[n]) {
                        s += F[n - 1][m - k * x[n]];
                    }
                }
                F[n][m] = s;
            }
        }
        printResult();
    }

    public void printResult() {
        int[] result = new int[A.length];
        findTrace(A.length - 1, sum, result);
        for (ArrayList<Integer> re : results) {
            String s = "";
            for (int i = 0; i < re.size(); i++) {
                s += re.get(i) * ucln + "*" + x[i] * ucln + " ";
            }
            s += "= " + sum * ucln;

            System.out.println(s);
        }

    }

    private void findTrace(int n, int m, int[] result) {
        if (n == 0 || m == 0) {
            if (n == 0) {
                result[n] = m / x[n];
            }
            ArrayList<Integer> re = new ArrayList<>();
            for (int i = 0; i < A.length; i++) {
                re.add(result[i]);
            }
            results.add(re);
            result[n] = 0;
        } else {
            for (int k = 0; m - k * x[n] >= 0; k++) {
                if (k >= minA[n] && k <= maxA[n] && F[n - 1][m - k * x[n]] > 0) {
                    result[n] = k;
                    findTrace(n - 1, m - k * x[n], result);
                    result[n] = 0;
                }
            }
        }
    }

    private int UCLN(int[] n) {
        int min = 0;
        for (int i = 1; i < n.length; i++) {
            min = n[1] < n[min] ? i : min;
        }
        int ucln = 1;
        int a = 2;
        while (a <= n[min]) {
            boolean uc = true;
            for (int x : n) {
                if (x % a != 0) {
                    uc = false;
                    break;
                }
            }
            if (uc) {
                for (int i = 0; i < n.length; i++) {
                    n[i] /= a;
                }
                ucln *= a;
            } else {
                a++;
            }
        }
        return ucln;
    }
}
