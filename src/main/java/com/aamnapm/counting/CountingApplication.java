package com.aamnapm.counting;


import com.aamnapm.counting.feign.AvinyApi;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAdminServer
@EnableFeignClients
public class CountingApplication implements CommandLineRunner {

    @Autowired
    AvinyApi avinyApi;

    public static void main(String[] args) {
        SpringApplication.run(CountingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        List<PrayTime> prayTime = avinyApi.getPrayTime();
//
//        System.out.println("==> " + prayTime);

    }
}
