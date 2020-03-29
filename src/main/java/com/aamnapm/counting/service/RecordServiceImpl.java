package com.aamnapm.counting.service;

import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.model.Profile;
import com.aamnapm.counting.model.Record;
import com.aamnapm.counting.repository.ProfileRepository;
import com.aamnapm.counting.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecordServiceImpl implements RecordService {

    private ProfileRepository profileRepository;
    private RecordRepository recordRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository, ProfileRepository profileRepository) {
        this.recordRepository = recordRepository;
        this.profileRepository = profileRepository;
    }


    @Override
    public ResponseApi save(Record record, UUID profileId) {

        Record save = null;
        ResponseApi responseApi = null;

        Optional<Profile> byId = profileRepository.findById(profileId);
        if (byId.isPresent()) {
            try {
                record.setProfile(byId.get());
                save = recordRepository.save(record);
                responseApi = new ResponseApi();
                responseApi.setMessage("record save success.");
                responseApi.setResult(save.getId());
                responseApi.setStatus(true);
            } catch (Exception e) {
                responseApi = new ResponseApi();
                responseApi.setMessage("record not save has error.");
                responseApi.setResult(null);
                responseApi.setStatus(true);
                System.out.println("e ==> " + e.getMessage());
            }

        } else {
            System.out.println("profile is not exist");
        }

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

    @Override
    public Set<Record> getRecords(UUID uuid) {

        Set<Record> records = null;
        Optional<Profile> profile = profileRepository.findById(uuid);

        if (profile.isPresent()) {
            try {
                records = profile.get().getRecords();
            } catch (Exception e) {
                System.out.println("e ==> " + e);
            }

        } else {
            System.out.println("profile dos not exist");
        }

        return records;
    }
}
