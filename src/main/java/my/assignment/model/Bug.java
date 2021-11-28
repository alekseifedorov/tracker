package my.assignment.model;

import lombok.*;
import my.assignment.entity.DeveloperEntity;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Bug {

    private UUID id;

    private String title;

    private DeveloperEntity developer;

    private ZonedDateTime createdDate;
}
