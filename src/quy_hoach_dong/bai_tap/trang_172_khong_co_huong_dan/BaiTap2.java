package quy_hoach_dong.bai_tap.trang_172_khong_co_huong_dan;

import java.util.ArrayList;

/**
 * Created by AMBE on 9/21/2018 at 9:50 AM.
 * Tìm xâu con dài nhất của 2 xâu ký tự X,Y.
 * Gọi F[i,j]= độ dài xâu con dài nhất với i ký tự đầu của X và j ký tự đầu của Y.
 * TH1: X[i] = Y[j] --> F[i,j] = F[i-1,j-1] + 1
 * TH2: X[i] != Y[j] --> F[i,j] = max( F[i-1,j], F[i,j-1])
 */
public class BaiTap2 {
    private int max(int x, int y) {
        return (x > y) ? x : y;
    }

    private void optimize(int[][] F, String X, String Y) {
        F[0][0] = 0;
        for (int i = 1; i <= X.length(); i++) {
            for (int j = 1; j <= Y.length(); j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    F[i][j] = F[i - 1][j - 1] + 1;
                } else {
                    F[i][j] = max(F[i - 1][j], F[i][j - 1]);
                }
            }
        }
    }

    private void trade(int[][] F, String X, String Y) {
        int i = X.length();
        int j = Y.length();
        ArrayList<String> arrayList = new ArrayList<>();
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                arrayList.add(X.charAt(i - 1) + "");
                i--;
                j--;
            } else {
                if (F[i][j] == F[i - 1][j]) {
                    i--;
                } else if (F[i][j] == F[i][j - 1]) {
                    j--;
                }
            }
        }
        System.out.print("Z = ");
        for (int t = arrayList.size() - 1; t >= 0; t--) {
            System.out.printf(arrayList.get(t));
        }

    }


    public static void main(String[] args) {
        BaiTap2 baiTap2 = new BaiTap2();
        String x = "ab1cdefghi12";
        String y = "abc1def2ghi3";

        int[][] F = new int[x.length() + 1][y.length() + 1];
        baiTap2.optimize(F, x, y);

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                System.out.printf(F[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Z.length() = " + F[x.length()][y.length()]);
        baiTap2.trade(F, x, y);
    }
}
