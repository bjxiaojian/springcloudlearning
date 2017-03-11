package com.itmuch.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author bjxiaojian
 * @Date 2017/3/10
 * @Description
 */
@Configuration
public class FeignLogConfiguration
{
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}
