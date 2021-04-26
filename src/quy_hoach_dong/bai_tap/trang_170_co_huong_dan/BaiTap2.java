package quy_hoach_dong.bai_tap.trang_170_co_huong_dan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by cuongdt on 4/23/2021.
 * Cho n gói kẹo (n<=200), mỗi gói chứa không quá 200 viên kẹo và 1 số M <= 40000.
 * Hãy chỉ ra một cách lấy ra 1 số các gói kẹo để được tổng số kẹo là M, hoặc thông báo rằng k thể thực hiện được việc đó.
 * Giả sử số kẹo chứa trong gói thứ i là A[i].
 * Gọi b[V] là số nguyên dương bé nhất thỏa mãn: Có thể chọn trong số các gói kẹo từ gói thứ 1 đến gói b[V] ra một số gói để được tổng số kẹo là V.
 * Nếu k có phương án chọn, ta coi b[V] = dương vô cùng. Trước tiên khởi tạo b[0] = 0 và các b[V] = dương vô cùng với mọi V>0.
 * Đặt k = b[V]
 * Vì bé nhất có thể, nên nếu có cách chọn trong số các gói kẹo từ gói 1 đến gói k để được số gói kẹo V thì chắc chắn phải chọn gói k.
 * Mà đã chọn gói k rồi, thì trong số các gói kẹo từ 1 -> k-1, phải chọn ra được 1 số gói kẹo để được số kẹo là V - A[k].
 * Tức là b[V-A[k]] <= k-1 <= k.
 * Vậy b[V] được tính bằng cách:
 * Xét tất cả các gói kẹo k có A[k] <= V và thỏa mãn b[V - A[k]] < k, chọn ra chỉ số k bé nhất, sau đó gán b[V] = k.
 * b[V] = min{k | (A[k]<=V) && (b[V-A[k]]< k)}
 * Sau khi đã tính hết dãy b[1..M]. Nếu b[M] = dương vô cùng thì có nghĩa là không có phương án chọn. Nếu không thì sẽ chọn gói p[1]= b[M],
 * tiếp theo sẽ chọn gói p[2] = b[M-A[p[1]]], p[3] = b[M-A[p[1]] -A[p[2]]] đến khi truy vết về tới b[0] thì dừng.
 **/
public class BaiTap2 {

    private int n;
    private int M;
    private int[] A;
    private int MAX = 10000000;

    public BaiTap2(int n, int m, int[] a) {
        this.n = n;
        M = m;
        A = a;
    }

    private void optimize() {

        int[] b = new int[M + 1];
        b[0] = 0;
        for (int i = 1; i < b.length; i++) {
            b[i] = MAX;
        }
        for (int i = 1; i <= M; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                if (A[k] <= i && b[i - A[k]] < k) {
                    temp.add(k);
                }
            }
            if (temp.size() > 0) {
                b[i] = Collections.min(temp);
            }

        }

        // trace
        for (int a : b) {
            System.out.println(a);
        }
        if (b[M] == MAX) {
            System.out.println("Không có đáp án");

        } else {
            ArrayList<Integer> trace = new ArrayList<>();

            int t = M;
            while (t >= 0) {
                trace.add(b[t]);
                t = M - trace.stream().map(e-> A[e]).mapToInt(Integer::intValue).sum();
            }

            for (int a : trace) {
                System.out.println("Chon goi keo so: " + a + " có số kẹo là: " + A[a]);
            }

        }

    }


    public static void main(String[] args) {
        int n = 6;
        int M = 8;
        int[] A = {3, 4, 9, 5, 6, 1};
        BaiTap2 baiTap2 = new BaiTap2(n, M, A);
        baiTap2.optimize();

    }
}
