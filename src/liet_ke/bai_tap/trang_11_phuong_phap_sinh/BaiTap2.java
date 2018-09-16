package liet_ke.bai_tap.trang_11_phuong_phap_sinh;

/**
 * Created by AMBE on 19/04/2018.
 * Nhap vao 2 so k va n, liet ke cac chinh hop lap chap k cua {0,1,2.....,n-1}
 */
public class BaiTap2 {
    public void giaiThuat(int n, int k) {
        int[] arr = new int[n];
        int i;
        int dem = 1;

        // khoi tao cau hinh ban dau
        for (i = 0; i < k; i++) {
            arr[i] = 0;
        }
        do {
// in ra cau hinh hien tai
            for (i = 0; i < k; i++) {
                System.out.print(arr[i]);
            }
            System.out.print("\t" + dem);
            System.out.println();
            // duyet tu cuoi mang
            i = k - 1;
            // neu arr[i] == n-1 thi lui i lai
            while (i >= 0 && arr[i] == n - 1) {
                i--;
            }
            // chua den cau hinh cuoi cung { n-1,n-1,n-1,....n-1 } k phan tu
            if (i >= 0) {
                // tang arr[i] len 1 don vi, tat ca cac phan tu sau a[i] gan = 0
                arr[i]++;
                for (int j = i + 1; j < k; j++) {
                    arr[j] = 0;
                }
            }

            dem++;


        } while (i >= 0);

    }

    public static void main(String[] args) {
        BaiTap2 baiTap2 = new BaiTap2();
        baiTap2.giaiThuat(5, 3);

    }
}
