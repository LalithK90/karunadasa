
@Entity
public class Payment {
    // need to more disscuss
    @Column(name = "paymentno")
    @Pattern(regexp = "^([P][A][Y]\\d{5})$", message = "Invalid Number")
    private String paymentno;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "ammount")
    private BigDecimal ammount;
    @Column(name = "prebalance")
    private BigDecimal prebalance;
    @Column(name = "afterbalance")
    private BigDecimal afterbalance;
    @Column(name = "paydate")
    private LocalDate paydate;

    private String studentNumber;

    @JoinColumn(name = "examination_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Examination examinationId;
    @JoinColumn(name = "paymentmode_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paymentmode paymentmodeId;
    @JoinColumn(name = "paymenttype_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paymenttype paymenttypeId;
    @JoinColumn(name = "register_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Register registerId;

}
