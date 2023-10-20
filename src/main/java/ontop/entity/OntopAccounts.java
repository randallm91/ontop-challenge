package ontop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ontop_accounts")
public class OntopAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId = 1;
    @Column(name = "account_type")
    private String accountType = "COMPANY";
    @Column(name = "account_name")
    private String accountName = "ONTOP INC";
    @Column(name = "account_number")
    private String accountNumber = "0245253419";
    @Column(name = "currency")
    private String currency = "USD";
    @Column(name = "routing_number")
    private String routingNumber ="028444018";


}
