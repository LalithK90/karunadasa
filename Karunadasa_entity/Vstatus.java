
@Entity
public class VehicleStatus {
    // may enum

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid Vehicle Status Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vstatusId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Vehicle> vehicleList;

}
