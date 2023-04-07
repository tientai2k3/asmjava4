package DomainModels;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HoaDonChiTietId implements Serializable {
    private HoaDon idHoaDon;
    private ChiTietSP idChiTietSP;

}
