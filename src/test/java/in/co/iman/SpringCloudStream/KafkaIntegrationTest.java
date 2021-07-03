package in.co.iman.SpringCloudStream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KafkaIntegrationTest {

    private static final String JSON_PAYLOAD = "{\"organizationId\":\"123\",\"accountId\":\"321\"}";
    private static final String ACCT_ID = "321";
    private static final String ORG_ID = "123";

    @Autowired
    ProducerKafka producerKafka;

    @Autowired
    OutputChannelKafkaBinding outputChannelKafkaBinding;

    @Autowired
    private MessageCollector messageCollector;


    @Test
    public void testSendEvent() {
        Event testEvent = Event.builder().organizationId(ORG_ID).accountId(ACCT_ID).build();

        producerKafka.publishToKafka(testEvent);
        Message<Event> received = (Message<Event>) messageCollector.forChannel(outputChannelKafkaBinding.channel()).poll();

        assertNotNull(received.getPayload());
        assertEquals(JSON_PAYLOAD, received.getPayload());
        assertEquals("application/json", received.getHeaders().get("contentType").toString());
    }

}









/*@Testcontainers
public class KafkaIntegrationTest {

    private static final String TOPIC = "containers";

    @Container
    public KafkaContainer kafka = new KafkaContainer("5.5.0");

    @Test
    public void testSendAndConsume() throws Exception {
        kafka.getBootstrapServers();
    }

}*/
