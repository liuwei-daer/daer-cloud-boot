package com.daer.cloud.system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liuwei
 * @date 2019-11-24
 * 用户统一管理系统
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.daer.cloud"})
@MapperScan(basePackages = "com.daer.cloud.system.biz.mapper")
@SpringBootApplication(scanBasePackages = {"com.daer.cloud"})
public class SystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}

}
