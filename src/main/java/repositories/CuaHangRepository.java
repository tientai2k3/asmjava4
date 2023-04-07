package repositories;


import DomainModels.ChucVu;
import DomainModels.CuaHang;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import views_models.QLChucVu;
import views_models.QlCuaHang;

import java.util.ArrayList;
import java.util.List;

public class CuaHangRepository {
    public void insert(CuaHang ch){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(CuaHang ch){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(CuaHang ch){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public CuaHang findbyMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ch FROM DomainModels.CuaHang ch WHERE ch.ma =:ma");
        query.setParameter("ma",ma);
        CuaHang ch = (CuaHang) query.getSingleResult();
        return ch;
    }
    public List<QlCuaHang> findAll(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<QlCuaHang> list = new ArrayList<>();
        Query query = session.createQuery("SELECT new views_models.QlCuaHang(ch.id, ch.ma, ch.ten,ch.diaChi, ch.thanhPho, ch.quocGia) FROM DomainModels.CuaHang ch");
        list = query.getResultList();
        return list;
    }
}
