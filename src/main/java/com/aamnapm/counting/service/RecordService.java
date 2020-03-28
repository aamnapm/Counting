package com.aamnapm.counting.service;


import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.model.Record;

import java.util.List;
import java.util.UUID;

public interface RecordService {

    ResponseApi save(Record record);

    void update(Record record, UUID uuid);

    void delete(UUID uuid);

    List<Record> getAll();

    Record get(UUID uuid);

}
