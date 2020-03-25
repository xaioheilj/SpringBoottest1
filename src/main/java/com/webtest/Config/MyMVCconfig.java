package com.webtest.Config;


import com.webtest.component.LoginHandleInterceptor;
import com.webtest.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;


//@EnableWebMvc //全面接管SpringMVC
@Configuration
//使用WebMvcConfigurer扩展SpringMVC的功能,所有的WebMvcConfigurer都会一起起作用
public class MyMVCconfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/felix请求，到达firstPage页面
        registry.addViewController("/felix").setViewName("firstPage");
    }


        @Bean // 将组建注册在容器中
    public WebMvcConfigurer wbc(){

                //引入静态资源文件，使访问路径直接访问到login页面
                WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
                    @Override
                    public void addViewControllers(ViewControllerRegistry registry) {
                        registry.addViewController("/").setViewName("login");
                        registry.addViewController("/login").setViewName("login");
                        registry.addViewController("/main").setViewName("dashboard");
                    }

                    //注册拦截器
                    @Override
                    public void addInterceptors(InterceptorRegistry registry) {
                        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/","/user/login","/asserts/**","/webjars/**");
                        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/","/user/login","/asserts/**","/webjars/**");
                    }


                    //配置访问静态资源,放行静态资源
//                    @Override
//                    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
////        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login.html","/user/login","/asserts/**","/webjars/**");
//                        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//                        //webjar文件
//                        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
//                    }

                };
                return webMvcConfigurer;
    }






    @Bean
    public LocaleResolver localeResolver(){
       return new MyLocaleResolver();
    }
}
