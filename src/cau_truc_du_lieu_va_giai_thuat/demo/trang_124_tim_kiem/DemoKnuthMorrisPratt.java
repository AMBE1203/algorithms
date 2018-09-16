package cau_truc_du_lieu_va_giai_thuat.demo.trang_124_tim_kiem;

/**
 * Created by AMBE on 07/13/2018 at 20:11.
 * == 0 là không tìm thấy
 */

public class DemoKnuthMorrisPratt {

    private void initNext(String p, int[] NEXT) {

        int i, j;
        int m = p.length();
        i = 0;
        j = NEXT[0] = -1;
        while (i < m - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (p.charAt(i) != p.charAt(j)) {
                    NEXT[i] = j;
                } else {
                    NEXT[i] = NEXT[j];
                }
            } else {
                j = NEXT[j];
            }

        }
    }

    private int stringSearchKMP(String p, String t) {
        int m = p.length();
        int n = t.length();
        int[] NEXT = new int[m];
        initNext(p, NEXT);
        int j = 0;
        for (int i = 0; i < n; i++) {

            while (j >= 0 && p.charAt(j) != t.charAt(i)) {
                j = NEXT[j];
            }

            j++;
            System.out.println("i = " + i +" j = "+ j + " m = " +m);

            if (j >= m) {

                return (i-m);
            }


        }
        return 0;
    }

    public static void main(String[] args) {
        DemoKnuthMorrisPratt demoKnuthMorrisPratt = new DemoKnuthMorrisPratt();
        String p = "IN";
        String t = "FINDIFAHAYXEACKNEXDLE";

        int result = demoKnuthMorrisPratt.stringSearchKMP(p, t);
        System.out.println(result + " ");

    }
}
