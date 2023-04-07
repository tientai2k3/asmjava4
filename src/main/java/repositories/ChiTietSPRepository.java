package repositories;

import DomainModels.*;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    public void insert(ChiTietSP ctsp){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(ChiTietSP ctsp){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(UUID id){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            ChiTietSP ctsp = (ChiTietSP) session.find(ChiTietSP.class,id);
            session.delete(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ChiTietSP findById(UUID id){
        Session session = HibernateUtil.getFACTORY().openSession();
        ChiTietSP ctsp =(ChiTietSP) session.find(ChiTietSP.class,id);
        return ctsp;
    }
    public List<ChiTietSP> findAllChiTietSP(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<ChiTietSP> list = new ArrayList<>();
        Query query = session.createQuery("SELECT ctsp FROM DomainModels.ChiTietSP ctsp");
        list = query.getResultList();
        return list;
    }
    public SanPham findbyMaSP(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT sp FROM DomainModels.SanPham sp WHERE sp.ma =:ma");
        query.setParameter("ma",ma);
        SanPham sp = (SanPham) query.getSingleResult();
        return sp;
    }
    public List<SanPham> findAllSanPham(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<SanPham> list = new ArrayList<>();
        Query query = session.createQuery("SELECT sp FROM DomainModels.SanPham sp");
        list = query.getResultList();
        return list;
    }
    public NSX findbyMaNSX(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT nsx FROM DomainModels.NSX nsx WHERE nsx.ma =:ma");
        query.setParameter("ma",ma);
        NSX nsx = (NSX) query.getSingleResult();
        return nsx;
    }
    public List<NSX> findAllNSX(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<NSX> list = new ArrayList<>();
        Query query = session.createQuery("SELECT nsx FROM DomainModels.NSX nsx");
        list = query.getResultList();
        return list;
    }
    public MauSac findbyMaMauSac(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ms FROM DomainModels.MauSac ms WHERE ms.ma =:ma");
        query.setParameter("ma",ma);
        MauSac ms = (MauSac) query.getSingleResult();
        return ms;
    }
    public List<MauSac> findAllMauSac(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<MauSac> list = new ArrayList<>();
        Query query = session.createQuery("SELECT ms FROM DomainModels.MauSac ms");
        list = query.getResultList();
        return list;
    }
    public DongSP findbyMaDongSP(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT dsp FROM DomainModels.DongSP dsp WHERE dsp.ma =:ma");
        query.setParameter("ma",ma);
        DongSP dsp = (DongSP) query.getSingleResult();
        return dsp;
    }
    public List<DongSP> findAllDongSP(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<DongSP> list = new ArrayList<>();
        Query query = session.createQuery("SELECT dsp FROM DomainModels.DongSP dsp");
        list = query.getResultList();
        return list;
    }
}
