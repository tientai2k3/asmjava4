package views_models;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import lombok.*;

import java.sql.Date;
import java.util.UUID;
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class QLNhanVien {
    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private CuaHang idCH;
    private ChucVu idCV;
    private int trangThai;

    public QLNhanVien(String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, CuaHang idCH, ChucVu idCV, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCH = idCH;
        this.idCV = idCV;
        this.trangThai = trangThai;
    }
}
