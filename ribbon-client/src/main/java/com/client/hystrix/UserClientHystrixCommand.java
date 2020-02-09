package com.client.hystrix;

import com.domain.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * 通过代码方式实现 hystrix
 */
public class UserClientHystrixCommand extends HystrixCommand<List<User>> {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private String serviceProviderName;
    private RestTemplate restTemplate ;
    public UserClientHystrixCommand(String serviceProviderName, RestTemplate restTemplate, int timeout) {
        super(HystrixCommandGroupKey.Factory.asKey("user-client"),
                HystrixThreadPoolKey.Factory.asKey("UserClientHystrixCommand-ThreadPool-" + timeout),
                timeout) ;
        this.serviceProviderName = serviceProviderName ;
         this.restTemplate = restTemplate ;

    }
    /**
     * 主逻辑实现
     * @return
     * @throws Exception
     */
    protected List<User> run() throws Exception {
        String url = "http://"+ serviceProviderName  +"/user/findAll" ;
        return restTemplate.getForObject(url, List.class);
    }
    /**
     * fallback 实现
     * @return
     */
    @Override
    protected List<User> getFallback() {
        logger.info("user client hystrix command execute fallback");
        return Collections.emptyList();
    }
}
