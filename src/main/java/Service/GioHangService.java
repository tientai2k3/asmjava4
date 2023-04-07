package Service;

import DomainModels.GioHang;
import DomainModels.KhachHang;
import DomainModels.NhanVien;

import java.util.List;
import java.util.UUID;

public interface GioHangService {
    void insert(GioHang gh);
    void update(GioHang gh);
    void delete(UUID id);
    GioHang findById(UUID id);
    GioHang findByMa(String ma);
    List<GioHang> findAllGioHang();
    NhanVien findbyMaNV(String ma);
    List<NhanVien> findAllNhanVien();
    KhachHang findbyMaKH(String ma);
    List<KhachHang> findAllKhachHang();
    List<GioHang> findAllGioHangByIdNV(UUID idNhanVien);
}
