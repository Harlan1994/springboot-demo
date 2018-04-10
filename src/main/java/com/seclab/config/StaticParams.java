package com.seclab.config;

public class StaticParams {

    public static class Constants{
        // 缓存单个用户数据前缀，为了避免重复key，后面需要加上用户的id和username，例如id=1，username=harlan==>"key:user:info:harlan:1"
        public static final String KEY_USER_INFO_PREFIX = "key:user:info:";
    }

    public static class PathRegex {
        // 首页以及css、js、img等静态资源访问无需权限
//        public static final String ROOT = "/";
//        public static final String INDEX = "/index";
//        public static final String PAGE = "/page/**";
//        public static final String ARCHIVE = "/archives/**";
//        public static final String POST = "/posts/**";
//        public static final String JS = "/js/**";
//        public static final String CSS = "/css/**";
//        public static final String IMG = "/img/**";
//        public static final String LOGIN = "/login";
//        public static final String LOGOUT = "/logout";
//        public static final String WEBJARS = "/webjars/**";
//        public static final String ABOUT = "/about/**";


        /**
         * 以下是可以不用授权访问的内容API
         * 1. 网站内容
         * 2. css/img/js等资源
         */
        public static final String INDEX = "/";
        public static final String QUESTIONS = "/questions/**";
        public static final String RANK = "/rank/**";
        public static final String NEWS = "/news/**";
        public static final String INTRODUCTION = "/introductions/**";
        public static final String LOGIN = "/login";
        public static final String REGISTER = "/register";

        public static final String JS = "/js/**";
        public static final String CSS = "/css/**";
        public static final String IMG = "/img/**";
        public static final String WEBJARS = "/webjars/**";

        /**
         * 需要管理员权限
         */
        public static final String AUTH_ADMIN = "/harlan/**";

        /**
         * 需要用户权限
         */
        public static final String AUTH_USER = "/user/**";
    }

    public static class UserRole {
        // 两种角色
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
        public static final String ROLE_USER = "ROLE_USER";
    }
}
