package com.github.tbr.spring.service;

import com.github.tbr.spring.plugin.second.api.PluginSecondService;
import com.github.tbr.spring.pulgin.first.api.PluginFirstService;
import com.github.tbr.spring.spi.Consumer;
import com.github.tbr.spring.spi.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SpiServiceManager {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    List<Producer> producers;

    @Autowired
    List<Consumer> consumers;


//    @Autowired
//    Producer producer1;


//    @Autowired
//    @Qualifier("plugin2")
//    Producer producer2;


    public List<String> showAllProducers() {
        log.info("Get bean:{}", applicationContext.getBean(PluginSecondService.class));
        log.info("Get bean:{}", applicationContext.getBean(PluginFirstService.class));
        log.info("Producer: {}", producers);
//        log.info("plugin1: {}", producer1);
//        log.info("plugin2: {}", producer2);
        return producers.stream().map(Object::toString).collect(Collectors.toList());
    }
}
