package Service;

import DomainModels.ChucVu;
import views_models.QLChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<QLChucVu> findAll();
    void insert(QLChucVu qlcv);
    void update(ChucVu cv);
    void delete(ChucVu cv);
    ChucVu findById(UUID id);
    ChucVu findByMa(String ma);
}
