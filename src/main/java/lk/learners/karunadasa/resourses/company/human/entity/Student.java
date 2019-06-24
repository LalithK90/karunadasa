package lk.learners.karunadasa.resourses.company.human.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.learners.karunadasa.general.security.entity.User;
import lk.learners.karunadasa.resourses.company.human.entity.Enum.BloodGroup;
import lk.learners.karunadasa.resourses.company.human.entity.Enum.Gender;
import lk.learners.karunadasa.resourses.company.human.entity.Enum.Title;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "This code is already add or enter incorrectly")
    private String number;

    @Enumerated(EnumType.STRING)
    private Title title;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @Column(unique = true)
    @Size(message = "NIC should be contained character 10 or 12", min = 10, max = 12)
    private String nic;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthday should be included")
    private LocalDate dateOfBirth;


    @Email(message = "Please provide a valid Email")
    private String email;

    @Min(value = 9, message = "Should be needed to enter valid mobile number")
    private String mobile;

    @Min(value = 9, message = "Should be needed to enter valid mobile number")
    private String land;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;

    @ManyToOne
    private User createdUser;


}
