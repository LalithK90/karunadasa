
@Entity
public class LicenseCategory {
    // may enum

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licensecategoryId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Vehicleclass> vehicleclassList;

}
