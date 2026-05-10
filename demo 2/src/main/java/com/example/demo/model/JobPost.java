package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {
    private int postId;
    private int reqExperience;
    private String postDesc;
    private String postProfile;
    private List<String> postTechStack;
}
