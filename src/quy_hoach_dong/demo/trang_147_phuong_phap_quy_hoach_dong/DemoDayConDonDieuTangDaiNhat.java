package quy_hoach_dong.demo.trang_147_phuong_phap_quy_hoach_dong;

/**
 * Created by AMBE on 08/06/2018 at 17:40.
 * Bổ sung vào A 2 phần tử a[0] = - âm vô cùng và a[n+1] = + vô cùng. Khi đó dãy con
 * đơn điệu tăng dài nhất sẽ bắt đầu ở a[0] và kết thúc ở a[n+1]
 * Với mọi 0<=i<=n+1. Ta sẽ tính L[i] là độ dài dãy con đơn điệu tăng dài nhất bắt đầu
 * ở a[i] với L[n+1] = 1.
 * Với i chạy từ n về 0. Ta cần tìm L[i] với điều kiện L[i+1...n+1] đã biết
 * Khi đó với mọi i+1 <= j <= n+1  mà a[j] > a[i]. chọn ra jmax có L[jmax] lớn nhất.
 * đặt L[i] = L[jmax] + 1.
 * Truy vết. mỗi khi đặt L[i] = L[jmax] + 1. ta đặt T[i] = jmax để lưu lại rằng dãy con dài
 * nhất bắt đầu tại a[i] sẽ có phần từ kế tiếp là a[jmax]
 */
public class DemoDayConDonDieuTangDaiNhat {

    private void optimize(int[] arr, int n) {
        int[] a = new int[100];
        int[] L = new int[100];
        int[] T = new int[100];

        int jmax;
        L[n + 1] = 1;
        a[0] = -32768;
        a[n + 1] = 32768;
        for (int i = 1; i <= n; i++) {
            a[i] = arr[i - 1];
        }


        for (int i = n; i >= 0; i--) {
            jmax = n + 1;
            for (int j = i + 1; j <= n + 1; j++) {
                if (a[j] > a[i] && L[j] > L[jmax]) {
                    jmax = j;
                }

                L[i] = L[jmax] + 1;
                T[i] = jmax;


            }

        }
// chiều dài dãy con tăng dài nhất
        System.out.println("L = " + (L[0] - 2));
// bắt đầu truy vết tìm nghiệm
        int x = T[0];
        while (x != n + 1) {
            System.out.println("a[" + x + "] = " + a[x]);
            x = T[x];
        }
    }

    public static void main(String[] args) {
        int[] arrr = {5, 2, 3, 4, 9, 10, 5, 6, 7, 8};
        int n = arrr.length;
        int[] L = new int[n];


        DemoDayConDonDieuTangDaiNhat demoDayConDonDieuTangDaiNhat = new DemoDayConDonDieuTangDaiNhat();
        demoDayConDonDieuTangDaiNhat.optimize(arrr, n);
    }
}
