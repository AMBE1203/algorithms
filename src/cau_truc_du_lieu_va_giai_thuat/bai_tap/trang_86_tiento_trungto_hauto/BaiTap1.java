package cau_truc_du_lieu_va_giai_thuat.bai_tap.trang_86_tiento_trungto_hauto;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by AMBE on 08/05/2018.
 * Viết 1 chương trình chuyển biểu thức trung tố có cả những phép toán 1 ngôi sang dạng hậu tố.
 * Bao gồm: Phép lấy số đối (-x), phép lũy thừa (x^y), lời gọi hàm số học (sqrt,exp,abs,..)
 */
public class BaiTap1 {

    public String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }

    public String chuanHoaDanhTuRieng(String str) {
        str = chuanHoa(str);
        String[] tem = str.split(" ");
        str = " ";
        for (int i = 0; i < tem.length; i++) {
            str += String.valueOf(tem[i].charAt(0)).toUpperCase() + tem[i].substring(1);
            if (i < tem.length - 1) {
                str += " ";
            }
        }
        return str;
    }

    public int checkDoUuTien(char c) {
        if (c == '^' || c == 'e' || c == 's' || c == 'a') return 3;
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return 0;

    }

    public boolean laToanTu(char c) {
        char[] toanHang = {'+', '-', '*', '/','(',')', '^', 'a', 'e', 's'};
        Arrays.sort(toanHang);
        if (Arrays.binarySearch(toanHang, c) > -1) {
            return true;
        }
        return false;

    }

    public String[] chuanHoaChuoi(String str) {
        BaiTap1 baiTap1 = new BaiTap1();
        String s1 = "";
        String[] temp;
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!baiTap1.laToanTu(c)) {
                s1 = s1 + c;
            } else {
                s1 = s1 + " " + c + " ";
            }
        }
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+", " ");
        temp = s1.split(" ");
        return temp;
    }

    public String[] giaiThuat(String[] str) {
        BaiTap1 baiTap1 = new BaiTap1();
        String[] result;
        String s1 = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            char c = str[i].charAt(0); // ky tu dau tien cua moi phan tu
            if (!baiTap1.laToanTu(c)) {
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
                        while (!stack.isEmpty() && baiTap1.checkDoUuTien(stack.peek().charAt(0)) >= baiTap1.checkDoUuTien(c)) {
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
        result = s1.split(" ");
        return result;

    }

    public static void main(String[] args) {
        String str;
        String[] result = null;
        BaiTap1 baiTap1 = new BaiTap1();
//        System.out.printf("Nhap bieu thuc: ");
//        Scanner scanner = new Scanner(System.in);
//        str = scanner.nextLine();
        String test=" (10*(-3) +   s(7)/a(8)) * (5-1)";
        result = baiTap1.chuanHoaChuoi(test);
        result = baiTap1.giaiThuat(result);
        for (int i = 0; i < result.length; i++) {
            System.out.printf(result[i] + " ");
        }
    }
}
