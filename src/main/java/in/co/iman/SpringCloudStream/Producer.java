package in.co.iman.SpringCloudStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class Producer {

    @Autowired
    Source source;

    @PostMapping("/publish")
    public String publishToKafka(@RequestBody Event event) {

        source.output()
                .send(MessageBuilder.withPayload(event)
                        .setHeader("type", "SipEvent")
                        .build());
        return "Message sent";
    }
}
