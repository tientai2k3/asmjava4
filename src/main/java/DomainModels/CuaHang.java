package DomainModels;

import jakarta.persistence.*;
import lombok.*;
import DomainModels.NhanVien;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "CuaHang")
public class CuaHang  {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "ThanhPho")
    private String thanhPho;
    @Column(name = "QuocGia")
    private String quocGia;

    @OneToMany(mappedBy = "idCH", fetch = FetchType.EAGER)
    private List<NhanVien> listNhanVien;
}
