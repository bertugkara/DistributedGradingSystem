package com.distributedstudentgradingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {"com.distributedstudentgradingsystem"})
public class DistributedStudentGradingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedStudentGradingSystemApplication.class, args);
    }

}
