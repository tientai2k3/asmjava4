package Service.Impl;

import DomainModels.NSX;
import Service.NSXService;
import repositories.NSXRepository;
import views_models.QLNSX;

import java.util.List;

public class NSXServiceImpl implements NSXService {
    private NSXRepository nsxRepo =new NSXRepository();
    @Override
    public List<QLNSX> findAll() {
        return nsxRepo.findAll();
    }

    @Override
    public void insert(QLNSX qlnsx) {
        NSX nsx = new NSX();
        nsx.setMa(qlnsx.getMa());
        nsx.setTen(qlnsx.getTen());
        nsxRepo.insert(nsx);
    }

    @Override
    public void update(NSX nsx) {
        nsxRepo.update(nsx);
    }

    @Override
    public void delete(NSX nsx) {
        nsxRepo.delete(nsx);
    }

    @Override
    public NSX findByMa(String ma) {
        return nsxRepo.findbyMa(ma);
    }
}
