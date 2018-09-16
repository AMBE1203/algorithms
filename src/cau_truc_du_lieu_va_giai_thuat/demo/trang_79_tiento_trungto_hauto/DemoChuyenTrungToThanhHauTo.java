package cau_truc_du_lieu_va_giai_thuat.demo.trang_79_tiento_trungto_hauto;


import java.util.Stack;

/**
 * Created by AMBE on 03/05/2018.
 */
public class DemoChuyenTrungToThanhHauTo {

    private int checkDoUuTien(String str) {
        if (str.equals("*") || str.equals("/")) return 2;
        if (str.equals("+") || str.equals("-")) return 1;
        return 0;

    }

//    private static void giaiThuat(String[] str) {
//        Stack<String> stack = new Stack<>();
//        String result = "";
//        for (int i = 0; i < str.length; i++) {
//            String c = str[i];
//            if (!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/") && !c.equals("(") && !c.equals(")")) {
//                result = result + " " + c;
//            } else {
//                if (c.equals("(")) {
//                    stack.push(c);
//
//                } else if (c.equals(")")) {
//                    String c1 = "";
//
//                    do {
//
//                        c1 += stack.peek();
//                        if (!c1.equals("(")) {
//                            result = result + " " + stack.peek();
//
//                        }
//                        stack.pop();
//
//
//                    } while (c.equals("("));
//                    stack.pop();
//                } else {
//                    while (!stack.isEmpty() && checkDoUuTien(stack.peek()) >= checkDoUuTien(c)) {
//                        result = result + " " + stack.peek();
//                        stack.pop();
//                    }
//                    stack.push(c);
//                }
//
//
//            }
//        }
//        while (!stack.isEmpty()) {
//            result = result + " " + stack.peek();
//            stack.pop();
//        }
//
//        System.out.printf(result);
//    }

    public void giaiThuat(String[] str) {
        Stack<String> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < str.length; i++) {
            String c = str[i];
            if (!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")
                    && !c.equals("(") && !c.equals(")")) {
                result = result + " " + c;
            } else {
                if (c.equals("(")) {
                    stack.push(c);
                } else {
                    if (c.equals(")")) {
                        String c1;
                        do {
                            c1 = stack.peek();
                            if (!c1.equals("(")) {
                                result = result + " " + stack.peek();
                            }
                            stack.pop();

                        } while (!c1.equals("("));
                    } else {

                        while (!stack.isEmpty() && checkDoUuTien(c) <= checkDoUuTien(stack.peek())) {
                            result = result + " " + stack.peek();
                            stack.pop();
                        }
                        stack.push(c);

                    }

                }

            }


        }
        while (!stack.isEmpty()) {
            result = result + " " + stack.peek();
            stack.pop();
        }


        System.out.printf(result);
    }

    public static void main(String[] args) {
        String[] str = {"(", "10", "*", "3", "+", "7", "/", "8", ")", "*", "(", "5", "-", "1", ")"};
        DemoChuyenTrungToThanhHauTo demoChuyenTrungToThanhHauTo = new DemoChuyenTrungToThanhHauTo();
        demoChuyenTrungToThanhHauTo.giaiThuat(str);
    }
}
