package my.assignment.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StoryPart {

    private Integer startDayOfWeek;

    private Integer points;

    private Story story;
}
