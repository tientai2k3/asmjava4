package Service.Impl;

import DomainModels.*;
import Service.ChiTietSPService;
import repositories.ChiTietSPRepository;

import java.util.List;
import java.util.UUID;

public class ChiTietSPServiceimpl implements ChiTietSPService {
    private ChiTietSPRepository ctspRp = new ChiTietSPRepository();
    @Override
    public void insert(ChiTietSP ctsp) {
        ctspRp.insert(ctsp);
    }

    @Override
    public void update(ChiTietSP ctsp) {
        ctspRp.update(ctsp);
    }

    @Override
    public void delete(UUID id) {
        ctspRp.delete(id);
    }

    @Override
    public ChiTietSP findById(UUID id) {
        return ctspRp.findById(id);
    }

    @Override
    public List<ChiTietSP> findAllChiTietSP() {
        return ctspRp.findAllChiTietSP();
    }

    @Override
    public SanPham findbyMaSP(String ma) {
        return ctspRp.findbyMaSP(ma);
    }

    @Override
    public List<SanPham> findAllSanPham() {
        return ctspRp.findAllSanPham();
    }

    @Override
    public NSX findbyMaNSX(String ma) {
        return ctspRp.findbyMaNSX(ma);
    }

    @Override
    public List<NSX> findAllNSX() {
        return ctspRp.findAllNSX();
    }

    @Override
    public MauSac findbyMaMauSac(String ma) {
        return ctspRp.findbyMaMauSac(ma);
    }

    @Override
    public List<MauSac> findAllMauSac() {
        return ctspRp.findAllMauSac();
    }

    @Override
    public DongSP findbyMaDongSP(String ma) {
        return ctspRp.findbyMaDongSP(ma);
    }

    @Override
    public List<DongSP> findAllDongSP() {
        return ctspRp.findAllDongSP();
    }
}
