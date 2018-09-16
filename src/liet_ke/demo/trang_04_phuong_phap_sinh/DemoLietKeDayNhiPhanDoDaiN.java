package liet_ke.demo.trang_04_phuong_phap_sinh;

/**
 * Created by AMBE on 18/04/2018.
 */
public class DemoLietKeDayNhiPhanDoDaiN {


    public void giaiThuat(int n) {
        int[] arr = new int[n];
        int k;
        int dem = 1;
        // khoi tao cau hinh ban dau
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        do {

            // in ra cau hinh hien tai
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.print("\t" + dem);


            System.out.println();
// x[k] la phan tu cuoi day, lui dan k cho den khi x[k]==0 hoac k=1 thi dung
            k = n - 1;
            while (k >= 0 && arr[k] == 1) {
                k--;
            }

            // chua gap phai cau hinh 1 1 1 1....1
            if (k >= 0) {
                // gan arr[k]=1; dat tat ca cac phan tu sau k = 0
                arr[k] = 1;
                for (int i = k + 1; i < n; i++) {
                    arr[i] = 0;

                }
            }
            dem++;

        } while (k >= 0);


    }

    public static void main(String[] args) {
        DemoLietKeDayNhiPhanDoDaiN demoLietKeDayNhiPhanDoDaiN = new DemoLietKeDayNhiPhanDoDaiN();
        demoLietKeDayNhiPhanDoDaiN.giaiThuat(5);
    }


}
