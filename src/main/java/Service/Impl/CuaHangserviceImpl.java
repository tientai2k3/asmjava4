package Service.Impl;

import DomainModels.CuaHang;
import Service.CuaHangService;
import repositories.CuaHangRepository;
import views_models.QlCuaHang;

import java.util.List;

public class CuaHangserviceImpl implements CuaHangService {
    private CuaHangRepository chRepo = new CuaHangRepository();
    @Override
    public List<QlCuaHang> findAll() {
        return chRepo.findAll();
    }

    @Override
    public void insert(QlCuaHang qlch) {
        CuaHang ch = new CuaHang();
        ch.setMa(qlch.getMa());
        ch.setTen(qlch.getTen());
        ch.setDiaChi(qlch.getDiaChi());
        ch.setThanhPho(qlch.getThanhPho());
        ch.setQuocGia(qlch.getQuocGia());
        chRepo.insert(ch);
    }

    @Override
    public void update(CuaHang ch) {
        chRepo.update(ch);
    }

    @Override
    public void delete(CuaHang ch) {
        chRepo.delete(ch);
    }

    @Override
    public CuaHang findByMa(String ma) {
        return chRepo.findbyMa(ma);
    }
}
