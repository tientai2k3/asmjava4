package Service.Impl;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Service.NhanVienService;
import repositories.NhanVienRepository;
import views_models.QLNhanVien;

import java.util.List;
import java.util.UUID;

public class NhanVienServiceImpl implements NhanVienService {
    private NhanVienRepository nvRepo = new NhanVienRepository();
    @Override
    public List<NhanVien> findAll() {
        return nvRepo.findAll();
    }

    @Override
    public void insert(QLNhanVien qlnv) {
        NhanVien nv = new NhanVien();
        nv.setMa(qlnv.getMa());
        nv.setTen(qlnv.getTen());
        nv.setTenDem(qlnv.getTenDem());
        nv.setHo(qlnv.getHo());
        nv.setGioiTinh(qlnv.getGioiTinh());
        nv.setNgaySinh(qlnv.getNgaySinh());
        nv.setDiaChi(qlnv.getDiaChi());
        nv.setSdt(qlnv.getSdt());
        nv.setMatKhau(qlnv.getMatKhau());
        nv.setIdCV(qlnv.getIdCV());
        nv.setIdCH(qlnv.getIdCH());
        nvRepo.insert(nv);
    }

    @Override
    public void update(NhanVien nv) {
        nvRepo.update(nv);
    }

    @Override
    public void delete(NhanVien nv) {
        nvRepo.delete(nv);
    }

    @Override
    public NhanVien findByMa(String ma) {
        return nvRepo.findbyMa(ma);
    }

    @Override
    public List<ChucVu> getListIdCV() {
        return nvRepo.getListIdCV();
    }

    @Override
    public List<CuaHang> getListIdCH() {
        return nvRepo.getListIdCH();
    }

    @Override
    public CuaHang findByIdCuaHang(UUID id) {
        return nvRepo.findByIdCuaHang(id);
    }

    @Override
    public ChucVu findByIdChucVu(UUID id) {
        return nvRepo.findByIdChucVu(id);
    }

    @Override
    public ChucVu findByMaCV(String ma) {
        return nvRepo.findByMaCV(ma);
    }

    @Override
    public CuaHang findByMaCH(String ma) {
        return nvRepo.findbyMaCH(ma);
    }
}
