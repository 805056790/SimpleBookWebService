/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.web;

import graduation.hnust.simplebook.user.model.User;
import io.terminus.common.model.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author  : panxin
 * Date    : 8:20 PM 3/26/16
 */
@RestController
@ComponentScan({"graduation.hnust.simplebook"})
@SpringBootApplication
public class ApplicationWebStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationWebStarter.class, args);
    }

}
