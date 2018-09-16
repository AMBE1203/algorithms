package cau_truc_du_lieu_va_giai_thuat.bai_tap.trang_86_tiento_trungto_hauto;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by AMBE on 09/05/2018.
 * Viết chương trình hoàn chỉnh để tính biểu thức trung tố
 */
public class BaiTap5 {
    private int checkDoUuTien(char c) {
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return 0;
    }

    private boolean laToanTu(char c) {
        char[] toanTu = {'+', '-', '*', '/', '(', ')'};
        Arrays.sort(toanTu);
        if (Arrays.binarySearch(toanTu, c) > -1) {
            return true;
        }

        return false;
    }


    private String[] chuanHoaXau(String str) {
        String s1 = "";
        String[] result;
        BaiTap5 baiTap5 = new BaiTap5();
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!baiTap5.laToanTu(c)) {
                s1 = s1 + c;
            } else {
                s1 = s1 + " " + c + " ";
            }
        }

        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+", " ");
        result = s1.split(" ");
        return result;
    }


    private String[] chuyenTrungToSangHauTo(String[] str) {
        BaiTap5 baiTap5 = new BaiTap5();
        Stack<String> stack = new Stack<>();
        String[] result;
        String s1 = "";
        for (int i = 0; i < str.length; i++) {
            char c = str[i].charAt(0);
            if (!baiTap5.laToanTu(c)) {
                s1 = s1 + " " + str[i];
            } else {
                if (c == '(') {
                    stack.push(str[i]);
                } else {
                    if (c == ')') {
                        char c1;
                        do {
                            c1 = stack.peek().charAt(0);
                            if (c1 != '(') {
                                s1 = s1 + " " + stack.peek();

                            }
                            stack.pop();

                        } while (c1 != '(');
                    } else {
                        while (!stack.isEmpty() && baiTap5.checkDoUuTien(stack.peek().charAt(0)) > baiTap5.checkDoUuTien(c)) {
                            s1 = s1 + " " + stack.peek();
                            stack.pop();

                        }
                        stack.push(str[i]);
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            s1 = s1 + " " + stack.peek();
            stack.pop();
        }
        s1 = s1.trim();

        result = s1.split(" ");

        return result;


    }

    private double tinhGiaTri(String[] str) {
        double dapAn;
        BaiTap5 baiTap5 = new BaiTap5();

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            char c = str[i].charAt(0);
            if (!baiTap5.laToanTu(c)) {
                stack.push(str[i]);
            } else {
                double y = Double.parseDouble(stack.pop());
                double x = Double.parseDouble(stack.pop());

                double s = 0.0;
                switch (c) {
                    case '+':
                        s = x + y;
                        break;
                    case '-':
                        s = x - y;
                        break;
                    case '*':
                        s = x * y;
                        break;
                    case '/':
                        s = x / y;
                        break;

                }

                stack.push(String.valueOf(s));
            }
        }

        dapAn = Double.parseDouble(stack.pop());


        return dapAn;

    }

    public static void main(String[] args) {
        BaiTap5 baiTap5 = new BaiTap5();
        String[] result;
        double dapAn;
        String test = "(10/2 + 2 -  3)  * (7-4) ";
        System.out.printf("Biểu thức cần tính là: " + test);
        System.out.println();

        result = baiTap5.chuanHoaXau(test);
        result = baiTap5.chuyenTrungToSangHauTo(result);
        System.out.printf("Dạng hậu tố là: ");
        for (int i = 0; i < result.length; i++) {
            System.out.printf(result[i] + " ");
        }
        System.out.println();
        dapAn = baiTap5.tinhGiaTri(result);
        System.out.printf("Đáp án là: " + dapAn);

    }
}
