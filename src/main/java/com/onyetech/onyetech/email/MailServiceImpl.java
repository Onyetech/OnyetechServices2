package com.onyetech.onyetech.email;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import static com.onyetech.onyetech.email.API.API_KEY;
import static com.onyetech.onyetech.email.API.API_SECRET;

@Service
public class MailServiceImpl implements MailService{

    public void sendMail(String email, String content, String title) throws MailjetException, MailjetSocketTimeoutException {


            MailjetClient client;
            MailjetRequest request;
            MailjetResponse response;
            client = new MailjetClient(API_KEY, API_SECRET, new ClientOptions("v3.1"));
            request = new MailjetRequest(Emailv31.resource)
                    .property(Emailv31.MESSAGES, new JSONArray()
                            .put(new JSONObject()
                                    .put(Emailv31.Message.FROM, new JSONObject()
                                            .put("Email", "mail.onyetech@gmail.com")
                                            .put("Name", "Onyetech Services"))
                                    .put(Emailv31.Message.TO, new JSONArray()
                                            .put(new JSONObject()
                                                    .put("Email", email)
                                                    .put("Name", "Customer")))
                                    .put(Emailv31.Message.SUBJECT, title)
                                    .put(Emailv31.Message.TEXTPART, "Welcome to Onyetech Services")
                                    .put(Emailv31.Message.HTMLPART, content)
                                    .put(Emailv31.Message.CUSTOMID, "Mail Verification")));
            response = client.post(request);
            System.out.println(response.getStatus());
            System.out.println(response.getData());
        }

    }

