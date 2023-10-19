package ontop.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum TransactionStatus {
    INITIATED("The transfer has been initiated"),
    PENDING("The transfer is pending"),
    PROCESSING("The transfer is being processed"),
    APPROVED("The transfer has been approved"),
    DECLINED("The transfer has been declined"),
    FAILED("The transfer has failed"),
    CANCELLED("The transfer has been cancelled"),
    REVERSED("The transfer has been reversed"),
    REFUNDED("The transfer has been refunded"),
    SETTLED("The transfer has been settled"),
    HOLD("The transfer is on hold for review"),
    EXPIRED("The transfer has expired"),
    SCHEDULED("The transfer is scheduled"),
    UNDER_REVIEW("The transfer is under review"),
    COMPLETED("The transfer has been completed");

    private final String description;

}
