package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author bjxiaojian
 * @Date 2017/3/10
 * @Description
 */
@RestController
public class MovieController
{
  @Autowired
  private RestTemplate restTemplate;

  @Value("${user.userServicePath}")
  private String userServicePath;
  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    //硬编码形式调用  http://localhost:7900/simple/
//    return this.restTemplate.getForObject(this.userServicePath + id, User.class);
//    使用provider的application name进行调用，避免url硬编码。  VIP virtual IP
    return this.restTemplate.getForObject("http://microservice-provider/user/" + id, User.class);
  }

//    例如:为microservice-provider这个微服务配置TestConfiguration(boot启动类中)，
//         则此微服务的负载均衡采用TestConfiguration中配置的随机规则。
//         调用其他微服务时采用全局的负载均衡规则。
  @GetMapping("/test")
  public String test() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider");
    System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

    ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider2");
    System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());

    return "1";
  }
}
