package my.assignment.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Plan {

    private List<Week> weeks = new ArrayList<>();
}
