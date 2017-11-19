package com.github.tbr.spring.spi;

import com.github.tbr.spring.dto.Message;

public interface Consumer {

    public void consume(Message message);
}
