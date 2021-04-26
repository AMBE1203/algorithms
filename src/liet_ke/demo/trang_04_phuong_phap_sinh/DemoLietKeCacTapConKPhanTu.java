package liet_ke.demo.trang_04_phuong_phap_sinh;

/**
 * Created by AMBE on 18/04/2018.
 */
public class DemoLietKeCacTapConKPhanTu {


    public void giaiThuat(int n, int k) {

        // k < n
        int[] arr = new int[n];
        int i;

        // khoi tao cau hinh ban dau
        for (i = 0; i < k; i++) {
            arr[i] = i;
        }
        do {
// in ra cau hinh hien tai
            for (i = 0; i < k; i++) {
                System.out.print(arr[i] + 1);
            }
            System.out.println();

            // duyet tu cuoi day len , tum x[i] chua dat gioi han tren n-k+i
            i = k - 1;
            while (i >= 0 && arr[i] == n - k + i) {
                i--;
            }
            // chua lui den 0 thi chua phai cau hinh cuoi cung
            if (i >= 0) {
                // tang arr[i] len 1 don vi va dat cac phan tu dung sau i bang gioi han duoi cua no
                arr[i]++;
                for (int j = i + 1; j < k; j++) {
                    arr[j] = arr[j - 1] + 1;

                }
            }

        } while (i >= 0);


    }

    public static void main(String[] args) {
        DemoLietKeCacTapConKPhanTu demoLietKeCacTapConKPhanTu = new DemoLietKeCacTapConKPhanTu();

        demoLietKeCacTapConKPhanTu.giaiThuat(5, 3);

    }
}
