package views_models;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@AllArgsConstructor

public class QLChiTietSanPham {
    private UUID id;
    private int idSP;
    private int idNsx;
    private int idMauSac;
    private int idDongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
}
