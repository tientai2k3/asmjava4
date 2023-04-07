package repositories;


import DomainModels.NSX;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import views_models.QLNSX;

import java.util.ArrayList;
import java.util.List;

public class NSXRepository {
    public void insert(NSX nsx){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(NSX nsx){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(NSX nsx){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public NSX findbyMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT nsx FROM DomainModels.NSX nsx WHERE nsx.ma =:ma");
        query.setParameter("ma",ma);
        NSX nsx = (NSX) query.getSingleResult();
        return nsx;
    }
    public List<QLNSX> findAll(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<QLNSX> list = new ArrayList<>();
        Query query = session.createQuery("SELECT new views_models.QLNSX(nsx.id, nsx.ma, nsx.ten) FROM DomainModels.NSX nsx");
        list = query.getResultList();
        return list;
    }
}
