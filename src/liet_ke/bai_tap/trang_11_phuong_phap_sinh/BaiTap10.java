package liet_ke.bai_tap.trang_11_phuong_phap_sinh;

/**
 * Created by AMBE on 21/04/2018.
 * Liệt kê các cách phân tích số nguyên dương n thành tổng các số nguyên dương, 2 cách là hoán vị của nhau thì không tính
 * Ý tưởng: liệt kê các tập con chạy từ 1,2,...n ( có tính lặp ) rồi loại trừ các số lặp
 *  Dùng phương pháp sinh;
 *   ví dụ n=5
 *   4 1
 *   3 2
 *   3 1 1
 *   2 2 1
 *   2 1 1 1
 *   1 1 1 1 1
 *
 *  Tìm số đầu tiên tính từ phải sang trái Xi ≠ 1
 *  Xi = Xi -1
 *  Phân tích tổng k – i +1  thành tổng các số ≤ Xi (k-i số 1 và giá trị 1 được bỏ ra từ Xi)
 *  Việc phân tích k -i + 1 thành tổng các số ≤ Xi được thực hiện theo nguyên tắc sau:
 *  Sẽ phân tích k-i+1 thành (k-i+1) DIV Xi số bằng Xi (các số liền sau i bằng Xi)
 *  và cộng thêm số (k-i+1) MOD Xi nếu (k-i+1) MOD Xi ≠ 0
 */
public class BaiTap10 {


    public  boolean checkSum(int n, int[] arr) {
        int sum = 0;
        int i;
        for (i = 0; i < n; i++) {
            sum += arr[i];

        }
        if (sum == n) {

            return true;
        }
        return false;

    }

    public  void giaiThuatLietKe(int n) {
        int[] arr = new int[n];
        int i;
        for (i = 0; i < n; i++) {
            arr[i] = 1;
        }

        do {

            if (checkSum(n, arr)) {

                for (i = 0; i < n; i++) {
                    if (arr[i] != 0) {
                        System.out.print(arr[i]);
                    }
                }
                System.out.println();
            }

            i = n - 1;

            while (i >= 0 && arr[i] == n) {
                i--;
            }
            if (i >= 0) {
                arr[i]++;
                for (int j = i + 1; j < n; j++) {
                    arr[j] = 0;
                }
            }

        } while (i >= 0);
    }

    // giai thuật sử dụng phương pháp sinh


    public  void giaiThuat(int n) {

        int[] arr = new int[n+1];
        int i, div, mod, sum;
        int k = 2;
        arr[0] = 0;
        arr[1] = n - 1;
        arr[2] = 1;

        do {
            for (i = 1; i <= k; i++) {
                System.out.print(arr[i]);
            }

            System.out.println();

            i = k;

            while (i >= 0 && arr[i] == 1) {
                i--;
            }
            if (i >= 0) {
                arr[i] = arr[i] - 1;
                sum = (k - i) + 1;
                div = sum / arr[i];
                mod = sum % arr[i];

                for (int j = i + 1; j <= i + div; j++) {
                    arr[j] = arr[i];
                }

                k = i + div;
                if (mod > 0) {
                    k++;
                    arr[k] = mod;
                }

            }

        } while (i >= 0);


    }


    public static void main(String[] args) {
        BaiTap10 baiTap10=new BaiTap10();

        baiTap10.giaiThuat(3);

    }
}
