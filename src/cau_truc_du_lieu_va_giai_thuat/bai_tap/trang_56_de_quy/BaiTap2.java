package cau_truc_du_lieu_va_giai_thuat.bai_tap.trang_56_de_quy;

/**
 * Created by AMBE on 03/05/2018.
 * Tính C(k,n)
 */
public class BaiTap2 {
    private int giaiThuat(int n, int k) {
        if (k == 0 || k == n) return 1;
        else {
            return giaiThuat(n - 1, k - 1) + giaiThuat(n - 1, k);
        }
    }

    public static void main(String[] args) {
        BaiTap2 baiTap2=new BaiTap2();

        System.out.printf("C(3,5) = " + baiTap2.giaiThuat(5, 3));
    }
}
