package repositories;


import DomainModels.ChucVu;
import Utils.HibernateUtil;
import org.hibernate.Transaction;
import views_models.QLChucVu;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    public void insert(ChucVu cv){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(ChucVu cv){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(ChucVu cv){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ChucVu findbyId(UUID id){
        Session session = HibernateUtil.getFACTORY().openSession();
        ChucVu cv = session.find(ChucVu.class,id);
        return cv;
    }
    public List<QLChucVu> findAll(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<QLChucVu> list = new ArrayList<>();
        Query query = session.createQuery("SELECT new views_models.QLChucVu(cv.id, cv.ma, cv.ten) FROM DomainModels.ChucVu cv");
        list = query.getResultList();
        return list;
    }
    public ChucVu findByMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT cv FROM DomainModels.ChucVu cv WHERE cv.ma =:ma");
        query.setParameter("ma",ma);
        ChucVu cv = (ChucVu) query.getSingleResult();
        return cv;
    }

}
