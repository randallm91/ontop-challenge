package ontop.business;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
    USD("US Dollar"),
    EUR("Euro"),
    GBP("British Pound"),
    JPY("Japanese Yen"),
    CAD("Canadian Dollar");

    private final String description;
}
