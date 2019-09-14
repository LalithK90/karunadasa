
@Entity
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid Model Name")
    private String name;
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Brand brandId;
    @JoinColumn(name = "vehicletype_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Vehicletype vehicletypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Vehicle> vehicleList;

}
