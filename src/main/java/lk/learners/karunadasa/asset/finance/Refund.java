package lk.learners.karunadasa.asset.finance;

import lk.learners.karunadasa.util.audit.AuditEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode( callSuper = true )
public class Refund extends AuditEntity {

    @OneToOne( fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.DETACH} )
    private Invoice invoice;


    @Column( name = "amount", precision = 10, scale = 2 )
    private BigDecimal amount;


    @Column( name = "reason", length = 45 )
    private String reason;


}
