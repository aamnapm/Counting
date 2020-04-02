package com.aamnapm.counting.repository;

import com.aamnapm.counting.model.PrayTime;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PrayTimeRepository extends PagingAndSortingRepository<PrayTime, UUID> {

    Optional<PrayTime> findById(UUID uuid);

    List<PrayTime> findAll();

    void deleteById(UUID uuid);

}
