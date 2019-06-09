package lk.learners.karunadasa.resourses.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.learners.karunadasa.resourses.company.entity.Enum.Gender;
import lk.learners.karunadasa.resourses.company.entity.Enum.Title;
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
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(unique = true)
    @NotNull(message = "This code is already add or enter incorrectly")
    private String number;

    @Enumerated(EnumType.STRING)
    private Title title;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

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

    private String land;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;


}
