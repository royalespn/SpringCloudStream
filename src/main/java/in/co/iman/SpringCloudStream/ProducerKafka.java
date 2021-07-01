package in.co.iman.SpringCloudStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(OutputChannelKafkaBinding.class)
@RestController
@Slf4j
public class ProducerKafka {

    @Autowired
    OutputChannelKafkaBinding outputChannelKafkaBinding;

    @PostMapping("/publishToKafka")
    public String publishToKafka(@RequestBody Event event) {

        outputChannelKafkaBinding.channel()
                .send(MessageBuilder.withPayload(event)
                        .setHeader("type", "Event")
                        .build());
        log.info("Message sent to Kafka");
        return "Message sent";
    }
}
