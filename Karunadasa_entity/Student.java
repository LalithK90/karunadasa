
@Entity
public class Student {
    // may need to dis
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Examination> examinationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Trainingshedulestudent> trainingshedulestudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Register> registerList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fullname")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid Fullname")
    private String fullname;
    @Column(name = "cname")
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid Calligname  Or It is Cannot Empty")
    private String cname;

    @Email
    private String email;

    @Column(name = "dobirth")
    private LocalDate dobirth;
    @Column(name = "nic")
    @Pattern(regexp = "^(([\\d]{9}[vVxX])|([\\d]{12}))$", message = "Invalid NIC  Or It is Cannot Empty")
    private String nic;
    @Lob
    @Column(name = "address")
    @Pattern(regexp = "^([\\w\\/\\-,\\s]{2,})$", message = "Invalid Address  Or It is Cannot Empty")
    private String address;
    @Column(name = "mobile")
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Mobilephone Number  Or It is Cannot Empty")
    private String mobile;
    @Column(name = "land")
    @Pattern(regexp = "^(((0\\d{9})){0,1})$", message = "Invalid Landphone Number  Or It is Cannot Empty")
    private String land;
    @Column(name = "stuno")
    @Pattern(regexp = "^([S][T][U]\\d{5})$", message = "Invalid Number")
    private String stuno;
    @Lob
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    private String description;
    @Column(name = "doassignment")
    private LocalDate doassignment;
    @JoinColumn(name = "bloodgroup_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Bloodgroup bloodgroupId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employee employeeId;
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Gender genderId;
    @JoinColumn(name = "studentstatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Studentstatus studentstatusId;

}
