package com.client.controller;

import com.client.hystrix.UserClientHystrixCommand;
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

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * 2020/1/31
 */


@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${service-provider.name}")
    private String serviceProviderName;

    @Autowired
    private RestTemplate restTemplate ;

    /**
     * 负载均衡客户端
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/user/save")
    public String saveUser() {
        final User user = new User();
        user.setId(1);
        user.setName("张三");

        Boolean flag = false;
        // 选择指定的serviceId
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceProviderName);
        try {
            flag = loadBalancerClient.execute(serviceProviderName, serviceInstance,
                    new LoadBalancerRequest<Boolean>() {
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

    /**
     *
     * @return
     */
    @RequestMapping("/user/list")
    public List<User> findAllUser(){
        //String url = "http://"+ serviceProviderName  +"/service/findAll" ;
        //return restTemplate.getForObject(url, List.class);
        // 使用 hystrix command
        UserClientHystrixCommand command = new UserClientHystrixCommand(serviceProviderName, restTemplate);
        return command.execute();
    }
}
