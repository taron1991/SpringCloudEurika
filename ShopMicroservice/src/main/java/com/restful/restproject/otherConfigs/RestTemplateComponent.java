package com.restful.restproject.otherConfigs;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateComponent {


    @LoadBalanced
    public RestTemplate loadBalanced() {
        return new RestTemplate();
    }
}
