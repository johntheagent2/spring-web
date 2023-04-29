package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Account;
import com.designpatternfinal.springweb.model.Subscribers;
import com.designpatternfinal.springweb.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {
    @Autowired
    SubscriberRepository subscriberRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    MailService mailService;

    public void subscriberHandler(){
        Account account = accountService.getCurrentAccount();
        if(!account.isSubscribed()){
            addSubscriber(account);
        }else if(account.isSubscribed()){
            removeSubscriber(account);
        }
    }

    public void addSubscriber(Account account){
        account.setSubscribed(true);

        Subscribers subscribers = new Subscribers();
        subscribers.setEmail(account.getEmail());

        subscriberRepository.save(subscribers);
    }
    public void removeSubscriber(Account account){
        account.setSubscribed(false);
        Subscribers subscribers = subscriberRepository.getSubscribersByEmail(account.getEmail());
        subscriberRepository.delete(subscribers);
    }
    public Iterable<Subscribers> getAllSubscriberEmail(){
        return subscriberRepository.findAll();
    }

    public void notifySubscribers(String updateText){
        Iterable<Subscribers> subscribers = getAllSubscriberEmail();
        for (Subscribers subscriber : subscribers) {
            mailService.update(subscriber, updateText);
        }
    }
}
