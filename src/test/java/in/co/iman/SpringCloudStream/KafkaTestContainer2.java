package in.co.iman.SpringCloudStream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTestContainer2 {

    private static final DockerImageName KAFKA_TEST_IMAGE = DockerImageName.parse("confluentinc/cp-kafka:5.5.0");

    private static KafkaContainer kafkaTestContainer = new KafkaContainer(KAFKA_TEST_IMAGE);

    @Autowired
    ProducerKafka producerKafka;

    @Autowired
    OutputChannelKafkaBinding outputChannelKafkaBinding;

    @BeforeAll
    public static void startCassandraContainer() {
        kafkaTestContainer.withReuse(true);
        kafkaTestContainer.start();

    }

    @BeforeEach
    public void start() {
        kafkaTestContainer.start();
    }

    @AfterEach
    public void purge() {
        kafkaTestContainer.close();
    }

    @Test
    public void testSendAndConsume() throws Exception {
        kafkaTestContainer.getBootstrapServers();
    }

    @Test
    public void testSendEvent() throws Exception {
        Event testEvent = Event.builder().accountId("123").accountId("321").build();
        String result = producerKafka.publishToKafka(testEvent);
        assertEquals("Message sent", result);
     //   verify(outputChannelKafkaBinding).channel().send(MessageBuilder.withPayload(testEvent).build());
       // verify(outputChannelKafkaBinding).channel().send(any());
    }
}
