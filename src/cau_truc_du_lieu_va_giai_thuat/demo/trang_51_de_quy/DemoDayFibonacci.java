package cau_truc_du_lieu_va_giai_thuat.demo.trang_51_de_quy;

/**
 * Created by AMBE on 03/05/2018.
 * in ra so fibonacci thu n
 */
public class DemoDayFibonacci {

    private  int giaiThuat(int x) {
        if (x <= 2) return 1;
        else return giaiThuat(x - 2) + giaiThuat(x - 1);
    }

    public static void main(String[] args) {
        DemoDayFibonacci demoDayFibonacci=new DemoDayFibonacci();

        System.out.printf("n = 10 ==> "+demoDayFibonacci.giaiThuat(10));

    }
}
