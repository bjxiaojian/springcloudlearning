package com.itmuch.cloud.feign;

import com.itmuch.config.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author bjxiaojian
 * @Date 2017/3/11
 * @Description 使用url属性后,name属性也必须设置，但是name的值可以随便设置，调用时以url进行调用
 *              设置FeignConfiguration后，此配置单独对TestFeignClient生效
 *              在配置中设置了eureka认证的用户名和密码，所以url中不用再带上相关信息
 */
@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = FeignConfiguration.class)
public interface TestFeignClient
{
  @RequestMapping(value = "/eureka/apps/{serviceName}")
  public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
