package my.assignment;

import my.assignment.exception.EntryNotExistException;
import my.assignment.service.CalculatorEngine;
import my.assignment.service.impl.IssueTrackerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorEngineTest {

    @InjectMocks
    private CalculatorEngine calculatorEngine;

    @Test
    public void shouldThrowEntryNotExistExceptionWhenGettingEntry() {
//        when(cacheService.getEntry(anyString())).thenReturn(null);
//
//        assertThatThrownBy(() -> dictionaryService.getEntry("dictionary"))
//                .isInstanceOf(EntryNotExistException.class);
    }
}
