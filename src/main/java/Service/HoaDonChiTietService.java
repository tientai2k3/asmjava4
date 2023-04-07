package Service;

import DomainModels.*;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {
    void insert(HoaDonChiTiet ch);
    void update(HoaDonChiTiet ch);
    void delete(HoaDonChiTiet ch);
    HoaDonChiTiet findbyIDHoaDonChiTiet(UUID idHoaDon, UUID idChiTietSP);
    List<HoaDonChiTiet> findAllHoaDonChiTiet();
    ChiTietSP findByIdCTSP(UUID id);
    List<ChiTietSP> findAllChiTietSP();
    HoaDon findByIdHoaDon(UUID id);
    List<HoaDon> findAllHoaDon();
    HoaDonChiTiet findHDCTByIdHD(UUID idHoaDon);
}
