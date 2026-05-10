package com.example.demo.repo;

import com.example.demo.model.JobPost;
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
}
