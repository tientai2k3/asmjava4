package Service.Impl;

import DomainModels.MauSac;
import Service.MauSacService;
import repositories.MauSacRepository;
import views_models.QLMauSac;

import java.util.List;

public class MauSacServiceImpl implements MauSacService {
    private MauSacRepository msRepo =new MauSacRepository();
    @Override
    public List<QLMauSac> findAll() {
        return msRepo.findAll();
    }

    @Override
    public void insert(QLMauSac qlms) {
        MauSac ms = new MauSac();
        ms.setMa(qlms.getMa());
        ms.setTen(qlms.getTen());
        msRepo.insert(ms);
    }

    @Override
    public void update(MauSac ms) {
        msRepo.update(ms);
    }

    @Override
    public void delete(MauSac ms) {
        msRepo.delete(ms);
    }

    @Override
    public MauSac findByMa(String ma) {
        return msRepo.findbyMa(ma);
    }
}
