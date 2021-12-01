package my.assignment.configuration;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import my.assignment.entity.BugEntity;
import my.assignment.entity.DeveloperEntity;
import my.assignment.entity.StoryEntity;
import my.assignment.model.*;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class MapperFactoryConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Developer.class, DeveloperEntity.class)
                .byDefault()
                .register();

        mapperFactory.classMap(ShortDeveloper.class, DeveloperEntity.class)
                .byDefault()
                .register();

        mapperFactory.classMap(ShortStory.class, StoryEntity.class)
                .byDefault()
                .register();

        mapperFactory.classMap(ShortBug.class, BugEntity.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Bug.class, BugEntity.class)
                .field("id", "id")
                .field("title", "title")
                .field("description", "description")
                .field("status", "status")
                .field("priority", "priority")
                .field("createdDate", "createdDate")
                .customize(
                        new CustomMapper<>() {
                            @Override
                            public void mapBtoA(BugEntity entity, Bug dto, MappingContext context) {
                                var developer = entity.getDeveloper();
                                if (Objects.nonNull(developer)) {
                                    dto.setDeveloper(Developer.builder()
                                            .name(developer.getName())
                                            .id(developer.getId())
                                            .build());
                                }
                            }

                            @Override
                            public void mapAtoB(Bug dto, BugEntity entity, MappingContext context) {
                                var developer = dto.getDeveloper();
                                if (Objects.nonNull(developer)) {
                                    entity.setDeveloper(DeveloperEntity.builder()
                                            .name(developer.getName())
                                            .id(developer.getId())
                                            .build());
                                }
                            }

                        })
                .register();

        mapperFactory.classMap(Story.class, StoryEntity.class)
                .exclude("developer")
                .byDefault()
                .customize(
                        new CustomMapper<>() {
                            @Override
                            public void mapBtoA(StoryEntity entity, Story dto, MappingContext context) {
                                var developer = entity.getDeveloper();
                                if (Objects.nonNull(developer)) {
                                    dto.setDeveloper(Developer.builder()
                                            .name(developer.getName())
                                            .id(developer.getId())
                                            .build());
                                }
                            }

                            @Override
                            public void mapAtoB(Story dto, StoryEntity entity, MappingContext context) {
                                var developer = dto.getDeveloper();
                                if (Objects.nonNull(developer)) {
                                    entity.setDeveloper(DeveloperEntity.builder()
                                            .name(developer.getName())
                                            .id(developer.getId())
                                            .build());
                                }
                            }
                        })
                .register();
    }
}
