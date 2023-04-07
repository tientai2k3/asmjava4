package views_models;

import lombok.*;

import java.sql.Date;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QLGioHang {
    private UUID id;

    private int idKH;

    private int idNV;

    private String ma;

    private Date ngayTao;

    private Date ngayThanhToan;


    private String tenNguoiNhan;

    private String diaChi;

    private String sdt;

    private int tinhTrang;
}
