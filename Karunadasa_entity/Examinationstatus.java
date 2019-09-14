
@Entity
public class ExaminationStatus {
    // may enum
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examinationstatusId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Examination> examinationList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

}
