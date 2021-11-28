package my.assignment.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
public class CalculationRequest {
    private List<Story> stories;
    private List<Developer> developers;
}
