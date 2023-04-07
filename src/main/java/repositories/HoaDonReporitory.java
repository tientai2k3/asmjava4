package repositories;

import DomainModels.GioHang;
import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HoaDonReporitory {
    public void insert(HoaDon hd){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(HoaDon hd){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(UUID id){
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            HoaDon hd = session.find(HoaDon.class,id);
            session.delete(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public HoaDon findById(UUID id){
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
    public HoaDon findbyMa(String ma){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("SELECT hd FROM DomainModels.HoaDon hd WHERE hd.ma LIKE: ma");
        query.setParameter("ma",ma);
        HoaDon hd = (HoaDon) query.getSingleResult();
        return hd;
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

    public List<HoaDon> findAllHoaDonByIdNV(UUID idNhanVien){
        Session session = HibernateUtil.getFACTORY().openSession();
        List<HoaDon> list = new ArrayList<>();
        Query query = session.createQuery("SELECT hd FROM DomainModels.HoaDon hd WHERE hd.idNV.id =:idNhanVien");
        query.setParameter("idNhanVien",idNhanVien);
        list = query.getResultList();
        return list;
    }
}
