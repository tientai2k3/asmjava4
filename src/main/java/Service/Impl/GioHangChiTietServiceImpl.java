package Service.Impl;

import DomainModels.ChiTietSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;
import Service.GioHangChiTietService;
import repositories.GioHangChiTietReporitory;

import java.util.List;
import java.util.UUID;

public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    private GioHangChiTietReporitory rp = new GioHangChiTietReporitory();
    @Override
    public void insert(GioHangChiTiet ch) {
        rp.insert(ch);
    }

    @Override
    public void update(GioHangChiTiet ch) {
        rp.update(ch);
    }

    @Override
    public void delete(GioHangChiTiet ch) {
        rp.delete(ch);
    }

    @Override
    public GioHangChiTiet findbyIDGioHangChiTiet(UUID idGioHang, UUID idChiTietSP) {
        return rp.findbyIDGioHangChiTiet(idGioHang,idChiTietSP);
    }

    @Override
    public List<GioHangChiTiet> findAllGioHangChiTiet() {
        return rp.findAllGioHangChiTiet();
    }

    @Override
    public ChiTietSP findByIdCTSP(UUID id) {
        return rp.findByIdCTSP(id);
    }

    @Override
    public List<ChiTietSP> findAllChiTietSP() {
        return rp.findAllChiTietSP();
    }

    @Override
    public GioHang findByIdGioHang(UUID id) {
        return rp.findByIdGioHang(id);
    }

    @Override
    public List<GioHang> findAllGioHang() {
        return rp.findAllGioHang();
    }

    @Override
    public GioHangChiTiet findGHCTByIdGH(UUID idGioHang) {
        return rp.findGHCTByIdGH(idGioHang);
    }
}
