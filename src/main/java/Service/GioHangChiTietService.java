package Service;

import DomainModels.ChiTietSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    void insert(GioHangChiTiet ch);
    void update(GioHangChiTiet ch);
    void delete(GioHangChiTiet ch);
    GioHangChiTiet findbyIDGioHangChiTiet(UUID idGioHang, UUID idChiTietSP);
    List<GioHangChiTiet> findAllGioHangChiTiet();
    ChiTietSP findByIdCTSP(UUID id);
    List<ChiTietSP> findAllChiTietSP();
    GioHang findByIdGioHang(UUID id);
    List<GioHang> findAllGioHang();
    GioHangChiTiet findGHCTByIdGH(UUID idGioHang);
}
