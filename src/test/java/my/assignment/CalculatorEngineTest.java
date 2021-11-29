package my.assignment;

import lombok.extern.slf4j.Slf4j;
import my.assignment.model.CalculationRequest;
import my.assignment.model.Developer;
import my.assignment.model.Plan;
import my.assignment.model.Story;
import my.assignment.service.impl.CalculatorEngineImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class CalculatorEngineTest {

    @InjectMocks
    private CalculatorEngineImpl calculatorEngine;

    @Mock
    private Map<CalculationRequest, Plan> previousResults;

    @Test
    void shouldCalculatePlan() {
        var plan = calculatorEngine.calculatePlan(
                CalculationRequest.builder()
                        .stories(List.of(
                                Story.builder().description("5 points story").points(5).build(),
                                Story.builder().description("7 points story").points(7).build(),
                                Story.builder().description("12 points story").points(12).build()))
                        .developers(List.of(
                                Developer.builder().name("John Doe").build(),
                                Developer.builder().name("Bilbo Baggings").build()))
                        .build());
        assertThat(plan.getWeeks()).hasSize(2);
    }
}
