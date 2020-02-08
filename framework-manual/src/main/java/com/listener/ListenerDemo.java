package com.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 2020/2/7
 */
public class ListenerDemo {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 添加监听器
        //context.addApplicationListener(new MyApplicationListener());

        // 注册Configuration 方式
        context.register(MyApplicationListener.class);

        context.refresh();


        context.publishEvent(new MyApplicationEvent("hello world"));

    }


    @Component
    public static class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.println("event source:" + event.getSource());
        }
    }

    public static  class MyApplicationEvent extends ApplicationEvent {
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
}
