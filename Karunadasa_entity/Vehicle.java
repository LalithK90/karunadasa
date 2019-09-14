
@Entity
public class Vehicle {
    // may need
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Maintanance> maintananceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Trainingshedule> trainingsheduleList;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "year")
    private Integer year;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employee employeeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    // AH-1025
    @Column(name = "no")
    @Pattern(regexp = "^(([A-Z]{3})||([A-Z]{2}))(-)+([0-9]{4})$", message = "Invalid Number")
    private String no;

    @Lob
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    private String description;

    // seat count 2 to 59

    @Column(name = "seatcount")
    @RegexPattern(regexp = "^(([2-9])||([1-5]{1}[0-9]{1}))$", message = "Invalid Year")
    private Integer seatcount;

    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "ftankcapacity")
    @RegexPattern(regexp = "^\\d{3}$", message = "Invalid Capacity")
    private BigDecimal ftankcapacity;

    @JoinColumn(name = "actype_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Actype actypeId;

    @JoinColumn(name = "model_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Model modelId;

    @JoinColumn(name = "vehicleclass_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Vehicleclass vehicleclassId;

    @JoinColumn(name = "vstatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Vstatus vstatusId;

}
