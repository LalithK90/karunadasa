
@Entity
public class SheduleType {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sheduletypeId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Trainingshedule> trainingsheduleList;

}
