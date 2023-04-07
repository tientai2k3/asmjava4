package Service;

import DomainModels.DongSP;
import views_models.QLDongSP;

import java.util.List;

public interface DongSpService {
    List<QLDongSP> findAll();
    void insert(QLDongSP qlcv);
    void update(DongSP dsp);
    void delete(DongSP dsp);
    DongSP findByMa(String ma);
}
