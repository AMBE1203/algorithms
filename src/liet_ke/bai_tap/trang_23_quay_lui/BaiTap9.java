package liet_ke.bai_tap.trang_23_quay_lui;

import java.util.Scanner;

/**
 * Created by AMBE on 28/04/2018.
 * Bài toán mã đi tuần. Cho bàn cờ tổng quát kích thước nxn và 1 quân mã.
 * Hãy chỉ ra 1 hành trình của quân mã xuất phát từ ô đang đứng đi qua tất cả các ô còn lại của bàn cờ.
 * Môi ô đúng 1 lần
 */
public class BaiTap9 {

    private  int n;
    private  int[][] arr;
    private  int[] h = {-1, -2, -2, -1, 1, 1, 2, 2};
    private  int[] c = {-2, -1, 1, 2, -2, 2, -1, 1};

    public  void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n= ");
        n = scanner.nextInt();
        arr = new int[n][n];

    }


    public  void result() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public  void giaiThuat(int i, int j, int k) {
        for (int t = 0; t < 8; t++) {

            int x = i + h[t];
            int y = j + c[t];
            if (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == 0) {
                arr[x][y] = k;
                if (k == n * n) {
                    result();
                } else {
                    giaiThuat(x, y, k + 1);
                    arr[x][y] = 0;

                }

            }


        }


    }

    public void demo(){
        arr[0][0] = 1;
        giaiThuat(0, 0, 2);
    }

    public static void main(String[] args) {
        BaiTap9 baiTap9=new BaiTap9();
        baiTap9.init();
        baiTap9.demo();

    }

}
