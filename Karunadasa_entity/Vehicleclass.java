
@Entity
public class VehicleClass {

    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleclassId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Registervehicleclass> registervehicleclassList;

    @Column(name = "code")
    @Pattern(regexp = "^.*$", message = "Invalid Code Or Code Is Cannot Empty")
    private String code;
    @Lob
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description Or Description Is Cannot Empty")
    private String description;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "fee")
    private BigDecimal fee;
    @Column(name = "trainingfee")
    private BigDecimal trainingfee;
    @Column(name = "assigndate")
    @Temporal(TemporalType.DATE)
    private Date assigndate;
    @JoinColumn(name = "licensecategory_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Licensecategory licensecategoryId;
    @JoinColumn(name = "vcstatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Vcstatus vcstatusId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleclassId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Vehicle> vehicleList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleclassId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Vehicleclassoldclass> vehicleclassoldclassList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licenseclassId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Additionalclass> additionalclassList;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "additionalclassId", fetch = FetchType.LAZY)
    private List<Additionalclass> additionalclassList1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Pattern(regexp = "^(.*)$", message = "Invalid Vehicle Class Name Or It Is Cannot Empty")
    private String name;

}
