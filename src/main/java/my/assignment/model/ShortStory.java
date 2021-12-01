package my.assignment.model;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShortStory {
    private UUID id;

    private String title;

    private String description;

    private String creationDate;

    private Integer points;

    private ZonedDateTime createdDate;
}
