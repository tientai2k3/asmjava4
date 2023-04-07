package Service.Impl;

import DomainModels.DongSP;
import Service.DongSpService;
import repositories.DongSpRepository;
import views_models.QLDongSP;

import java.util.List;

public class DongSpServiceImpl implements DongSpService {
    private DongSpRepository dspRp = new DongSpRepository();
    @Override
    public List<QLDongSP> findAll() {
        return dspRp.findAll();
    }

    @Override
    public void insert(QLDongSP qlcv) {
        DongSP dsp = new DongSP();
        dsp.setMa(qlcv.getMa());
        dsp.setTen(qlcv.getTen());
        dspRp.insert(dsp);
    }

    @Override
    public void update(DongSP dsp) {
        dspRp.update(dsp);
    }

    @Override
    public void delete(DongSP dsp) {
        dspRp.delete(dsp);
    }

    @Override
    public DongSP findByMa(String ma) {
        return dspRp.findbyMa(ma);
    }
}
