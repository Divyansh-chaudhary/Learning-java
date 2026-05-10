package com.example.demo;

import com.example.demo.model.JobPost;
import com.example.demo.service.JobPostService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    JobPostService jobPostService;

    public JobPostService getJobPostService() {
        return jobPostService;
    }

    @Autowired
    public void setJobPostService(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @RequestMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @RequestMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model m) {
        List<JobPost> jobs = jobPostService.getAllJobs();
        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }

    @PostMapping("handleForm")
    public String success(JobPost jobPost) {
        jobPostService.saveJob(jobPost);
        return "success";
    }
}
