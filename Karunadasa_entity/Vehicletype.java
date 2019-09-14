
@Entity
public class VehicleType {
    // may enum

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid Vehicle Type Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicletypeId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Model> modelList;

}
