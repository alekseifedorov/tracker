package my.assignment.model;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = "id")
public class Story {
    private UUID id;

    private String title;

    private String description;

    private String creationDate;

    private Integer points;

    @ToString.Exclude
    private Developer developer;

    private ZonedDateTime createdDate;
}
