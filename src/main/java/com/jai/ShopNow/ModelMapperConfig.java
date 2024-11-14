package com.jai.ShopNow;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// we need these 2 annotations here because these are not inbuilt components like @component, @service
//so even though u are using @autowired u need to use @configuration and @bean to create bean for DI.
@Configuration
// Configuration annotation indicates that the class contains bean.
//Then, Spring will scan this class and register the beans in it, making them available for DI.
public class ModelMapperConfig {
    @Bean
    // Because of Bean annotation return value of this method will be treated as a bean
    // that can be injected elsewhere in the application.
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}