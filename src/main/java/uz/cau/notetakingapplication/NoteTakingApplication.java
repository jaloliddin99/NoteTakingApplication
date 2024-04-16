package uz.cau.notetakingapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NoteTakingApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteTakingApplication.class, args);
    }

}
