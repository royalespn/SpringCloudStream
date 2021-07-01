package in.co.iman.SpringCloudStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(OutputChannelRabbitBinding.class)
@RestController
@Slf4j
public class ProducerRabbit {

    @Autowired
    OutputChannelRabbitBinding outputChannelRabbitBinding;

    @PostMapping("/publishToRabbit")
    public String publishToKafka(@RequestBody Event event) {

        outputChannelRabbitBinding.channel()
                .send(MessageBuilder.withPayload(event)
                        .setHeader("type", "Event")
                        .build());
        log.info("Message sent to rabbit");
        return "Message sent";
    }
}
