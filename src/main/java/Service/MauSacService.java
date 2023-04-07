package Service;

import DomainModels.MauSac;
import views_models.QLMauSac;

import java.util.List;

public interface MauSacService {
    List<QLMauSac> findAll();
    void insert(QLMauSac qlms);
    void update(MauSac ms);
    void delete(MauSac ms);
    MauSac findByMa(String ma);
}
