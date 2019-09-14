
@Entity
public class TrainingSheduleStudent {
    // may enum

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "attendents")
    private boolean attendents = false;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Student studentId;
    @JoinColumn(name = "trainingshedule_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Trainingshedule trainingsheduleId;

}
