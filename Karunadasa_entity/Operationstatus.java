
@Entity
public class OperationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operationstatusId", fetch = FetchType.LAZY)
    private List<Operationlog> operationlogList;

}
