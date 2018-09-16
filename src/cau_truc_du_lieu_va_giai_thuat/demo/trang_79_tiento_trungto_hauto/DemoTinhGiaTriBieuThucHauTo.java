package cau_truc_du_lieu_va_giai_thuat.demo.trang_79_tiento_trungto_hauto;

import java.util.Stack;

/**
 * Created by AMBE on 03/05/2018.
 */
public class DemoTinhGiaTriBieuThucHauTo {
    public  String RPN(String[] str) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String c = str[i];
            if (!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")) {
                stack.push(c);
            } else {
                int y = Integer.parseInt(stack.pop());
                int x = Integer.parseInt(stack.pop());
                int s = 0;
                switch (c) {
                    case "+":
                        s = x + y;
                        break;
                    case "-":
                        s = x - y;
                        break;
                    case "*":
                        s = x * y;
                        break;
                    case "/":
                        s = x / y;
                        break;
                }
                stack.push(String.valueOf(s));
            }
        }

        return stack.pop();
    }


    public static void main(String[] args) {
        String[] bieuThuc = {"10", "2", "/", "3", "+", "7", "4", "-", "*"};
        DemoTinhGiaTriBieuThucHauTo demoTinhGiaTriBieuThucHauTo=new DemoTinhGiaTriBieuThucHauTo();

        System.out.printf("gia tri = " +demoTinhGiaTriBieuThucHauTo.RPN(bieuThuc));
    }

}
