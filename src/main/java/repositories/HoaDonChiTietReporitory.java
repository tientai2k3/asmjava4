package repositories;

import DomainModels.*;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HoaDonChiTietReporitory {
    public void insert(HoaDonChiTiet ch){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(HoaDonChiTiet ch){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(HoaDonChiTiet ch){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public HoaDonChiTiet findbyIDHoaDonChiTiet(UUID idHoaDon, UUID idChiTietSP){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ch FROM DomainModels.HoaDonChiTiet ch WHERE ch.idHoaDon.id=:idHoaDon AND ch.idChiTietSP.id=:idChiTietSP");
        query.setParameter("idHoaDon",idHoaDon);
        query.setParameter("idChiTietSP",idChiTietSP);
        HoaDonChiTiet ch = (HoaDonChiTiet) query.getSingleResult();
        return ch;
    }
    public List<HoaDonChiTiet> findAllHoaDonChiTiet(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<HoaDonChiTiet> list = new ArrayList<>();
        Query query = session.createQuery("SELECT ghct FROM DomainModels.HoaDonChiTiet ghct");
        list = query.getResultList();
        return list;
    }
    public ChiTietSP findByIdCTSP(UUID id){
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

    public HoaDon findByIdHoaDon(UUID id){
        Session session = HibernateUtil.getFACTORY().openSession();
        HoaDon gh = (HoaDon) session.find(HoaDon.class,id);
        return gh;
    }
    public List<HoaDon> findAllHoaDon(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<HoaDon> list = new ArrayList<>();
        Query query = session.createQuery("SELECT gh FROM DomainModels.HoaDon gh");
        list = query.getResultList();
        return list;
    }

    public HoaDonChiTiet findHDCTByIdHD(UUID idHoaDon){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ch FROM DomainModels.HoaDonChiTiet ch WHERE ch.idHoaDon.id=:idHoaDon");
        query.setParameter("idHoaDon",idHoaDon);
        HoaDonChiTiet ch = (HoaDonChiTiet) query.getSingleResult();
        return ch;
    }


}
