package com.github.tbr.spring.plugin.first.config;

import com.github.tbr.spring.pulgin.first.api.PluginFirstService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnBean({PostRepository.class})
public class PluginFirstConfiguration {

    @Bean
    public PluginFirstService pluginFirstService() {
        return new PluginFirstService();
    }
}
