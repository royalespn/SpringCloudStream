package in.co.iman.SpringCloudStream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputChannelRabbitBinding {


    String NAME = "InputChannelRabbit";

    @Input(NAME)
    SubscribableChannel channel();

}
