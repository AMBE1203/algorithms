package quy_hoach_dong.bai_tap.trang_172_khong_co_huong_dan;

/**
 * Created by AMBE on 24/4/2019 at 9:12 AM.
 * Tìm xâu con đối xứng dài nhất của 1 xâu cho trước
 * Cách 1: đảo lại xâu đã cho, dùng thuật toán tìm xâu con chung dài nhất.
 * Cách 2: gọi f[i,j] là chuỗi đối xứng dài nhất từ i đến j (i<=j)
            nếu s[i]=s[j] thì f[i,j]=f[i+1,j-1] + 2
            ngược lại f[i,j]=max (f[i+1,j],f[i,j-1])
 */
public class BaiTap4 {
}
