package com.onyetech.onyetech.email;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.springframework.stereotype.Service;

@Service
public interface MailService {

 void sendMail(String email, String content, String title) throws MailjetException, MailjetSocketTimeoutException;
 
}
