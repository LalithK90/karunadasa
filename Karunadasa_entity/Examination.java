
@Entity
public class Examination {

    @Column(name = "date")
    private LocalDate date;
    @JoinColumn(name = "examinationstatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Examinationstatus examinationstatusId;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Student studentId;

    @Column(name = "examinationno")
    @Pattern(regexp = "^([E][X][M]\\d{5})$", message = "Invalid Number")
    private String examinationno;

    @Column(name = "assigndate")
    private LocalDate assigndate;

    @OneToMany(mappedBy = "examinationId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Payment> paymentList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    @RegexPattern(regexp = "^.*}$", message = "Invalid Remarks")
    private String description;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "payment")
    private BigDecimal payment;
    @JoinColumn(name = "examinationtype_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Examinationtype examinationtypeId;

}
