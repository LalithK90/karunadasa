package lk.learners.karunadasa.asset.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.learners.karunadasa.security.entity.User;
import lk.learners.karunadasa.asset.commonAsset.Enum.BloodGroup;
import lk.learners.karunadasa.asset.commonAsset.Enum.Gender;
import lk.learners.karunadasa.asset.commonAsset.Enum.Title;
import lk.learners.karunadasa.util.audit.AuditEntity;
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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( callSuper = true )
public class Student extends AuditEntity {


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



}
