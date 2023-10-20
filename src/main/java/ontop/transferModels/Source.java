package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Source {
    @JsonProperty("type")
    private String type;
    @JsonProperty("sourceInformation")
    private SourceInformation sourceInformation;
    @JsonProperty("account")
    private SourceAccount account;

}

