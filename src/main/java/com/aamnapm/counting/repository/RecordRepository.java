package com.aamnapm.counting.repository;

import com.aamnapm.counting.model.Record;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Transactional
public interface RecordRepository extends PagingAndSortingRepository<Record, UUID>, JpaSpecificationExecutor<Record> {

    Optional<Record> findById(UUID uuid);

    List<Record> findAll();

    void deleteById(UUID uuid);

}
