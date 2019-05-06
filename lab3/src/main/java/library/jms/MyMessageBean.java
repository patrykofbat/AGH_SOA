package library.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.LocalBean;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:jms/queue/SOA_test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MyMessageBean implements MessageListener {

    public void onMessage(Message msg) {
        TextMessage txtMsg = null;
        try {
            if (msg instanceof TextMessage) {
                txtMsg = (TextMessage)msg;
                String txt = txtMsg.getText();
                System.out.println("I received:" + txt);
            }
        } catch (JMSException e) {
            System.out.println(e.getErrorCode());
        }
    }
}
