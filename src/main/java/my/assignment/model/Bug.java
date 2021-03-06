package my.assignment.model;

import lombok.*;
import my.assignment.entity.enumeration.BugPriority;
import my.assignment.entity.enumeration.BugStatus;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Bug {

    private UUID id;

    private String title;

    private String description;

    private BugStatus status;

    private BugPriority priority;

    private Developer developer;

    private ZonedDateTime createdDate;
}
