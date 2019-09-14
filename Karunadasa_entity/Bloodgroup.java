
@Entity
public class BloodGroup {
    // most may enum
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Pattern(regexp = "^(.*)$", message = "Invalid Blood Group Name")
    private String name;

}
