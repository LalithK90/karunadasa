
@Entity
public class Register {
    // need to disscuss
    @Column(name = "registerno")
    @Pattern(regexp = "^([R][E][G]\\d{5})$", message = "Invalid Number")
    private String registerno;

    @OneToMany(mappedBy = "registerId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Payment> paymentList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "totalfee")
    @RegexPattern(regexp = "^\\d{4,5}$", message = "Invalid Total Price")
    private BigDecimal totalfee;

    private BigDecimal registerFee;

    @RegexPattern(regexp = "^\\d{4,5}$", message = "Invalid Paid Ammount Price")
    @Column(name = "expecteddeadline")
    private LocalDate expecteddeadline;
    @Lob
    @Column(name = "remarks")
    @RegexPattern(regexp = "^.*}$", message = "Invalid Remarks")
    private String remarks;
    @Column(name = "date")
    private LocalDate date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registerId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Registervehicleclass> registervehicleclassList;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employee employeeId;
    @JoinColumn(name = "registerstatus_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Registerstatus registerstatusId;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Student studentId;

}
