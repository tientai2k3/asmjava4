package Service.Impl;

import DomainModels.GioHang;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Service.GioHangService;
import repositories.GioHangReporitory;

import java.util.List;
import java.util.UUID;

public class GioHangServiceImpl implements GioHangService {
    private GioHangReporitory ghRepo = new GioHangReporitory();
    @Override
    public void insert(GioHang gh) {
        ghRepo.insert(gh);
    }

    @Override
    public void update(GioHang gh) {
        ghRepo.update(gh);
    }

    @Override
    public void delete(UUID id) {
        ghRepo.delete(id);
    }

    @Override
    public GioHang findById(UUID id) {
        return ghRepo.findById(id);
    }

    @Override
    public GioHang findByMa(String ma) {
        return ghRepo.findbyMa(ma);
    }

    @Override
    public List<GioHang> findAllGioHang() {
        return ghRepo.findAllGioHang();
    }

    @Override
    public NhanVien findbyMaNV(String ma) {
        return ghRepo.findbyMaNV(ma);
    }

    @Override
    public List<NhanVien> findAllNhanVien() {
        return ghRepo.findAllNhanVien();
    }

    @Override
    public KhachHang findbyMaKH(String ma) {
        return ghRepo.findbyMaKH(ma);
    }

    @Override
    public List<KhachHang> findAllKhachHang() {
        return ghRepo.findAllKhachHang();
    }

    @Override
    public List<GioHang> findAllGioHangByIdNV(UUID idNhanVien) {
        return ghRepo.findAllGioHangByIdNV(idNhanVien);
    }
}
