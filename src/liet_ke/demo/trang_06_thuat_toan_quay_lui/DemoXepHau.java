package liet_ke.demo.trang_06_thuat_toan_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 23/04/2018.
 * Có bàn cờ nxn ô. Xếp n quân hậu vào các hàng, các cột sao cho không có quân hậu nào ăn nhau
 */
public class DemoXepHau {

    private  int n;
    private  int[] arr;
    private  int[] checkCot;
    private  int[] checkDbTn;
    private  int[] checkDnTb;
    private  int dem = 0;
    private  int[][] arrBanCo;

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = scanner.nextInt();
        arr = new int[n];
        checkCot = new int[n];
        checkDbTn = new int[2 * n + 1];
        checkDnTb = new int[2 * n + 1];


        // kiểm tra xem quân hậu có thuộc cột k ( 0 là không , 1 là có )

        for (int i = 0; i < checkCot.length; i++) {

            checkCot[i] = 0;
        }
// kiểm tra quân hậu có ăn đc hàng chéo xuôi k
        for (int i = 0; i < checkDbTn.length; i++) {
            checkDbTn[i] = 0;
        }
// kiểm tra quân hậu có ăn đc hàng chéo ngược k
        for (int i = 0; i < checkDnTb.length; i++) {
            checkDnTb[i] = 0;
        }

    }

    public  void result() {
        dem++;
        System.out.println("\t" + dem);

        arrBanCo = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.out.print("( " + (i + 1) + "," + (arr[i] + 1) + " )");
            arrBanCo[i][arr[i]] = 1;
            for (int j=0;j<n;j++){
                System.out.print(arrBanCo[i][j]);

            }
            System.out.println();
        }


        System.out.println();

    }

    public  void giaiThuat(int i) {
        for (int j = 0; j < n; j++) {
            if (checkCot[j] == 0 && checkDbTn[i + j] == 0 && checkDnTb[i - j + n] == 0) {
                arr[i] = j;


                if (i == n - 1) {

                    result();
                } else {
                    checkCot[j] = 1;
                    checkDbTn[i + j] = 1;
                    checkDnTb[i - j + n] = 1;
                    giaiThuat(i + 1);
                    checkCot[j] = 0;
                    checkDbTn[i + j] = 0;
                    checkDnTb[i - j + n] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {

        DemoXepHau demoXepHau=new DemoXepHau();

        demoXepHau.init();
        demoXepHau.giaiThuat(0);
    }


}
