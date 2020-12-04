package com.daer.cloud.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liuwei
 * @date 2019-11-24
 * oauth2.0认证授权中心
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.daer.cloud.system.api.feign"})
@SpringBootApplication(scanBasePackages = "com.daer.cloud")
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
}
