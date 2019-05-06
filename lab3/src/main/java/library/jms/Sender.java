package library.jms;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
public class Sender {

    @Inject
    private JMSContext context;

    @Resource(mappedName = "java:jboss/exported/jms/queue/SOA_Test")
    private static Queue queue;

    public void sendMessage(String message) {
        TextMessage msg = context.createTextMessage(message);
        context.createProducer().send(queue, msg);
    }
}
