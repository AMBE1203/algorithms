package quy_hoach_dong.demo.trang_147_phuong_phap_quy_hoach_dong;

/**
 * Created by AMBE on 08/26/2018 at 22:36.
 */
public class DemoPhepNhanToHopCacMaTran {
    private int[] a;
    private int[][] f;
    private int[][] t;
    private int n;

    public DemoPhepNhanToHopCacMaTran(int[] a, int[][] f, int[][] t, int n) {
        this.a = a;
        this.f = f;
        this.t = t;
        this.n = n;
    }

    private void optimize() {
        int i, j, k, len;
        long x, p, q, r;
        // dien co so quy hoach dong f[i][i]=0
        for (i = 1; i <= n; i++) {
            for (j = i; j <= n; j++) {
                if (i == j) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = 1000000;
                }
            }
        }

        // giai cong thuc truy hoi
        for (len = 2; len <= n; len++) { // thu boi cac do dai doan tu 1-->n
            for (i = 1; i <= n - len + 1; i++) { // tinh cac f[i][i+len-1]
                j = i + len - 1;
                for (k = i; k <= j - 1; k++) { // thu cac vi tri k
                    p = a[i];
                    q = a[k + 1];
                    r = a[j + 1];
                    x = f[i][k] + f[k + 1][j] + p * q * r;
                    if (x < f[i][j]) {
                        f[i][j] = (int) x;
                        t[i][j] = k;
                    }

                }

            }
        }
    }

    // truy vet bang de quy, in ra cac cach ket hop
    private void trace(int i, int j) {
        int k;
        if (i == j) {
            System.out.print("m[" + i + "]");
        } else {
            System.out.print("(");
            k = t[i][j];
            trace(i, k);
            System.out.print(".");
            trace(k + 1, j);
            System.out.print(")");

        }

    }

    public static void main(String[] args) {
        int n = 6;
        int[] a = {0,3, 2, 3, 1, 2, 2, 3};
        int[][] f = new int[100][100];
        int[][] t = new int[100][100];
        DemoPhepNhanToHopCacMaTran demoPhepNhanToHopCacMaTran = new DemoPhepNhanToHopCacMaTran(a, f, t, n);
        demoPhepNhanToHopCacMaTran.optimize();
        System.out.println("So phep nhan la: " + f[1][n]);
        demoPhepNhanToHopCacMaTran.trace(1, n);

    }
}
