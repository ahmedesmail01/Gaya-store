package com.gaya_ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config,
            CorsRegistry cors) {

        HttpMethod[] disabledMethods = {
                HttpMethod.PUT,
                HttpMethod.POST,
                HttpMethod.DELETE
        };

        config.getExposureConfiguration()
                .withCollectionExposure(
                        (metadata, methods) -> methods.disable(disabledMethods))
                .withItemExposure(
                        (metadata, methods) -> methods.disable(disabledMethods))
                .withAssociationExposure(
                        (metadata, methods) -> methods.disable(disabledMethods));
    }
}