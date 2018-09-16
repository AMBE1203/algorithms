package cau_truc_du_lieu_va_giai_thuat.demo.trang_87_sap_xep;

/**
 * Created by AMBE on 15/05/2018.
 * Sắp xếp theo cơ số.
 * Tính ổn định của thuật toán sắp xếp.
 * 1 thuật toán được gọi là ổn định nếu nó bảo toàn thứ tự ban đầu của các bản ghi mang khóa bằng nhau.
 * Ví dụ như ban đầu danh sách sinh viên được xếp theo thứ tự tến alphabet, thi khi sắp xếp theo thứ tự giảm dần
 * của điểm thì những sinh viên bằng điểm vẫn đc xếp theo thứ tự alphabet
 */
public class DemoRadixSort {

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return Integer.toBinaryString(max).length();

    }

    private String[] convertToBinary(int[] arr) {

        String[] arrBinay = new String[arr.length];


        int z = getMax(arr);

        String sb;

        for (int i = 0; i < arr.length; i++) {
            sb = Integer.toBinaryString(arr[i]);
            if (sb.length() < z) {

                do {

                    sb = "0" + sb;

                } while (sb.length() < z);

            }

            arrBinay[i] = sb;


        }


        return arrBinay;
    }

    private void radixSort(int L, int R, int bitIndex, String[] arr, int[] a) {
        int z = getMax(a);
        if (L > R) {
            return;
        } else {
            int i = L;
            int j = R;
            do {
                while (i < j && arr[i].charAt(bitIndex) == '0') {
                    i++;
                }
                while (i < j && arr[j].charAt(bitIndex) == '1') {
                    j--;
                }
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            } while (i < j);
            System.out.println("bitIndex " + bitIndex);

            if (arr[j].charAt(bitIndex) == '0') {
                j++;
            }
            System.out.println("j = " + j);

            if (bitIndex < z) {
                System.out.println("z " + z);


                radixSort(L, j-1 , bitIndex + 1, arr, a);
                //               radixSort(j, R, bitIndex + 1, arr, a);


            }


        }

    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 6, 5, 2, 3, 4, 4, 5, 6, 7};

        DemoRadixSort demoRadixSort = new DemoRadixSort();
        String[] arrBinary = demoRadixSort.convertToBinary(arr);
        System.out.print(" Dãy trước khi xếp là: ");
        for (int i = 0; i < arrBinary.length; i++) {
            System.out.printf(arrBinary[i] + " ");
        }
        System.out.println();
            demoRadixSort.radixSort(0, arr.length - 1, 0, arrBinary, arr);


        System.out.printf("Dãy sau khi xếp là: ");


        for (int i = 0; i < arrBinary.length; i++) {
            System.out.printf(arrBinary[i] + " ");
        }

    }
}
