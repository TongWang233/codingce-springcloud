package cn.com.codingce.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xzMa
 * 启动类
 *
 * Eureka客户端
 */
@SpringBootApplication
@EnableEurekaClient //开启Eureka 在服务启动后, 自动注册到Eureka中
@EnableDiscoveryClient  //服务发现
@EnableSwagger2
//http://localhost:8002/swagger-ui.html
public class DeptProviderSwagger8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderSwagger8002.class, args);
    }
}
