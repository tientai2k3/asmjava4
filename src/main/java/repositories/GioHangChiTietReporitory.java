package repositories;

import DomainModels.ChiTietSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GioHangChiTietReporitory {
    public void insert(GioHangChiTiet ch){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(GioHangChiTiet ch){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(GioHangChiTiet ch){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public GioHangChiTiet findbyIDGioHangChiTiet(UUID idGioHang, UUID idChiTietSP){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ch FROM DomainModels.GioHangChiTiet ch WHERE ch.idGioHang.id=:idGioHang AND ch.idChiTietSP.id=:idChiTietSP");
        query.setParameter("idGioHang",idGioHang);
        query.setParameter("idChiTietSP",idChiTietSP);
        GioHangChiTiet ch = (GioHangChiTiet) query.getSingleResult();
        return ch;
    }
    public List<GioHangChiTiet> findAllGioHangChiTiet(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<GioHangChiTiet> list = new ArrayList<>();
        Query query = session.createQuery("SELECT ghct FROM DomainModels.GioHangChiTiet ghct");
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

    public GioHang findByIdGioHang(UUID id){
        Session session = HibernateUtil.getFACTORY().openSession();
        GioHang gh = (GioHang) session.find(GioHang.class,id);
        return gh;
    }
    public List<GioHang> findAllGioHang(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<GioHang> list = new ArrayList<>();
        Query query = session.createQuery("SELECT gh FROM DomainModels.GioHang gh");
        list = query.getResultList();
        return list;
    }

    public GioHangChiTiet findGHCTByIdGH(UUID idGioHang){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ch FROM DomainModels.GioHangChiTiet ch WHERE ch.idGioHang.id=:idGioHang");
        query.setParameter("idGioHang",idGioHang);
        GioHangChiTiet ch = (GioHangChiTiet) query.getSingleResult();
        return ch;
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT ch FROM DomainModels.GioHangChiTiet ch WHERE ch.idGioHang.id=:idGioHang");
        query.setParameter("idGioHang",UUID.fromString("7f2f6f60-3fb4-4948-bb88-c1b06c76b941"));
        GioHangChiTiet ch = (GioHangChiTiet) query.getSingleResult();
        System.out.println(ch.getSoLuong());
    }
}
