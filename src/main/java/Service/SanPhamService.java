package Service;

import DomainModels.SanPham;
import views_models.QLSanPham;

import java.util.List;

public interface SanPhamService {
    List<QLSanPham> findAll();
    void insert(QLSanPham qlsp);
    void update(SanPham sp);
    void delete(SanPham sp);
    SanPham findByMa(String ma);
}
