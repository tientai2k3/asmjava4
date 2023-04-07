package repositories;

import DomainModels.KhachHang;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import views_models.QLKhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private ArrayList<QLKhachHang> ds;

    public KhachHangRepository() {
        ds = new ArrayList<>();
    }
    public void insert(KhachHang kh){
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(KhachHang kh){
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(KhachHang kh){
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public KhachHang findbyMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT kh FROM KhachHang kh WHERE kh.ma =:ma");
        query.setParameter("ma",ma);
        KhachHang kh =(KhachHang) query.getSingleResult();
        return kh;
    }
    public List<KhachHang> findAll(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<KhachHang> list = new ArrayList<>();
        Query query = session.createQuery("SELECT kh FROM KhachHang kh");
        list = query.getResultList();
        return list;
    }
}
