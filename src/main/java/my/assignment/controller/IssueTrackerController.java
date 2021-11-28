package my.assignment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import my.assignment.model.Bug;
import my.assignment.model.Developer;
import my.assignment.model.Story;
import my.assignment.service.IssueTrackerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@AllArgsConstructor
@NoArgsConstructor
@Path("/issue")
@Api(value = "Issue Tracker REST API")
public class IssueTrackerController {

    @Autowired
    private IssueTrackerService issueTrackerService;

    @GET
    @Path("/plan")
    @ApiOperation(value = "Calculate a plan")
    public void calculate() {
        issueTrackerService.calculatePlan();
    }

    @POST
    @Path("/bug")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create or update a bug")
    public void createOrUpdateEntry(Bug bug) {
        issueTrackerService.createOrUpdateBug(bug);
    }

    @DELETE
    @Path("/bug/{id}")
    @ApiOperation(value = "Delete a bug")
    public void deleteBug(@PathParam("id") String id) {
        issueTrackerService.deleteBug(id);
    }

    @POST
    @Path("/story")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create or update a story")
    public Story createOrUpdateStory(Story story) {
        return issueTrackerService.createOrUpdateStory(story);
    }

    @DELETE
    @Path("/story/{id}")
    @ApiOperation(value = "Delete a story")
    public void deleteStory(@PathParam("id") String id) {
        issueTrackerService.deleteStory(id);
    }

    @POST
    @Path("/developer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create or update a story")
    public Developer createOrUpdateDeveloper(Developer developer) {
        return issueTrackerService.createOrUpdateDeveloper(developer);
    }

    @DELETE
    @Path("/developer/{id}")
    @ApiOperation(value = "Delete a developer")
    public void delete(@PathParam("id") String id) {
        issueTrackerService.deleteDeveloper(id);
    }
}
