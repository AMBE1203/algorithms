package cau_truc_du_lieu_va_giai_thuat.demo.trang_87_sap_xep;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by AMBE on 14/05/2018.
 */
public class DemoQickSort {
    private int n;
    private int[] arr;
    private Random random;

    public DemoQickSort(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private void init() {
        Scanner scanner = new Scanner(System.in);
        random = new Random();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();

        }
    }

    private void result() {
        System.out.println("Mảng sau khi sắp xếp là: ");
        for (int i = 0; i < n; i++) {
            System.out.printf(arr[i] + " ");
        }
    }


    private int partitionMid(int L, int R) {
        int i, j, pivot;
        i = L;
        j = R;
        pivot = arr[(L + R) / 2]; // chọn pivot là phần tử đứng giữa

        while (i <= j) {

            while (arr[i] < pivot) i++;
            while (pivot < arr[j]) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }

        return i;

    }

    private void qickSort(int L, int R) {
        int p;
        if (L < R) {
            p = partitionMid(L, R);
            if (L < p - 1) {
                qickSort(L, p - 1);
            }
            if (p < R) {
                qickSort(p , R );
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("n = ");
        int n = scanner.nextInt();
        DemoQickSort demoQickSort = new DemoQickSort(n);
        demoQickSort.init();
        demoQickSort.qickSort(0, n - 1);
        demoQickSort.result();
    }
}
