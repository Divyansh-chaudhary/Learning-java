package com.job_portal.demo.repo;

import com.job_portal.demo.model.JobPost;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobPostRepo {
    List<JobPost> jobs = new ArrayList<>(
            Arrays.asList(
                    new JobPost(1, 5, "Description", "Java Developer", Arrays.asList("Java", "Spring")),
                    new JobPost(2, 5, "Description", "React Developer", Arrays.asList("React", "Javascript"))
            )
    );

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void saveJob(JobPost job) {
        jobs.add(job);
    }

    public JobPost getJob(int jobPostId) {
        for(JobPost jobPost : jobs) {
            if(jobPost.getPostId() == jobPostId)
                return jobPost;
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for(JobPost job : jobs) {
            if(job.getPostId() == jobPost.getPostId()) {
                job.setPostDesc(jobPost.getPostDesc());
                job.setPostProfile(jobPost.getPostProfile());
                job.setPostTechStack(jobPost.getPostTechStack());
                job.setReqExperience(jobPost.getReqExperience());
            }
        }
    }

    public void deleteJob(int jobPostId) {
        jobs.removeIf(job -> job.getPostId() == jobPostId);
    }
}
