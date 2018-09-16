package liet_ke.bai_tap.trang_11_phuong_phap_sinh;

/**
 * Created by AMBE on 20/04/2018.
 * Nhap vao danh sach n ban nam, n ban nu
 * in ra tat ca cach sap xep 2n ban do vao ban tron sao cho cu 1 nam roi den 1 nu
 * nam = le, nu = so chan ===> bai toán chuyển thành liệt kê tất cả các hoán vị của tập {1,....2n} sao cho chẵn lẻ đứng xen kẽ
 */
public class BaiTap7 {

    // 1234
    // 1243

    // hàm kiểm tra chẵn lẻ

    public boolean check(int[] arr) {
        int n = arr.length;
        int i;
        int dem = 0;
        for (i = 0; i < n - 1; i++) {
            if ((arr[i] % 2 != 0 && arr[i + 1] % 2 == 0) || (arr[i] % 2 == 0 && arr[i + 1] % 2 != 0)) {
                dem++;
            }
        }
        if (dem == n - 1) {
            return true;
        }
        return false;
    }

    public void giaiThuat(int n) {
        int i, k, a, b, temp, t;
        int[] arr = new int[2 * n];
        for (i = 0; i < 2 * n; i++) {
            arr[i] = i + 1;
        }


        do {


            if (check(arr)) {
                for (i = 0; i < 2 * n; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
            }


            i = 2 * n - 2;
            while (i >= 0 && arr[i] > arr[i + 1]) {
                i--;
            }

            if (i >= 0) {
                k = 2 * n - 1;
                while (arr[i] > arr[k]) {
                    k--;
                }

                if (k >= 0) {

                    temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;

                    a = i + 1;
                    b = 2 * n - 1;
                    while (a < b) {
                        temp = arr[a];
                        arr[a] = arr[b];
                        arr[b] = temp;
                        a++;
                        b--;
                    }

                }
            }


        } while (i >= 0);
    }

    public static void main(String[] args) {
        BaiTap7 baiTap7 = new BaiTap7();
        baiTap7.giaiThuat(4);

    }

}
