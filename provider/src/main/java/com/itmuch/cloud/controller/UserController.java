package com.itmuch.cloud.controller;

import com.google.common.collect.Lists;
import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author bjxiaojian
 * @Date 2017/3/10
 * @Description
 */

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private EurekaClient eurekaClient;

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return this.userRepository.findOne(id);
  }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
      InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER", false);
      return instance.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
      ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
      return localServiceInstance;
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
      return user;
    }

    // 该请求不会成功
    @GetMapping("/get-user")
    public User getUser(User user) {
      return user;
    }

    @GetMapping("list-all")
    public List<User> listAll() {
      ArrayList<User> list = Lists.newArrayList();
      User user = new User(1L, "zhangsan");
      User user2 = new User(2L, "zhangsan");
      User user3 = new User(3L, "zhangsan");
      list.add(user);
      list.add(user2);
      list.add(user3);
      return list;

    }
}
