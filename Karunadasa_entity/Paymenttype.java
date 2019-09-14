
@Entity
public class PaymentType {
    // may enum

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymenttypeId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Payment> paymentList;

}
