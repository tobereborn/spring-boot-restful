package com.github.tbr.spring.config;

import com.github.tbr.spring.soundsystem.CDPlayer;
import com.github.tbr.spring.soundsystem.CompactDisc;
import com.github.tbr.spring.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//@ComponentScan(basePackageClasses = {SgtPeppers.class})
public class CDPlayerConfig {
    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    @Primary
    public CDPlayer cd1Player() {
        return new CDPlayer(sgtPeppers());
    }

    @Bean
    public CDPlayer cd2Player(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

}