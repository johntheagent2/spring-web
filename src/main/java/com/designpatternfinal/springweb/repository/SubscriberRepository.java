package com.designpatternfinal.springweb.repository;

import com.designpatternfinal.springweb.model.Subscribers;
import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepository extends CrudRepository<Subscribers, Integer> {
    Subscribers getSubscribersByEmail(String email);
}
