package Service;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.MauSac;
import DomainModels.NhanVien;
import views_models.QLMauSac;
import views_models.QLNhanVien;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> findAll();
    void insert(QLNhanVien qlnv);
    void update(NhanVien nv);
    void delete(NhanVien nv);
    NhanVien findByMa(String ma);
    List<ChucVu> getListIdCV();
    List<CuaHang> getListIdCH();
    CuaHang findByIdCuaHang(UUID id);
    ChucVu findByIdChucVu(UUID id);
    ChucVu findByMaCV(String ma);
    CuaHang findByMaCH(String ma);
}
