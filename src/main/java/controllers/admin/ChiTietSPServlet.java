package controllers.admin;

import DomainModels.*;
import Service.ChiTietSPService;
import Service.Impl.ChiTietSPServiceimpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import views_models.QLNhanVien;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.UUID;

@WebServlet(name = "ChiTietSPServlet", value = {
        "/chi-tiet-san-pham/index",
        "/chi-tiet-san-pham/create",
        "/chi-tiet-san-pham/store",
        "/chi-tiet-san-pham/edit",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/delete",
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPService ctspService = new ChiTietSPServiceimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("create")) {
            this.create(request, response);
        } else if (url.contains("edit")) {
            this.edit(request, response);
        } else if (url.contains("delete")) {
            this.delete(request, response);
        }else {
            this.index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("update")) {
            this.update(request, response);
        } else if (url.contains("store")) {
            this.store(request, response);
        } else {
            response.sendRedirect("index");
        }
    }
    public void create(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setAttribute("dsSanPham",ctspService.findAllSanPham());
        request.setAttribute("dsNSX",ctspService.findAllNSX());
        request.setAttribute("dsMauSac",ctspService.findAllMauSac());
        request.setAttribute("dsDongSP",ctspService.findAllDongSP());
        request.setAttribute("view", "/Views/chi-tiet-san-pham/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request, response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChiTietSP ctsp = ctspService.findById(id);
        request.setAttribute("dsSanPham",ctspService.findAllSanPham());
        request.setAttribute("dsNSX",ctspService.findAllNSX());
        request.setAttribute("dsMauSac",ctspService.findAllMauSac());
        request.setAttribute("dsDongSP",ctspService.findAllDongSP());
        request.setAttribute("ctsp",ctsp);
        request.setAttribute("view","/Views/chi-tiet-san-pham/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChiTietSP ctsp = (ChiTietSP) ctspService.findById(id);
        ctspService.delete(id);
        response.sendRedirect("index");
    }

    public void index(HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("ds",ctspService.findAllChiTietSP());
        request.setAttribute("view","/Views/chi-tiet-san-pham/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp")
                .forward(request,response);
    }

//thêm
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;

        String moTa = request.getParameter("moTa");
        String namBH = request.getParameter("namBH");
        String giaBan = request.getParameter("giaBan");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        if (namBH.isEmpty()){
            String loiNBH = "Bạn cần phải nhập năm BH";
            request.setAttribute("txtNamBH",loiNBH);
            dem ++;
        } else {
            request.setAttribute("txtNamBH","");
        }
        if (moTa.isEmpty()){
            String loiMoTa = "Bạn cần phải nhập mô tả";
            request.setAttribute("txtMoTa",loiMoTa);
            dem ++;
        } else {
            request.setAttribute("txtMoTa","");
        }
        if (soLuongTon.isEmpty()){
            String loiTen1= "Bạn cần phải nhập số lượng tồn";
            request.setAttribute("txtSoLuongTon",loiTen1);
            dem ++;
        } else {
            request.setAttribute("txtSoLuongTon","");
        }
        if (giaNhap.isEmpty()){
            String loiTenDem = "Bạn cần phải nhập giá nhập";
            request.setAttribute("txtGiaNhap",loiTenDem);
            dem ++;
        } else {
            request.setAttribute("txtGiaNhap","");
        }
        if (giaBan.isEmpty()){
            String loiHo = "Bạn cần phải nhập giá bán";
            request.setAttribute("txtGiaBan",loiHo);
            dem ++;
        } else {
            request.setAttribute("txtGiaBan","");
        }
        if (dem==0){
            ChiTietSP ctsp = new ChiTietSP();
            SanPham sp = ctspService.findbyMaSP(request.getParameter("sanPham"));
            NSX nsx =ctspService.findbyMaNSX(request.getParameter("nhaSX"));
            MauSac ms = ctspService.findbyMaMauSac(request.getParameter("mauSac"));
            DongSP dsp = ctspService.findbyMaDongSP(request.getParameter("dongSP"));
            int namBH1 = Integer.parseInt(namBH);
            int soLuongTon1 = Integer.parseInt(soLuongTon);
            BigDecimal giaBan1 = new BigDecimal(giaBan);
            BigDecimal giaNhap1 = new BigDecimal(giaNhap);
            ctsp.setIdSP(sp);
            ctsp.setIdDongSP(dsp);
            ctsp.setIdNsx(nsx);
            ctsp.setIdMauSac(ms);
            ctsp.setNamBH(namBH1);
            ctsp.setMoTa(moTa);
            ctsp.setSoLuongTon(soLuongTon1);
            ctsp.setGiaNhap(giaNhap1);
            ctsp.setGiaBan(giaBan1);

            ctspService.insert(ctsp);
            response.sendRedirect("index");
        }else {
            request.setAttribute("view", "/Views/chi-tiet-san-pham/create.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
//update
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int dem = 0;

        String moTa = request.getParameter("moTa");
        String namBH = request.getParameter("namBH");
        String giaBan = request.getParameter("giaBan");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        if (namBH.isEmpty()){
            String loiNBH = "Bạn cần phải nhập năm BH";
            request.setAttribute("txtNamBH",loiNBH);
            dem ++;
        } else {
            request.setAttribute("txtNamBH","");
        }
        if (moTa.isEmpty()){
            String loiMoTa = "Bạn cần phải nhập mô tả";
            request.setAttribute("txtMoTa",loiMoTa);
            dem ++;
        } else {
            request.setAttribute("txtMoTa","");
        }
        if (soLuongTon.isEmpty()){
            String loiTen1= "Bạn cần phải nhập số lượng tồn";
            request.setAttribute("txtSoLuongTon",loiTen1);
            dem ++;
        } else {
            request.setAttribute("txtSoLuongTon","");
        }
        if (giaNhap.isEmpty()){
            String loiTenDem = "Bạn cần phải nhập giá nhập";
            request.setAttribute("txtGiaNhap",loiTenDem);
            dem ++;
        } else {
            request.setAttribute("txtGiaNhap","");
        }
        if (giaBan.isEmpty()){
            String loiHo = "Bạn cần phải nhập giá bán";
            request.setAttribute("txtGiaBan",loiHo);
            dem ++;
        } else {
            request.setAttribute("txtGiaBan","");
        }
        if (dem==0){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP ctsp = ctspService.findById(id);
            System.out.println(request.getParameter("sanPham"));
            SanPham sp = ctspService.findbyMaSP(request.getParameter("sanPham"));
            NSX nsx =ctspService.findbyMaNSX(request.getParameter("nhaSX"));
            MauSac ms = ctspService.findbyMaMauSac(request.getParameter("mauSac"));
            DongSP dsp = ctspService.findbyMaDongSP(request.getParameter("dongSP"));

//            SanPham sp = ctspService.findbyMaSP("SP02");
//            NSX nsx =ctspService.findbyMaNSX("NSX01");
//            MauSac ms = ctspService.findbyMaMauSac("MS01");
//            DongSP dsp = ctspService.findbyMaDongSP("DSP02");

            System.out.println(ms.getMa() +" "+dsp.getMa() +" "+sp.getTen());
            int namBH1 = Integer.parseInt(namBH);
            int soLuongTon1 = Integer.parseInt(soLuongTon);
            BigDecimal giaBan1 = new BigDecimal(giaBan);
            BigDecimal giaNhap1 = new BigDecimal(giaNhap);
            ctsp.setIdSP(sp);
            ctsp.setIdDongSP(dsp);
            ctsp.setIdNsx(nsx);
            ctsp.setIdMauSac(ms);
            ctsp.setNamBH(namBH1);
            ctsp.setMoTa(moTa);
            ctsp.setSoLuongTon(soLuongTon1);
            ctsp.setGiaNhap(giaNhap1);
            ctsp.setGiaBan(giaBan1);
            System.out.println(ctsp.getGiaNhap());
            ctspService.update(ctsp);
            response.sendRedirect("index");
        }else {
            request.setAttribute("view", "/Views/chi-tiet-san-pham/edit.jsp");
            request.getRequestDispatcher("/Views/layout.jsp")
                    .forward(request, response);
        }
    }
}
