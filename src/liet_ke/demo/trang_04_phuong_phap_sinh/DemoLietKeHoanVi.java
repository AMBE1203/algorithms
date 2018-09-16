package liet_ke.demo.trang_04_phuong_phap_sinh;

/**
 * Created by AMBE on 19/04/2018.
 */
public class DemoLietKeHoanVi {


    public  void giaiThuat(int n) {
        int[] arr = new int[n];
        int i;
        int k;
        int a;
        int b;
        int dem = 1;

        // khoi tao cau hinh ban dau
        for (i = 0; i < n; i++) {
            arr[i] = i;
        }

        do {

            // in ra cau hinh hien tai
            for (i = 0; i < n; i++) {
                System.out.print(arr[i] + 1);
            }
            System.out.print("\t" + dem);
            System.out.println();

            // duyet tu cuoi len dau, lui dan i
            i = n - 2;
            while (i >= 0 && arr[i] > arr[i + 1]) {
                i--;
            }
            // chua gap phai hoan vi cuoi cung giam dan n, n-1, n-2,...1
            if (i >= 0) {
                k = n - 1; // arr[k] la phan tu cuoi day
                // lui dan k de tim phan tu dau tien co arr[k]>arr[i]
                while (arr[k] < arr[i]) {
                    k--;
                }

                //doi cho a[k] va a[i]

                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;


                // lat nguoc doan cuoi giam dan
                a = i + 1;
                b = n - 1;
                while (a < b) {
                    // doi cho arr[a] va arr[b] cho den khi a==b
                    int temp1 = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp1;

                    a++;
                    b--;
                }


            }
            dem++;

        } while (i >= 0);


    }

    public static void main(String[] args) {
        DemoLietKeHoanVi demoLietKeHoanVi=new DemoLietKeHoanVi();

        demoLietKeHoanVi.giaiThuat(4);

    }
}
