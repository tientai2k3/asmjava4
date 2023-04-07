package Service;

import DomainModels.CuaHang;
import views_models.QlCuaHang;

import java.util.List;

public interface CuaHangService {
    List<QlCuaHang> findAll();
    void insert(QlCuaHang qlch);
    void update(CuaHang ch);
    void delete(CuaHang ch);
    CuaHang findByMa(String ma);
}
