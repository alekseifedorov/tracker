package my.assignment.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Developer {
    private UUID id;

    private String name;

    private List<Story> stories = new ArrayList<>();

    private int points;
}
