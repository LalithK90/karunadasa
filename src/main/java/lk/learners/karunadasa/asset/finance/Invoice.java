package lk.learners.karunadasa.asset.finance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.learners.karunadasa.security.entity.User;
import lk.learners.karunadasa.asset.student.entity.Student;
import lk.learners.karunadasa.asset.finance.Enum.InvoicePrintOrNot;
import lk.learners.karunadasa.asset.finance.Enum.PaymentMethod;
import lk.learners.karunadasa.util.audit.AuditEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( callSuper = true )
@JsonIgnoreProperties(value = {"balance","discountAmount","bankName","cardNumber"}, allowGetters = true)
public class Invoice extends AuditEntity {


    @Column(name = "number", nullable = false, unique = true)
    private Long number;

    @Column(name = "payment_method", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;


    @Column(name = "totalPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;


    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "discountAmount",  precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "amountTendered", precision = 10, scale = 2)
    private BigDecimal amountTendered;

    @Column(name = "balance", precision = 10, scale = 2)
    private BigDecimal balance;

    @Column(name = "bank_name")
    private String bankName;


    @Column(name = "card_number")
    private Long cardNumber;


    @Column(name = "remarks", length = 150)
    private String remarks;

    @Enumerated(EnumType.STRING)
    private InvoicePrintOrNot invoicePrintOrNot;

    @Column(nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;


    @ManyToOne
    private Student student;

/*    @ManyToOne
    private Branch branch;*/

    @ManyToOne
    private DiscountRatio discountRatio;




/*
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    private List<> invoiceHasLabTests = new ArrayList<>();*/


}
