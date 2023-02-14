package com.springboot.lolcommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LolcommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LolcommunityApplication.class, args);

    }

}
