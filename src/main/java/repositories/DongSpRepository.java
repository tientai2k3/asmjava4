package repositories;


import DomainModels.DongSP;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import views_models.QLDongSP;

import java.util.ArrayList;
import java.util.List;

public class DongSpRepository {

    public void insert(DongSP dsp){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(DongSP dsp){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(DongSP dsp){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public DongSP findbyMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT dsp FROM DomainModels.DongSP dsp WHERE dsp.ma =:ma");
        query.setParameter("ma",ma);
        DongSP dsp = (DongSP) query.getSingleResult();
        return dsp;
    }
    public List<QLDongSP> findAll(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<QLDongSP> list = new ArrayList<>();
        Query query = session.createQuery("SELECT new views_models.QLDongSP(dsp.id, dsp.ma, dsp.ten) FROM DomainModels.DongSP dsp");
        list = query.getResultList();
        return list;
    }
}
