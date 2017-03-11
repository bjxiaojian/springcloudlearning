package com.itmuch.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author bjxiaojian
 * @Date 2017/3/11
 * @Description 注意:TestConfiguration不能放在与boot启动类包与其子包中，才能生效。
 */
@Configuration
public class FeignConfiguration
{
  @Bean
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor("root", "123456");
  }
}
