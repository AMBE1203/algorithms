package cau_truc_du_lieu_va_giai_thuat.demo.trang_87_sap_xep;

/**
 * Created by AMBE on 15/05/2018.
 * Tạo đống max heap từ đống ban đầu
 * Đổi chỗ phần tử đầu tiên vs phần tử cuối cùng trong mảng
 * Loại bỏ phần tử cuối cùng bằng cách giảm kích thước của đống đi 1
 * Thực hiện max heapify đối vs gốc mới
 * Lặp lại cho đến khi đống chỉ còn 1 nút
 */
public class DemoHeapSort {

    private void heapify(int[] arr, int n, int i) {
        int largset = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // nếu nút con trái lớn hơn gốc
        if (l < n && arr[l] > arr[largset]) {
            largset = l;
        }
        if (r < n && arr[r] > arr[largset]) {
            largset = r;
        }
// Nếu k phải là gốc --> đổi chỗ
        if (largset != i) {
            int temp = arr[i];
            arr[i] = arr[largset];
            arr[largset] = temp;

            heapify(arr, n, largset);
        }

    }

    private void heapSort(int[] arr) {
        int n = arr.length;

        // khôi phục tính chất đống
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
// sắp xếp
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void result(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 9, 10,10, 5, 3, 0,15};

        DemoHeapSort demoHeapSort = new DemoHeapSort();
        demoHeapSort.heapSort(arr);
        System.out.println("Mảng sau khi sắp xếp là: ");
        demoHeapSort.result(arr);

    }
}
