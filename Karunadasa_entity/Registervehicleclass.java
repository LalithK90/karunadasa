
@Entity
public class RegisterVehicleClass {
    // may enum
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "vclassfee")
    private BigDecimal vclassfee;
    @Column(name = "vclasstrainingfee")
    private BigDecimal vclasstrainingfee;
    @Column(name = "vclasstotalfee")
    private BigDecimal vclasstotalfee;
    @JoinColumn(name = "register_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Register registerId;
    @JoinColumn(name = "vehicleclass_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Vehicleclass vehicleclassId;

}
