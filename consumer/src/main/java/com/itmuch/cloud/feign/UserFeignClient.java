package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import com.itmuch.config.FeignLogConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author bjxiaojian
 * @Date 2017/3/10
 * @Description 在FeignLogConfiguration配置UserFeignClient的日志级别为FULL，
 *              则此feign的调用会打印所有日志信息，包括debug级别的日志
 */
@FeignClient(value = "microservice-provider", configuration = FeignLogConfiguration.class)
public interface UserFeignClient
{
  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable("id") Long id); // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public User postUser(@RequestBody User user);

  // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。可能是没找到相应的注解或使用方法错误。
  @RequestMapping(value = "/get-user", method = RequestMethod.GET)
  public User getUser(User user);
}
