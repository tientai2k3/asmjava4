package DomainModels;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GioHangChiTietId implements Serializable {
    private GioHang idGioHang;
    private ChiTietSP idChiTietSP;
}
