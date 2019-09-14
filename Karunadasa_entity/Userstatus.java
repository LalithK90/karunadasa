
@Entity
public class UserStatus {
    // may enum

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid User Status Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userstatusId", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<User> userList;

}
