package com.aamnapm.counting.service;


import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.model.Record;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RecordService {

    ResponseApi save(Record record, UUID profileId);

    void update(Record record, UUID uuid);

    void delete(UUID uuid);

    List<Record> getAll();

    Record get(UUID uuid);

    Set<Record> getRecords(UUID uuid);

}
