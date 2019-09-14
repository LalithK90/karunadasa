
@Entity
public class Gender {
    // may enum
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genderId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Student> studentList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid Gender Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genderId", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Employee> employeeList;

}
