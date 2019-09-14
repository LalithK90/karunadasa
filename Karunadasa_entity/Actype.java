/
@Entity
@Table(name = "actype")

public class AcType {
// more chance to enum
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid AC Type Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actypeId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Vehicle> vehicleList;


}
