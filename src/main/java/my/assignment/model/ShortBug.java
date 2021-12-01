package my.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.assignment.entity.enumeration.BugPriority;
import my.assignment.entity.enumeration.BugStatus;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShortBug {

    private UUID id;

    private String title;

    private String description;

    private BugStatus status;

    private BugPriority priority;

    private ZonedDateTime createdDate;
}
