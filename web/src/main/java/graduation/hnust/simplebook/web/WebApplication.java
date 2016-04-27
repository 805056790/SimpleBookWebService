/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author  : panxin
 * Date    : 8:20 PM 3/26/16
 */
@SpringBootApplication
@ComponentScan({"graduation.hnust.simplebook.web",
        "graduation.hnust.simplebook.user",
        "graduation.hnust.simplebook.message",
        "graduation.hnust.simplebook.common"})
public class WebApplication {

    /**
     * To start spring boot application
     *
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
