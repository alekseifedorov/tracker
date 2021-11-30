package my.assignment.configuration;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import my.assignment.entity.BugEntity;
import my.assignment.entity.DeveloperEntity;
import my.assignment.entity.StoryEntity;
import my.assignment.model.Bug;
import my.assignment.model.Developer;
import my.assignment.model.Story;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class CustomerContactMapperFactoryConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Bug.class, BugEntity.class)
                .byDefault()
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
                            public void mapAtoB(Story dto, StoryEntity entity,MappingContext context) {
                                var developer = entity.getDeveloper();
                                if (Objects.nonNull(developer)) {
                                    dto.setDeveloper(Developer.builder()
                                            .name(developer.getName())
                                            .id(developer.getId())
                                            .build());
                                }
                            }
                        })
                .register();

        mapperFactory.classMap(Developer.class, DeveloperEntity.class)
                .byDefault()
                .register();
    }
}
