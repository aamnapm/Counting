package com.aamnapm.counting.service;


import com.aamnapm.counting.model.PrayTime;

import java.util.List;
import java.util.UUID;

public interface PrayTimeService {

    void save(PrayTime prayTime);

    void delete(UUID uuid);

    List<PrayTime> getAll();

    PrayTime get(UUID uuid);

}
