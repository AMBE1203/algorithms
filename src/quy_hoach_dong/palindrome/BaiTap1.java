package quy_hoach_dong.palindrome;

/**
 * Cho 1 xâu. Kiểm tra nó có phải là Palindrome hay không?
 */

public class BaiTap1 {

    public static void main(String[] args) {

        BaiTap1 baiTap1 = new BaiTap1("123321");
        boolean check = baiTap1.checkPalindrome();
        System.out.println(check);

    }

    String s;

    public BaiTap1(String s) {
        this.s = s;
    }

    private boolean checkPalindrome(){
        int i =0;
        int j = s.length()-1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return  false;
            }
            i++;
            j--;
        }

        return  true;
    }
}
