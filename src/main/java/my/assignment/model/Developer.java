package my.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = "id")
public class Developer {
    private UUID id;

    private String name;

    @Builder.Default
    @JsonIgnore
    private List<Story> stories = new ArrayList<>();

    private int points;
}
