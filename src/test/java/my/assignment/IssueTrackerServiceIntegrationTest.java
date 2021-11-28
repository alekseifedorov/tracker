package my.assignment;

import my.assignment.model.Bug;
import my.assignment.service.IssueTrackerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(classes = TestConfig.class)
class IssueTrackerServiceIntegrationTest {

    @Autowired
    private IssueTrackerService issueTrackerService;

    @AfterEach
    void cleanUp() {
    }

    @Test
    void shouldCreateSynonyms() {
//        issueTrackerService.createOrUpdateEntry(Bug.builder().key("dictionary")
//                .value("Woerterbuch").build());
//        issueTrackerService.createOrUpdateEntry(Bug.builder().key("encyclopaedia")
//                .value("Enzyklopaedie").build());
//        issueTrackerService.createOrUpdateEntry(Bug.builder().key("lexicon")
//                .value("Lexicon").build());
//        Bug bug = issueTrackerService.getEntry("dictionary");
//
//        Set<String> synonyms = new HashSet<>();
//        synonyms.add("lexicon");
//        synonyms.add("encyclopaedia");
//        bug.setSynonyms(synonyms);
//        issueTrackerService.createOrUpdateEntry(bug);
//
//        assertThat(issueTrackerService.getEntry("dictionary").getValue()).isEqualTo("Woerterbuch");
//        assertThat(issueTrackerService.getEntry("encyclopaedia").getSynonyms())
//                .contains("dictionary");
    }
}
