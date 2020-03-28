package com.aamnapm.counting.service;

import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.model.Record;
import com.aamnapm.counting.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    @Override
    public ResponseApi save(Record record) {

        ResponseApi responseApi = new ResponseApi();
        responseApi.setMessage("record save success.");
        responseApi.setResult(recordRepository.save(record).getId());
        responseApi.setStatus(true);

        return responseApi;
    }

    @Override
    public void update(Record record, UUID uuid) {
        Optional<Record> byId = recordRepository.findById(uuid);

        if (byId.isPresent()) {
            Record recordBySearch = byId.get();
            recordBySearch.setPrice(record.getPrice());
            recordBySearch.setTitle(record.getTitle());
            recordBySearch.setType(record.getType());
            recordRepository.save(recordBySearch);
        } else {
            System.out.printf("Record is not available");
        }
    }

    @Override
    public void delete(UUID uuid) {
        Optional<Record> byId = recordRepository.findById(uuid);
        if (byId.isPresent()) {
            recordRepository.deleteById(uuid);
        } else {
            System.out.printf("Record is not available");
        }
    }

    @Override
    public List<Record> getAll() {
        List<Record> all = new ArrayList<>();
        try {
            all = recordRepository.findAll();
        } catch (Exception e) {
            System.out.println("error e " + e.getMessage());
        }
        return all;
    }


    @Override
    public Record get(UUID uuid) {
        Optional<Record> byId = recordRepository.findById(uuid);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            System.out.println("Record not found");
            return null;
        }
    }
}
