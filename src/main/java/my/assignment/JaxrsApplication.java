package my.assignment;

import io.swagger.jaxrs.config.BeanConfig;
import my.assignment.controller.IssueTrackerResource;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@Component
@ApplicationPath("/api/v1")
public class JaxrsApplication extends Application {

    public JaxrsApplication(){
        configureSwagger();
    }

    private void configureSwagger() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setSchemes(new String[] { "http", "https" });
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("my.assignment");
        beanConfig.setTitle("Issue Tracker");
        beanConfig.setDescription("Issue tracker");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(IssueTrackerResource.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }
}
