package liet_ke.bai_tap.trang_11_phuong_phap_sinh;

/**
 * Created by AMBE on 20/04/2018.
 * Liệt kê tất cả các tập con của tập {1,2,3.....,n} .
 * CÓ thể dùng phương pháp liệt kê tập con trên hoặc dùng phương pháp liệt kệ tất cả các dãy nhị phân.
 * Mỗi 1 số trong dãy nhị phân ứng vs 1 phần tử được chọn trong tập.
 * Ví dụ với tập {1,2,3,4} thì dãy nhị phân 1010 tương ứng vs tập con {1,3}
 */
public class BaiTap5 {

    public  void giaiThuat1(int n, int k) {
        // k < n
        int[] arr = new int[n];
        int i;

        do {
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

                // duyet tu cuoi day len , tim x[i] chua dat gioi han tren n-k+i
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
            k++;
        } while (k <= n);


    }

    public  void giaiThuat2(int n) {
        int i;
        int[] arr = new int[n];
        for (i = 0; i < n; i++) {
            arr[i] = 0;
        }

        do {

//            for (i=0;i<n;i++){
//                System.out.print(arr[i]);
//            }
//            System.out.println();

            for (i = 0; i < n; i++) {
                if (arr[i] == 1) {
                    System.out.print(i+1);
                }

            }
            System.out.println();

            i = n - 1;

            while (i >= 0 && arr[i] == 1) {
                i--;
            }
            if (i >= 0) {
                arr[i] = 1;
                for (int j = i + 1; j < n; j++) {
                    arr[j] = 0;

                }
            }

        } while (i >= 0);
    }

    public static void main(String[] args) {
        BaiTap5 baiTap5=new BaiTap5();
        baiTap5.giaiThuat1(3, 1);
     //   baiTap5.giaiThuat2(4);

    }
}
