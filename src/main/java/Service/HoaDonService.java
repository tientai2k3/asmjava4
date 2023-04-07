package Service;

import DomainModels.GioHang;
import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    void insert(HoaDon gh);
    void update(HoaDon hd);
    void delete(UUID id);
    HoaDon findByMa(String ma);
    HoaDon findByID(UUID id);
    List<HoaDon> findAllHoaDon();
    NhanVien findbyMaNV(String ma);
    List<NhanVien> findAllNhanVien();
    KhachHang findbyMaKH(String ma);
    List<KhachHang> findAllKhachHang();
    List<HoaDon> findAllHoaDonByIdNV(UUID idNhanVien);
}
