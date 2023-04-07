package Service;

import DomainModels.NSX;
import views_models.QLNSX;

import java.util.List;

public interface NSXService {
    List<QLNSX> findAll();
    void insert(QLNSX qlnsx);
    void update(NSX nsx);
    void delete(NSX nsx);
    NSX findByMa(String ma);
}
