package com.aamnapm.counting.feign;

import com.aamnapm.counting.model.PrayTime;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "feign", url = "https://prayer.aviny.com/")
public interface AvinyApi {

    @Headers("Content-Type: application/json")
    @GetMapping(value = "api/prayertimes/1")
    PrayTime getPrayTime();

}
