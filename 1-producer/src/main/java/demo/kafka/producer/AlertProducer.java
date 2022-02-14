package demo.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import demo.kafka.callback.AlertCallback;
import demo.kafka.model.Alert;
import demo.kafka.partitioner.AlertLevelPartitioner;
import demo.kafka.serde.AlertKeySerde;

import java.util.Properties;

public class AlertProducer {

  public static void main(String[] args) {

    Properties kaProperties = new Properties();
    kaProperties.put("bootstrap.servers", "localhost:9092,localhost:9093");
    
    kaProperties.put("key.serializer", AlertKeySerde.class.getName());   //<1>
    kaProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    /** Use {@link AlertLevelPartitioner} to determine partition */
    kaProperties.put("partitioner.class", AlertLevelPartitioner.class.getName());    //<2>

    try (Producer<Alert, String> producer = new KafkaProducer<>(kaProperties)) {
      Alert alert = new Alert(1, "Stage 1", "CRITICAL", "Stage 1 stopped");
      ProducerRecord<Alert, String>
          producerRecord = new ProducerRecord<>("demo_alert", alert, alert.getAlertMessage());   //<3>

      producer.send(producerRecord, new AlertCallback());
    }
  }

}
