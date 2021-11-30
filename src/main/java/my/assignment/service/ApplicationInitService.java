package my.assignment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.assignment.model.Developer;
import my.assignment.model.Story;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitService implements ApplicationListener<ApplicationReadyEvent> {

    private final DeveloperService developerService;
    private final StoryService storyService;

    @Value("${init-environment:false}")
    private boolean initEnvironment;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        initData();
    }

    public void initData() {
        if (initEnvironment) {
            log.info("Data initialization starting...");
            doInitData();
            log.info("Data initialization has completed successfully!");
        }
    }

    private void doInitData() {
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
