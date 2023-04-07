package Service.Impl;

import DomainModels.SanPham;
import Service.SanPhamService;
import repositories.SanPhamRepository;
import views_models.QLSanPham;

import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamRepository spRepo =new SanPhamRepository();
    @Override
    public List<QLSanPham> findAll() {
        return spRepo.findAll();
    }

    @Override
    public void insert(QLSanPham qlsp) {
        SanPham sp = new SanPham();
        sp.setMa(qlsp.getMa());
        sp.setTen(qlsp.getTen());
        spRepo.insert(sp);
    }

    @Override
    public void update(SanPham sp) {
        spRepo.update(sp);
    }

    @Override
    public void delete(SanPham sp) {
    spRepo.delete(sp);
    }

    @Override
    public SanPham findByMa(String ma) {
        return spRepo.findbyMa(ma);
    }
}
