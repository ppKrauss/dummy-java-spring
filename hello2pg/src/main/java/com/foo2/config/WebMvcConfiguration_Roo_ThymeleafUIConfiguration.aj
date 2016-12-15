// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.foo2.config;

import com.foo2.config.WebMvcConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

privileged aspect WebMvcConfiguration_Roo_ThymeleafUIConfiguration {
    
    declare parents: WebMvcConfiguration implements ApplicationContextAware;
    
    /**
     * TODO Auto-generated attribute documentation
     */
    @Autowired
    public ThymeleafProperties WebMvcConfiguration.thymeleafProperties;
    
    /**
     * TODO Auto-generated attribute documentation
     */
    @Autowired
    public TemplateEngine WebMvcConfiguration.templateEngine;
    
    /**
     * TODO Auto-generated attribute documentation
     */
    public ApplicationContext WebMvcConfiguration.applicationContext;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return ThymeleafViewResolver
     */
    @Bean
    public ThymeleafViewResolver WebMvcConfiguration.javascriptThymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(this.templateEngine);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setContentType("application/javascript");
        resolver.setViewNames(new String[] {"*.js"});
        resolver.setCache(this.thymeleafProperties.isCache());
        return resolver;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return SpringResourceTemplateResolver
     */
    @Bean
    public SpringResourceTemplateResolver WebMvcConfiguration.javascriptTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(this.applicationContext);
        resolver.setPrefix("classpath:/templates/fragments/js/");
        resolver.setTemplateMode(TemplateMode.JAVASCRIPT);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCheckExistence(true);
        resolver.setCacheable(this.thymeleafProperties.isCache());
        return resolver;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param applicationContext
     */
    public void WebMvcConfiguration.setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    
}
