package com.aamnapm.counting.tasks;

import com.aamnapm.counting.feign.AvinyApi;
import com.aamnapm.counting.model.PrayTime;
import com.aamnapm.counting.service.PrayTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class ScheduledLog {

    private static final Logger log = LoggerFactory.getLogger(ScheduledLog.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    AvinyApi avinyApi;
    @Autowired
    PrayTimeService prayTimeService;

    //    @Scheduled(fixedRate = 216000000)//day
    @Scheduled(fixedRate = 6000)//min
    public void reportCurrentTime() {
        PrayTime prayTime = avinyApi.getPrayTime();

        prayTimeService.save(prayTime);
    }
}