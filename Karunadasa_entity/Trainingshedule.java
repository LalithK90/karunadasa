
@Entity
public class TrainingShedule {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "starttime")
    private LocalTime starttime;
    @Column(name = "endtime")

    private LocalTime endtime;
    @Column(name = "assigndate")

    private LocalDate assigndate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "trainingsheduleId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Trainingsheduletopic> trainingsheduletopicList;

    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employee employeeId;

    @JoinColumn(name = "shedulestatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Shedulestatus shedulestatusId;

    @JoinColumn(name = "sheduletype_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sheduletype sheduletypeId;

    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Vehicle vehicleId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingsheduleId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Trainingshedulestudent> trainingshedulestudentList;

}
