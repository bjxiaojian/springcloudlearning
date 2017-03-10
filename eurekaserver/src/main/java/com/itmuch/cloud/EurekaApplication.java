package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author bjxiaojian
 * @Date 2017/3/10
 * @Description
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication
{
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
  }
}
