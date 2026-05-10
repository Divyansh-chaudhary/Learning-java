package com.example.demo.service;

import com.example.demo.model.JobPost;
import com.example.demo.repo.JobPostRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {
    JobPostRepo jobRepo;

    public JobPostRepo getJobRepo() {
        return jobRepo;
    }

    @Autowired
    public void setJobRepo(JobPostRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public void saveJob(JobPost job) {
        jobRepo.saveJob(job);
    }
}
