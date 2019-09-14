
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topicId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Trainingsheduletopic> trainingsheduletopicList;

}
