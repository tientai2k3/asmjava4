package Service.Impl;

import DomainModels.ChucVu;
import repositories.ChucVuRepository;
import Service.ChucVuService;
import views_models.QLChucVu;

import java.util.List;
import java.util.UUID;

public class ChucVuServiceImpl implements ChucVuService {
    private ChucVuRepository cvRepo =new ChucVuRepository();
    @Override
    public List<QLChucVu> findAll() {
        return cvRepo.findAll();
    }

    @Override
    public void insert(QLChucVu qlcv) {
        ChucVu cv = new ChucVu();
        cv.setMa(qlcv.getMa());
        cv.setTen(qlcv.getTen());
        cvRepo.insert(cv);
    }

    @Override
    public void update(ChucVu cv) {
        cvRepo.update(cv);
    }

    @Override
    public void delete(ChucVu cv) {
        cvRepo.delete(cv);
    }

    @Override
    public ChucVu findById(UUID id) {
        return cvRepo.findbyId(id);
    }

    @Override
    public ChucVu findByMa(String ma) {
        return cvRepo.findByMa(ma);
    }
}
