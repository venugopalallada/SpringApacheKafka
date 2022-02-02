package example.kafka.spring.producer;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
@Log4j2
public class ProducerApplication {

    static final String[] fileLocations = {"data/cm20JAN2022bhav.csv", "data/cm21JAN2022bhav.csv"};
    static final String topic = "events-topic";

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(SpringKafkaProducerService springKafkaProducerService) {
        return args -> {
            log.info("Start processing");
            int counter = 0;

            for(int i = 0; i < 100; i++) {
                springKafkaProducerService.sendMessage(topic, counter, "Message-"+i);
                counter++;
            }
            log.info("Finished sending "+counter+" messages");

            /*for(String fileLocation : fileLocations) {
                File file = new File(fileLocation);
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        springKafkaProducerService.sendMessage(topic, counter, line);
                        counter++;
                    }
                    log.info("Finished sending "+counter+" messages from "+fileLocation);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }*/
        };
    }

}
