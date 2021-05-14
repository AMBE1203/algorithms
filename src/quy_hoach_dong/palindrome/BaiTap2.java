package quy_hoach_dong.palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * Cho một xâu S, độ dài không quá 1000 kí tự.
 * Tìm palindrome dài nhất là xâu con của S (Xâu con là một dãy các kí tự liên tiếp).
 * F[i, j] = true/false nếu các đoạn ký tư từ i->j là/không là các palindrome.
 * Ta có:
 * F[i, i] = true (độ dài 1)
 * F[i, j] = F[i+1, j-1] nếu Si = Sj
 * F[i, j] = false nếu Si != Sj
 */

public class BaiTap2 {

    String s;

    public BaiTap2(String s) {
        this.s = s;
    }

    private void optimize() {
        int n = s.length();
        boolean[][] F = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            F[i][i] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            F[i + 1][i] = true;
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < (n - k); i++) {
                int j = i + k;
                F[i][j] = F[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));

            }
        }

        // bang phuong an

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(F[i][j] + "\t");
            }
            System.out.println();
        }
        trace(F, n);
    }

    private void trace(boolean[][] F, int n) {
        Map<Map<Integer, Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && (j - i + 1 != 0) && F[i][j]) {
                    Map<Integer, Integer> x = new HashMap<>();
                    x.put(i, j);
                    map.put(x, j - i + 1);
                }
            }
        }

        Map.Entry<Map<Integer, Integer>, Integer> maxEntry = null;
        for (Map.Entry<Map<Integer, Integer>, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        if (maxEntry != null) {

            Map<Integer, Integer> maxKey = maxEntry.getKey();
            System.out.println("i = " + maxKey.keySet().toArray()[0]);
            System.out.println("j = " + maxKey.values().toArray()[0]);
            System.out.println("max palindrome length: " + maxEntry.getValue());
            System.out.println("palindrome: " + s.substring((int) maxKey.keySet().toArray()[0], (int) maxKey.values().toArray()[0]+1))
            ;
        } else {
            System.out.println("max palindrome length: 1");

        }

    }

    public static void main(String[] args) {
        BaiTap2 baiTap2 = new BaiTap2("jhdjs");
        baiTap2.optimize();
    }
}