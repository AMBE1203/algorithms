package cau_truc_du_lieu_va_giai_thuat.bai_tap.trang_86_tiento_trungto_hauto;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by AMBE on 09/05/2018.
 * Viết chương trình chuyển biểu thức logic dạng trung tố sang hậu tố
 * Ví dụ : a and b or c and d thành : a b and c d and or
 */
public class BaiTap2 {
    public int checkDoUuTien(String c) {
        if (c.equals("and")) return 2;
        if (c.equals("or")) return 1;
        return 0;

    }

    public boolean laToanTu(String c) {
        if (c.equals("and") || c.equals("or") || c.equals("(") || c.equals(")")) {
            return true;
        }
        return false;

    }

    public String[] chuanHoaChuoi(String str) {
        String[] temp;

        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        temp = str.split(" ");


        return temp;
    }

    public String[] giaiThuat(String[] str) {
        BaiTap2 baiTap2 = new BaiTap2();

        String s1 = "";
        String[] result;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String c = str[i];
            if (!baiTap2.laToanTu(c)) {
                s1 = s1 + " " + c;
            } else {
                if (c.equals("(")) {
                    stack.push(c);
                } else {
                    if (c.equals(")")) {
                        String c1;
                        do {
                            c1 = stack.peek();
                            if (!c1.equals("(")) {
                                s1 = s1 + " " + stack.peek();
                            }
                            stack.pop();

                        } while (!c.equals("("));
                    } else {
                        while (!stack.isEmpty() && baiTap2.checkDoUuTien(stack.peek()) >= baiTap2.checkDoUuTien(c)) {
                            s1 = s1 + " " + stack.peek();
                            stack.pop();
                        }

                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            s1 = s1 + " " + stack.peek();
            stack.pop();
        }
        result = s1.split(" ");
        return result;

    }

    public static void main(String[] args) {
        String str;
        String[] result = null;
        BaiTap2 baiTap2 = new BaiTap2();
//        System.out.printf("Nhap bieu thuc: ");
//        Scanner scanner = new Scanner(System.in);
//        str = scanner.nextLine();
        String test = " a and b or c and d";
        result = baiTap2.chuanHoaChuoi(test);
        result = baiTap2.giaiThuat(result);
        for (int i = 0; i < result.length; i++) {
            System.out.printf(result[i] + " ");
        }
    }

}
