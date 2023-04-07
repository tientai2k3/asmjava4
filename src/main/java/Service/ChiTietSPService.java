package Service;

import DomainModels.*;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    void insert(ChiTietSP ctsp);
    void update(ChiTietSP ctsp);
    void delete(UUID id);
    ChiTietSP findById(UUID id);
    List<ChiTietSP> findAllChiTietSP();

    SanPham findbyMaSP(String ma);
    List<SanPham> findAllSanPham();

    NSX findbyMaNSX(String ma);
    List<NSX> findAllNSX();

    MauSac findbyMaMauSac(String ma);
    List<MauSac> findAllMauSac();

    DongSP findbyMaDongSP(String ma);
    List<DongSP> findAllDongSP();

}
