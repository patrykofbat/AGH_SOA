package library.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;


@Stateless
public class Sender {

//    @Inject
//    private JMSContext context;

//    @Resource(mappedName = "java:/JmsXA")
//    private ConnectionFactory cf;
//
//    private Connection connection;
//
//    @Resource(mappedName= "java:jboss/exported/jms/queue/SOA_Test")
//    private static Queue queue;

    public void sendMessage(String txt) {
//        TextMessage msg = context.createTextMessage(message);
//        context.createProducer().send(queue, msg);

//        try {
//
//            connection = cf.createConnection();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            MessageProducer publisher = null;
//
//            publisher = session.createProducer(queue);
//
//            connection.start();
//
//            TextMessage message = session.createTextMessage(txt);
//            publisher.send(message);
//
//
//        }
//        catch (Exception exc) {
//            exc.printStackTrace();
//        }
//        finally {
//
//
//            if (connection != null)   {
//                try {
//                    connection.close();
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
    }
}
