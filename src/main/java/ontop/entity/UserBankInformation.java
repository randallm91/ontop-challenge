package ontop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_bank_information")
public class UserBankInformation {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "routing_number")
    private int routingNumber;
    @Column(name = "national_identification_number")
    private int nationalIdentificationNumber;
    @Id
    @Column(name = "account_number")
    private int accountNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public int getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(int nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "UserBankInformation{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", routingNumber=" + routingNumber +
                ", nationalIdentificationNumber=" + nationalIdentificationNumber +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
