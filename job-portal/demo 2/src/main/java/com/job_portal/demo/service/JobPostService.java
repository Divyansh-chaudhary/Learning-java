package com.job_portal.demo.service;

import com.job_portal.demo.model.JobPost;
import com.job_portal.demo.repo.JobPostRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class JobPostService {
    @Autowired
    JobPostRepo jobRepo;

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public void saveJob(JobPost job) {
        jobRepo.saveJob(job);
    }

    public JobPost getJob(int jobPostId) {
        return jobRepo.getJob(jobPostId);
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.updateJob(jobPost);
    }

    public void deleteJob(int jobPostId) {
        jobRepo.deleteJob(jobPostId);
    }
}
