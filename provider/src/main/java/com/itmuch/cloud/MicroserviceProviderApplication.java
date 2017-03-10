package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author bjxiaojian
 * @Date 2017/3/10
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient //只支持eureka服务发现
//@EnableDiscoveryClient  //支持其他的服务发现组件 如:eureka,zk等
public class MicroserviceProviderApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MicroserviceProviderApplication.class, args);
	}
}
