package quy_hoach_dong.bai_tap.trang_172_khong_co_huong_dan;

/**
 * Created by AMBE on 24/4/2019 at 9:16 AM.
 * Tạo 1 xâu đối xứng chứa xâu con S cho trước.
 * F[i, j] = Số ký tự ít nhất cần thêm vào xâu S[i..j] để nó thành 1 xâu đối xứng.
    Ta có công thức như sau:
    F[i, i] = 0.
    F[i, j] = F[i + 1, j - 1] nếu S[i] = S[j].
    F[i, j] = min(F[i + 1, j], F[i, j - 1]) + 1 nếu S[i] <> S[j].
    Kết quả sẽ được lưu ở F[1, n], với n là chiều dài của chuỗi S.
 *
 */
public class BaiTap5 {
}
