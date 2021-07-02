package in.co.iman.SpringCloudStream;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    private String organizationId;
    private String accountId;
}
