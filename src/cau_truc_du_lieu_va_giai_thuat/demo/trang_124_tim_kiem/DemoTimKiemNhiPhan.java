package cau_truc_du_lieu_va_giai_thuat.demo.trang_124_tim_kiem;

/**
 * Created by AMBE on 10/07/2018.
 */

public class DemoTimKiemNhiPhan {

    private int binarySearch(int x, int[] arr) {
        int binarySearch =0;
        int inf = 0;
        int sup = arr.length;
        int median;

        while (inf < sup) {
            median = (inf + sup) / 2;

            if (arr[median] == x) {
                binarySearch = median;
                break;
            }
            if (arr[median] < x) {
                inf = median + 1;
            } else {
                sup = median ;
            }

        }

        return binarySearch;


    }

    public static void main(String[] args) {
        DemoTimKiemNhiPhan demoTimKiemNhiPhan=new DemoTimKiemNhiPhan();
        int[] arr= {1,3,4,6,8,9};
        System.out.printf(demoTimKiemNhiPhan.binarySearch(7,arr) +" ");
    }

}
