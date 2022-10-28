package com.approval.approvalviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApprovalviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApprovalviewApplication.class, args);
	}

}
