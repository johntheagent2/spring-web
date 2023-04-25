package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.SMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;
    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;
    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    String OUTGOING_SMS_NUMBER;

    public void sendSMS(SMS sms){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        try{
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber(sms.getReceiver()),
                            new com.twilio.type.PhoneNumber(OUTGOING_SMS_NUMBER),
                            sms.getBody())
                    .create();
            System.out.println(message.getSid());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
