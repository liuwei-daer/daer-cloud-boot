package com.daer.cloud.demo.biz;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liuwei
 * @date 2019-11-24
 * 用户统一管理系统
 */
@EnableFeignClients(basePackages = {"com.daer.cloud.system.api.feign"})
@SpringCloudApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
