package repositories;

import DomainModels.*;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GioHangReporitory {
    public void insert(GioHang gh){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(GioHang gh){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(UUID id){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            GioHang gh = (GioHang) session.find(GioHang.class,id);
            session.delete(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public GioHang findById(UUID id){
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

    public List<GioHang> findAllGioHangByIdNV(UUID idNhanVien){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<GioHang> list = new ArrayList<>();
        Query query = session.createQuery("SELECT gh FROM DomainModels.GioHang gh WHERE gh.idNV.id =:idNhanVien AND gh.tinhTrang =0");
        query.setParameter("idNhanVien",idNhanVien);
        list = query.getResultList();
        return list;
    }


    public GioHang findbyMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT gh FROM DomainModels.GioHang gh WHERE gh.ma =:ma");
        query.setParameter("ma",ma);
        GioHang nv = (GioHang) query.getSingleResult();
        return nv;
    }

    public NhanVien findbyMaNV(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT nv FROM DomainModels.NhanVien nv WHERE nv.ma =:ma");
        query.setParameter("ma",ma);
        NhanVien nv = (NhanVien) query.getSingleResult();
        return nv;
    }
    public List<NhanVien> findAllNhanVien(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<NhanVien> list = new ArrayList<>();
        Query query = session.createQuery("SELECT nv FROM DomainModels.NhanVien nv");
        list = query.getResultList();
        return list;
    }

    public KhachHang findbyMaKH(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT kh FROM DomainModels.KhachHang kh WHERE kh.ma =:ma");
        query.setParameter("ma",ma);
        KhachHang kh = (KhachHang) query.getSingleResult();
        return kh;
    }
    public List<KhachHang> findAllKhachHang(){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<KhachHang> list = new ArrayList<>();
        Query query = session.createQuery("SELECT kh FROM DomainModels.KhachHang kh");
        list = query.getResultList();
        return list;
    }
}
