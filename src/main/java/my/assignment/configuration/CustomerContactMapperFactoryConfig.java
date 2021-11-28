package my.assignment.configuration;

import ma.glasnost.orika.MapperFactory;
import my.assignment.entity.BugEntity;
import my.assignment.entity.DeveloperEntity;
import my.assignment.entity.StoryEntity;
import my.assignment.model.Bug;
import my.assignment.model.Developer;
import my.assignment.model.Story;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerContactMapperFactoryConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Bug.class, BugEntity.class)
                .mapNulls(false)
                .byDefault()
                .register();

        mapperFactory.classMap(Story.class, StoryEntity.class)
                .mapNulls(false)
                .byDefault()
                .register();

        mapperFactory.classMap(Developer.class, DeveloperEntity.class)
                .mapNulls(false)
                .byDefault()
                .register();
    }
}
