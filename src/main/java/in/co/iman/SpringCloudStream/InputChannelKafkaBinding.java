package in.co.iman.SpringCloudStream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputChannelKafkaBinding {


    String NAME = "InputChannelKafka";

    @Input(NAME)
    SubscribableChannel channel();

}
