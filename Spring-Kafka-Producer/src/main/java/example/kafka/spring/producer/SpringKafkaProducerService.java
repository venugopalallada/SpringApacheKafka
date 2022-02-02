package example.kafka.spring.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SpringKafkaProducerService {

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;

    public void sendMessage(String topic, Integer key, String value) {
        try {
            Thread.sleep(100);
            //log.info("Producing Message : Key : "+key+", Value : "+value+", Topic : "+topic);
            kafkaTemplate.send(topic, key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
