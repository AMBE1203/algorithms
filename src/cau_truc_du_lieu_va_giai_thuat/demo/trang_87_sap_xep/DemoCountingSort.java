package cau_truc_du_lieu_va_giai_thuat.demo.trang_87_sap_xep;

/**
 * Created by AMBE on 15/05/2018.
 * Sắp xếp đếm.
 * Ý tưởng: Với mỗi phần tử x của dãy đầu vào ta xác định rank của nó như là số lượng các phần tử nhỏ hơn x. ví dụ rank(x)= r
 * Một khi đã biết rank của x, ta có thể xếp nó vào vị trí r+1
 * Ví dụ có 6 số nhỏ hơn 12, ta có thể xếp 12 vào vị trí thứ 6+1=7
 */
public class DemoCountingSort {

    private void countingSort(int[] arr, int[] checkRank, int[] result, int n, int max) {
        for (int i = 0; i <= max; i++) {
            checkRank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            checkRank[arr[i]]++;
        }

        //tính hạng checkRanh[i] là hạng của phần tử thứ i

        for (int i = 1; i <= max; i++) {
            checkRank[i] += checkRank[i - 1]; //==> checkRank[i] chính là vị trí cuối của giá trị i trong dãy đã sắp xếp

        }

        // muốn sắp xếp thì ta duyệt lại dãy arr mỗi khi gặp giá trị = arr[i]=V thì ta đưa giá trị đó vào result[checkRank{V]-1] và giảm checkRank[V] đi 1

        for (int i = n - 1; i >= 0; i--) {
            result[checkRank[arr[i]] - 1] = arr[i];
            checkRank[arr[i]] = checkRank[arr[i]] - 1;
        }
    }


    public static void main(String[] args) {
        int max = 10;
        int n = 9;
        int[] arr = {1, 10,3, 9, 10, 5, 3,5,3};
        int[] checkRank = new int[max+1];
        int[] result = new int[n];
        DemoCountingSort demoCountingSort = new DemoCountingSort();
        demoCountingSort.countingSort(arr, checkRank, result, n, max);
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();

        int[] x={0,1,0,2,0,1,0,0,0,1,2};
        for (int i=1;i<=10;i++){
            x[i]+= x[i-1];

        }

        for (int i=0;i<x.length;i++){
            System.out.print(x[i]+" ");
        }

    }

}
