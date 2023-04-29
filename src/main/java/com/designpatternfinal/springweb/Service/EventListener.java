package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Subscribers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface EventListener {
    void update(Subscribers subscriber, String updateText);
}
