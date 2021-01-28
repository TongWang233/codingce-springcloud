package cn.com.codingce;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import lombok.extern.slf4j.Slf4j;
/**
 * 实现命令行接口，从命令行读取参数发送
 * @author Administrator
 *
 */
@SpringBootApplication
@Slf4j
public class MyTest {
    /**
     * kafka消费
     * @param cr
     * @throws Exception
     */
    @KafkaListener(topics = "test1")
    public void listen(ConsumerRecord<String, String> cr) throws Exception {
        log.info("我是消费者:{}:{}", cr.key(), cr.value());
        //latch.countDown();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyTest.class, args).close();
    }
}
