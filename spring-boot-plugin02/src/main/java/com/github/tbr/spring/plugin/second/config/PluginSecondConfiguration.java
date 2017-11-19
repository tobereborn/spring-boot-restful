package com.github.tbr.spring.plugin.second.config;

import com.github.tbr.spring.plugin.second.api.PluginSecondService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnBean({PostRepository.class})
public class PluginSecondConfiguration {

    //    @Bean(name = "plugin2")
    @Bean
    public PluginSecondService pluginSecondService() {
        return new PluginSecondService();
    }
}
