package repositories;


import DomainModels.NSX;
import DomainModels.SanPham;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import views_models.QLSanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    public void insert(SanPham sp){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(SanPham sp){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(SanPham sp){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public SanPham findbyMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT sp FROM DomainModels.SanPham sp WHERE sp.ma =:ma");
        query.setParameter("ma",ma);
        SanPham sp = (SanPham) query.getSingleResult();
        return sp;
    }
    public List<QLSanPham> findAll(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<QLSanPham> list = new ArrayList<>();
        Query query = session.createQuery("SELECT new views_models.QLSanPham(sp.id, sp.ma, sp.ten) FROM DomainModels.SanPham sp");
        list = query.getResultList();
        return list;
    }
}
