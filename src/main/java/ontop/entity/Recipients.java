package ontop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipients")
public class Recipients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipient_id")
    private int recipientId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "routing_number")
    private String routingNumber;
    @Column(name = "national_identification_number")
    private String nationalIdentificationNumber;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "user_id")
    private int userId;
}
