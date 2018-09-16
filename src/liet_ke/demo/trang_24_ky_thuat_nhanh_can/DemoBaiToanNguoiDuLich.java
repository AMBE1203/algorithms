package liet_ke.demo.trang_24_ky_thuat_nhanh_can;

/**
 * Created by AMBE on 30/04/2018.
 */
public class DemoBaiToanNguoiDuLich {
    private  int[][] c; // ma trận chi phí
    private  int[] x; // để thử các khả năng
    private  int[] bestWay; // để ghi nhận nghiệm
    private  int[] t; //t[i] để lưu chi phí đi từ x[1] --> x[i]
    private  boolean[] free; // để đánh dấu, free[i] == true nếu chưa đi qua thành phố i
    private  int n; // số thành phố
    private  int m; // số tuyến đường trong mạng giao thông
    private  int minSpending; // chi phí hành trình tối ưu ( nhỏ nhất )
    private static int maxC = 20 * 100 + 1; // chi phi duong vo cung

    public  void init() {
        m = 6;
        n = 4;

        c = new int[20][20];
        x = new int[21];
        bestWay = new int[21];
        t = new int[21];
        free = new boolean[20];
// khoi tao bang chi phi ban dau
        c[1][2] = 3;
        c[1][3] = 2;
        c[1][4] = 1;
        c[2][3] = 1;
        c[2][4] = 2;
        c[3][4] = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                c[j][i] = c[i][j]; // chi phi nhu nhau tren 2 chieu
                if (i == j) {
                    c[i][j] = 1;
                }

            }
        }

        for (int i = 0; i <= n; i++) {
            free[i] = true;

        }

        free[1] = false; // cac thanh pho deu chua di qua, ngoai tru thanh pho 1
        x[1] = 1; // xuat phat tu thanh pho 1
        t[1] = 0; // chi phi tai thanh pho xuat phat =0
        minSpending = maxC; // gan chi phi nho nhat bang duong vo cung


    }


    public  void giaiThuat(int i) {
        for (int j = 2; j <= n; j++) { // thu cac thanh pho tu 2 den n
            if (free[j]) { // gap thanh pho chua di qua
                x[i] = j; // thu di
                t[i] = t[i - 1] + c[x[i - 1]][j]; // chi phi = chi phi buoc truoc + chi phi di truc tiep tu i-->j
                if (t[i] < minSpending) { // luon dung c[x[i - 1]][j] < duong vo cuc
                    if (i < n) { // neu chua den dc x[n]
                        free[j] = false; // danh dau thanh pho vua thu
                        giaiThuat(i + 1); // tim cac kha nang chon x[i+1]
                        free[j] = true; // bo danh dau

                    } else {
                        if (t[n] + c[x[n]][1] < minSpending) { // tu x[n] quay lai 1 van ton tai chi phi it hon truoc

                            // cap nhat chi phi nho nhat
                            for (int k = 1; k <= n; k++) {
                                bestWay[k] = x[k];
                            }
                            minSpending = t[n] + c[x[n]][1];

                        }
                    }

                }
            }
        }

    }

    public  void result() {
        if (minSpending == maxC) {
            System.out.printf("Khong co loi giai");
        } else {
            System.out.print("Dap an la: ");
            for (int i = 1; i <= n; i++) {
                System.out.print(bestWay[i] + " -> ");
            }
            System.out.println();
            System.out.printf("Minspending: " + minSpending);
        }
    }

    public static void main(String[] args) {
        DemoBaiToanNguoiDuLich demoBaiToanNguoiDuLich=new DemoBaiToanNguoiDuLich();
        demoBaiToanNguoiDuLich.init();
        demoBaiToanNguoiDuLich.giaiThuat(2);
        demoBaiToanNguoiDuLich.result();
    }
}
