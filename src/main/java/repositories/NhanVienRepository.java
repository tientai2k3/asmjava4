package repositories;


import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class NhanVienRepository {

    public NhanVienRepository() {

    }
    public void insert(NhanVien nv){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(NhanVien nv){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(NhanVien nv){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public NhanVien findbyMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT nv FROM DomainModels.NhanVien nv WHERE nv.ma =:ma");
        query.setParameter("ma",ma);
        NhanVien nv = (NhanVien) query.getSingleResult();
        return nv;
    }
    public List<NhanVien> findAll(){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT nv FROM DomainModels.NhanVien nv");
        List<NhanVien> ls = query.getResultList();
        return ls;
    }
    public List<ChucVu> getListIdCV(){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT cv FROM DomainModels.ChucVu cv");
        List<ChucVu> ls = query.getResultList();
        return ls;
    }

    public List<CuaHang> getListIdCH(){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ch FROM DomainModels.CuaHang ch");
        List<CuaHang> ls = query.getResultList();
        return ls;
    }

    public CuaHang findByIdCuaHang(UUID id){
        Session session = HibernateUtil.getFACTORY().openSession();
        CuaHang ch = session.find(CuaHang.class,id);
        return ch;
    }
    public ChucVu findByIdChucVu(UUID id){
        Session session = HibernateUtil.getFACTORY().openSession();
        ChucVu cv = session.find(ChucVu.class,id);
        return cv;
    }
    public ChucVu findByMaCV(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT cv FROM DomainModels.ChucVu cv WHERE cv.ma =:ma");
        query.setParameter("ma",ma);
        ChucVu cv = (ChucVu) query.getSingleResult();
        return cv;
    }
    public CuaHang findbyMaCH(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ch FROM DomainModels.CuaHang ch WHERE ch.ma =:ma");
        query.setParameter("ma",ma);
        CuaHang ch = (CuaHang) query.getSingleResult();
        return ch;
    }
}
