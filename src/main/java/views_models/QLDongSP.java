package views_models;

import lombok.AllArgsConstructor;

import java.util.UUID;
@AllArgsConstructor

public class QLDongSP {
    private UUID id;
    private String ma;
    private String ten;

    public QLDongSP() {
    }

    public QLDongSP(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
