package com.approval.approvalcreation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApprovalcreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApprovalcreationApplication.class, args);
	}

}
