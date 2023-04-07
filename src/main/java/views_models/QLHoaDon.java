package views_models;

import lombok.*;

import java.sql.Date;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QLHoaDon {
    private UUID id;

    private int idKH;

    private int idNV;

    private String ma;

    private Date ngayTao;

    private Date ngayThanhToan;

    private Date ngayShip;

    private Date ngayNhan;

    private int tinhTrang;

    private String tenNguoiNhan;

    private String diaChi;

    private String sdt;
}
