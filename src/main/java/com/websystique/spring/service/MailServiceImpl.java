package com.websystique.spring.service;
 
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
 
import com.websystique.springsecurity.model.ProductOrder;
 
@Service("mailService")
public class MailServiceImpl implements MailService {
 
    @Autowired
    JavaMailSender mailSender;
 
    @Override
    public void sendEmail(Object object) {
 
        ProductOrder order = (ProductOrder) object;
 
        MimeMessagePreparator preparator = getMessagePreparator(order);
 
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
 
    private MimeMessagePreparator getMessagePreparator(final ProductOrder order) {
 
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
 
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("customerserivces@yourshop.com");
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(order.getCustomerInfo().getEmail()));
                mimeMessage.setText("Dear " + order.getCustomerInfo().getFirstName()+ order.getProductName()
                        + ", thank you for placing order. Your order id is " + order.getOrderId() + ".");
                mimeMessage.setSubject("Your order on Demoapp");
            }
        };
        return preparator;
    }
    }
 