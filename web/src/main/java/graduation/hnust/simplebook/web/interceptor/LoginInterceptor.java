///*
// * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
// */
//
//package graduation.hnust.simplebook.web.interceptor;
//
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheLoader;
//import com.google.common.cache.LoadingCache;
//import graduation.hnust.simplebook.user.model.User;
//import graduation.hnust.simplebook.user.service.UserReadService;
//import io.terminus.pampas.common.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.concurrent.TimeUnit;
//
///**
// * Author  : panxin109@gmail.com
// * Date    : 12:23 PM 4/10/16
// */
//public class LoginInterceptor extends HandlerInterceptorAdapter{
//
//    LoadingCache<Long, Response<User>> userCache;
//
//    @Autowired
//    public LoginInterceptor (final UserReadService userReadService) {
//        userCache = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).build(new CacheLoader<Long, Response<User>>() {
//            @Override
//            public Response<User> load(Long userId) throws Exception {
//                return userReadService.findById(userId);
//            }
//        });
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return super.preHandle(request, response, handler);
//    }
//}
