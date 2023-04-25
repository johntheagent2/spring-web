package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Account;
import com.designpatternfinal.springweb.model.Subscribers;
import com.designpatternfinal.springweb.repository.SubcriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {
    @Autowired
    SubcriberRepository subcriberRepository;
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

        subcriberRepository.save(subscribers);
    }
    public void removeSubscriber(Account account){
        account.setSubscribed(false);

        Subscribers subscribers = new Subscribers();
        subscribers.setEmail(account.getEmail());

        subcriberRepository.delete(subscribers);
    }
    public Iterable<Subscribers> getAllSubscriberEmail(){
        return subcriberRepository.findAll();
    }

    public void notifySubscribers(String updateText){
        Iterable<Subscribers> subscribers = getAllSubscriberEmail();
        for (Subscribers subscriber : subscribers) {
            mailService.update(subscriber, updateText);
        }
    }
}
