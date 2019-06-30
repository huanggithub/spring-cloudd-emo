package com.huang.gateway;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@EnableZuulProxy
@SpringBootApplication
@ComponentScan(basePackages = {"com.huang.gateway.filter"})
@EnableSwagger2Doc
public class GatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class,args);
    }
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
        ZuulProperties zuulProperties = new ZuulProperties();
        System.out.println(zuulProperties);
        return zuulProperties;
    }

    /**
     * 配置Swagger
     *
     */
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resource=new ArrayList<>();
            //name可以随便写，location前缀要与zuul配置的path一致。zuul开了token验证,要加上token,否则不用加?token=1
            resource.add(swaggerResource("app-item","/item-service/v2/api-docs?token=1","2.0"));
            resource.add(swaggerResource("app-order","/order-service/v2/api-docs?token=1","2.0"));
            return resource;
        }

        //name可以随便写，location前缀要与zuul配置的path一致
        private SwaggerResource swaggerResource(String name, String location, String version){
            SwaggerResource swaggerResource=new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }
}
