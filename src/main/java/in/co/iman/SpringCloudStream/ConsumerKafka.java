package in.co.iman.SpringCloudStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableBinding(InputChannelKafkaBinding.class)
public class ConsumerKafka {

    @StreamListener(InputChannelKafkaBinding.NAME)
    public void consume(Event event){
        log.info("message on kafka channel:" + event.getOrganizationId());
    }
}
