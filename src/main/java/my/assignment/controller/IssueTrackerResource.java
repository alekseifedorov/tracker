package my.assignment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.assignment.model.*;
import my.assignment.service.BugService;
import my.assignment.service.DeveloperService;
import my.assignment.service.IssueTrackerService;
import my.assignment.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Component
@Path("/issue-tracker")
@Api(value = "Issue Tracker REST API")
public class IssueTrackerResource {

    @Autowired
    private IssueTrackerService issueTrackerService;

    @Autowired
    private BugService bugService;

    @Autowired
    private StoryService storyService;

    @Autowired
    private DeveloperService developerService;

    @GET
    @Path("/plan")
    @ApiOperation(value = "Calculate a plan")
    @Produces(MediaType.APPLICATION_JSON)
    public Plan calculate() {
        return issueTrackerService.calculatePlan();
    }

    @POST
    @Path("/bug")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create or update a bug")
    public Bug createOrUpdateEntry(Bug bug) {
        return bugService.createOrUpdateBug(bug);
    }

    @DELETE
    @Path("/bug/{id}")
    @ApiOperation(value = "Delete a bug")
    public void deleteBug(@PathParam("id") UUID id) {
        bugService.deleteBug(id);
    }

    @GET
    @Path("/bug")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "List all existing bugs")
    public List<Bug> findAllBugs() {
        return bugService.getAll();
    }

    @POST
    @Path("/story")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create or update a story")
    public Story createOrUpdateStory(Story story) {
        return storyService.createOrUpdateStory(story);
    }

    @DELETE
    @Path("/story/{id}")
    @ApiOperation(value = "Delete a story")
    public void deleteStory(@PathParam("id") UUID id) {
        storyService.deleteStory(id);
    }

    @GET
    @Path("/story")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "List all existing stories")
    public List<Story> findAllStories() {
        return storyService.getAll();
    }

    @POST
    @Path("/developer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create or update a developer")
    public Developer createOrUpdateDeveloper(Developer developer) {
        return developerService.createOrUpdateDeveloper(developer);
    }

    @DELETE
    @Path("/developer/{id}")
    @ApiOperation(value = "Delete a developer")
    public void delete(@PathParam("id") UUID id) {
        developerService.deleteDeveloper(id);
    }

    @GET
    @Path("/developer")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "List all existing developers")
    public List<ShortDeveloper> findAllDevelopers() {
        return developerService.getAll();
    }

    @GET
    @Path("/developer/{developerId}/bug/{bugId}")
    @ApiOperation(value = "Assign a developer to a bug")
    public void assignBug(@PathParam("developerId") UUID developerId, @PathParam("bugId") UUID bugId) {
        developerService.assignToBug(developerId, bugId);
    }
}
