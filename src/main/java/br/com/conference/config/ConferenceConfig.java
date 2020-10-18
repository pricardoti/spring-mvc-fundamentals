package br.com.conference.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

@Configuration
public class ConferenceConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public ConferenceConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**")
                .addResourceLocations("/WEB-INF/pdf/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    private final LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);

        // TODO: Para adicionar locale do Brasil como padrão descomentar a linha abaixo.
        // sessionLocaleResolver.setDefaultLocale(new Locale("pt", "BR"));

        return sessionLocaleResolver;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setOrder(0);

        // TODO: usar o valor "1" quando estiver com a configuração do thymeleaf ativa.
        // internalResourceViewResolver.setOrder(1);

        return internalResourceViewResolver;
    }

//    @Bean
//    public ViewResolver thymeleafResolver() {
//        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
//        thymeleafViewResolver.setTemplateEngine(thymeleafTemplateEngine());
//        thymeleafViewResolver.setOrder(0);
//        return thymeleafViewResolver;
//    }

//    private final SpringTemplateEngine thymeleafTemplateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }

//    private final SpringResourceTemplateResolver thymeleafTemplateResolver() {
//        SpringResourceTemplateResolver resourceTemplateResolver = new SpringResourceTemplateResolver();
//        resourceTemplateResolver.setApplicationContext(applicationContext);
//        resourceTemplateResolver.setPrefix("/WEB-INF/views/");
//        resourceTemplateResolver.setSuffix(".html");
//        return resourceTemplateResolver;
//    }

}
