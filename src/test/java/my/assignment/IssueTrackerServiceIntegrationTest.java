package my.assignment;

import my.assignment.model.Developer;
import my.assignment.model.ShortDeveloper;
import my.assignment.model.Story;
import my.assignment.repository.BugRepository;
import my.assignment.repository.DeveloperRepository;
import my.assignment.repository.StoryRepository;
import my.assignment.service.DeveloperService;
import my.assignment.service.IssueTrackerService;
import my.assignment.service.StoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class IssueTrackerServiceIntegrationTest {

    @Autowired
    private IssueTrackerService issueTrackerService;

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private StoryService storyService;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private BugRepository bugRepository;

    @BeforeEach
    void init() {
        initDb();
    }

    @AfterEach
    void cleanUp() {
        storyRepository.deleteAll();
        bugRepository.deleteAll();
        developerRepository.deleteAll();
    }

    @Test
    void shouldCalculatePlan() {
        var plan = issueTrackerService.calculatePlan();

        assertThat(plan).isNotNull();
        assertThat(plan.getWeeks()).hasSize(2);
        assertThat(plan.getWeeks().get(0).getStories()).hasSize(3);
        assertThat(plan.getWeeks().get(1).getStories()).hasSize(1);

        assertThat(storyService.getAll()).extracting(Story::getDeveloper).isNotEmpty();
        assertThat(developerService.getAll()).extracting(ShortDeveloper::getStories).isNotEmpty();
    }

    private void initDb() {
        developerService.createOrUpdateDeveloper(Developer.builder().name("John Doe").build());
        developerService.createOrUpdateDeveloper(Developer.builder().name("Bilbo Baggings").build());

        storyService.createOrUpdateStory(Story.builder()
                .title("5 points story")
                .points(5)
                .description("5 points story")
                .build());

        storyService.createOrUpdateStory(Story.builder()
                .title("7 points story")
                .points(7)
                .description("7 points story")
                .build());

        storyService.createOrUpdateStory(Story.builder()
                .title("12 points story")
                .points(12)
                .description("12 points story")
                .build());
    }
}
