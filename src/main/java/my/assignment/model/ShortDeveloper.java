package my.assignment.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShortDeveloper {
    private UUID id;

    private String name;

    @Builder.Default
    private List<ShortStory> stories = new ArrayList<>();

    @Builder.Default
    private List<ShortBug> bugs = new ArrayList<>();

    private int points;
}
