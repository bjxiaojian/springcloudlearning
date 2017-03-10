package com.itmuch.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author bjxiaojian
 * @Date 2017/3/10
 * @Description	注意:TestConfiguration不能放在与boot启动类包与其子包中，才能生效。
 *              当放在boot启动类包与其子包中时，类会在启动过程中被加载；不放在此范围的包中时，在接口调用时该类才被加载。
 *              如果需要将此类放在boot启动类包与其子包中，则需要在启动扫描过程中，将该类忽略，不进行扫描。
 */

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration
{
  //  @Autowired
  //  IClientConfig config;

  @Bean
  public IRule ribbonRule() {

    return new RandomRule();
  }
}
