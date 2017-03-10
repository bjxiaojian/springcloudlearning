package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * @Author bjxiaojian
 * @Date 2017/3/10
 * @Description	可以在启动类中使用RobbinClient注解，为某个微服务配置单独的配置，其他微服务则使用全局的配置。
 *
 */
@SpringBootApplication
@EnableEurekaClient
//为单独的微服务设置负载均衡规则
@RibbonClient(name = "microservice-provider", configuration = TestConfiguration.class)
//设置使用了ExcludeFromComponentScan注解的类，在启动过程中不扫描
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class MicroserviceConsumerApplication
{
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args)
	{
		SpringApplication.run(MicroserviceConsumerApplication.class, args);
	}
}
