package my.assignment.service;

import my.assignment.model.CalculationRequest;
import my.assignment.model.Plan;

public interface CalculatorEngine {
    Plan calculatePlan(CalculationRequest request);
}
