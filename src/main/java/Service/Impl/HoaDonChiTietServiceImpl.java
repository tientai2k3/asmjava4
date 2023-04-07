package Service.Impl;

import DomainModels.*;
import Service.GioHangChiTietService;
import Service.HoaDonChiTietService;
import repositories.GioHangChiTietReporitory;
import repositories.HoaDonChiTietReporitory;

import java.util.List;
import java.util.UUID;

public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    private HoaDonChiTietReporitory rp = new HoaDonChiTietReporitory();
    @Override
    public void insert(HoaDonChiTiet ch) {
        rp.insert(ch);
    }

    @Override
    public void update(HoaDonChiTiet ch) {
        rp.update(ch);
    }

    @Override
    public void delete(HoaDonChiTiet ch) {
        rp.delete(ch);
    }

    @Override
    public HoaDonChiTiet findbyIDHoaDonChiTiet(UUID idHoaDon, UUID idChiTietSP) {
        return rp.findbyIDHoaDonChiTiet(idHoaDon,idChiTietSP);
    }

    @Override
    public List<HoaDonChiTiet> findAllHoaDonChiTiet() {
        return rp.findAllHoaDonChiTiet();
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
    public HoaDon findByIdHoaDon(UUID id) {
        return rp.findByIdHoaDon(id);
    }

    @Override
    public List<HoaDon> findAllHoaDon() {
        return rp.findAllHoaDon();
    }

    @Override
    public HoaDonChiTiet findHDCTByIdHD(UUID idHoaDon) {
        return rp.findHDCTByIdHD(idHoaDon);
    }
}
