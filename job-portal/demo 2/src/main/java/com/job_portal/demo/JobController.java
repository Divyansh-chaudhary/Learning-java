package com.job_portal.demo;

import com.job_portal.demo.model.JobPost;
import com.job_portal.demo.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JobController {
    @Autowired
    JobPostService jobPostService;

    @GetMapping("getAllJobs")
    public List<JobPost> getAllJobs() {
        return jobPostService.getAllJobs();
    }

    @GetMapping("getJob/{jobPostId}")
    public JobPost getJob(@PathVariable("jobPostId") int jobPostId) {
        return jobPostService.getJob(jobPostId);
    }

    @PostMapping("addJob")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobPostService.saveJob(jobPost);
        return jobPostService.getJob(jobPost.getPostId());
    }

    @PutMapping("updateJobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobPostService.updateJob(jobPost);
        return jobPostService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("deleteJob/{jobPostId}")
    public String updateJob(@PathVariable("jobPostId") int jobPostId) {
        jobPostService.deleteJob(jobPostId);
        return "deleted";
    }

}
