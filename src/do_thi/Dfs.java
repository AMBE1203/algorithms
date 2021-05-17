package do_thi;

/**
 * Created by cuongdt on 5/17/2021.
 * Thuật toán tìm kiếm theo chiều sâu.
 **/
public class Dfs {
    private int n, m, s, f;
    private boolean[][] a;
    private int[] trace;
    private int max = 100;


    private void dfs(int u) {
        for (int v = 0; v < n; v++) {
            if (a[u][v] && trace[v] == 0) {
                trace[v] = u;
                dfs(v);
            }
        }
    }

    private void trace() {

        System.out.println("From " + s + "you can visit:");
        for (int i = 0; i < n; i++) {
            if (trace[i] != 0) {
                System.out.printf(i + "\t");
            }
        }
        System.out.println();

        System.out.println("The path " + s + " to " + f + " :");
        if (trace[f] == 0) {
            System.out.printf("Not found");
        } else {
            while (f != s) {
                System.out.printf(f + "<-");
                f = trace[f];
            }
        }

    }

    private void run() {
        trace = new int[max];
        a = new boolean[max][max];
        n = 8;
        m = 7;
        s = 1;
        f = 5;

        a[1][2] = true;
        a[2][1] = true;
        a[1][3] = true;
        a[3][1] = true;
        a[2][3] = true;
        a[3][2] = true;
        a[2][4] = true;
        a[4][2] = true;
        a[3][5] = true;
        a[5][3] = true;
        a[4][6] = true;
        a[6][4] = true;
        a[7][8] = true;
        a[8][7] = true;


        trace[s] = -1;
        dfs(s);
        trace();

    }

    public static void main(String[] args) {
        Dfs dfs = new Dfs();
        dfs.run();

    }
}
