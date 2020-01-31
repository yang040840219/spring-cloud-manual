package com.client.controller;

import com.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * 2020/1/31
 */


@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${service-provider.name}")
    private String serviceProviderName;

    /**
     * 负载均衡客户端
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/saveUser")
    public String saveUser() {
        User user = new User();
        user.setId(1);
        user.setName("张三");

        Boolean flag = false;
        // 选择指定的serviceId
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceProviderName);
        try {
            flag = loadBalancerClient.execute(serviceProviderName, serviceInstance,
                    new LoadBalancerRequest<Boolean>() {
                        @Override
                        public Boolean apply(ServiceInstance instance) throws Exception {
                            String serviceProviderHost = instance.getHost();
                            int serviceProviderPort = instance.getPort();
                            RestTemplate restTemplate = new RestTemplate();
                            String url = "http://" + serviceProviderHost + ":" + serviceProviderPort + "/service/saveUser";
                            return restTemplate.postForObject(url, user, Boolean.class);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "result:" + flag;
    }
}
