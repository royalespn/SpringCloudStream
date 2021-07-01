package in.co.iman.SpringCloudStream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputChannelKafkaBinding {

    String NAME = "OutputChannelKafka";

    @Output(NAME)
    MessageChannel channel();
}
