package repositories;


import DomainModels.MauSac;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import views_models.QLMauSac;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    public void insert(MauSac ms){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(MauSac ms){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(MauSac ms){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public MauSac findbyMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ms FROM DomainModels.MauSac ms WHERE ms.ma =:ma");
        query.setParameter("ma",ma);
        MauSac ms = (MauSac) query.getSingleResult();
        return ms;
    }
    public List<QLMauSac> findAll(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<QLMauSac> list = new ArrayList<>();
        Query query = session.createQuery("SELECT new views_models.QLMauSac(ms.id, ms.ma, ms.ten) FROM DomainModels.MauSac ms");
        list = query.getResultList();
        return list;
    }
}
