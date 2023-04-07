package Service.Impl;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Service.HoaDonService;
import repositories.HoaDonReporitory;

import java.util.List;
import java.util.UUID;

public class HoaDonServiceImpl implements HoaDonService {
    private HoaDonReporitory hdRepo = new HoaDonReporitory();
    @Override
    public void insert(HoaDon gh) {
        hdRepo.insert(gh);
    }

    @Override
    public void update(HoaDon hd) {
        hdRepo.update(hd);
    }

    @Override
    public void delete(UUID id) {
        hdRepo.delete(id);
    }

    @Override
    public HoaDon findByMa(String ma) {
        return hdRepo.findbyMa(ma);
    }

    @Override
    public HoaDon findByID(UUID id) {
        return hdRepo.findById(id);
    }

    @Override
    public List<HoaDon> findAllHoaDon() {
        return hdRepo.findAllHoaDon();
    }

    @Override
    public NhanVien findbyMaNV(String ma) {
        return hdRepo.findbyMaNV(ma);
    }

    @Override
    public List<NhanVien> findAllNhanVien() {
        return hdRepo.findAllNhanVien();
    }

    @Override
    public KhachHang findbyMaKH(String ma) {
        return hdRepo.findbyMaKH(ma);
    }

    @Override
    public List<KhachHang> findAllKhachHang() {
        return hdRepo.findAllKhachHang();
    }

    @Override
    public List<HoaDon> findAllHoaDonByIdNV(UUID idNhanVien) {
        return hdRepo.findAllHoaDonByIdNV(idNhanVien);
    }
}
