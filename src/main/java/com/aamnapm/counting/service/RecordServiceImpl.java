package com.aamnapm.counting.service;

import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.exeption.NotFoundException;
import com.aamnapm.counting.exeption.RunTimeException;
import com.aamnapm.counting.model.Profile;
import com.aamnapm.counting.model.Record;
import com.aamnapm.counting.model.Record_;
import com.aamnapm.counting.repository.ProfileRepository;
import com.aamnapm.counting.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
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

        Optional<Profile> byId = profileRepository.findById(profileId);
        if (byId.isPresent()) {
            try {
                record.setProfile(byId.get());
                Record save = recordRepository.save(record);
                ResponseApi responseApi = new ResponseApi();
                responseApi.setMessage("record save success.");
                responseApi.setResult(save.getId());
                responseApi.setStatus(true);
                return responseApi;
            } catch (Exception e) {
                throw new RunTimeException(e.getMessage());
            }

        } else {
            throw new NotFoundException("Profile dose'nt exist");
        }
    }

    @Override
    public void update(Record record, UUID uuid) {
        Optional<Record> byId = recordRepository.findById(uuid);

        if (byId.isPresent()) {
            try {
                Record recordBySearch = byId.get();
                recordBySearch.setPrice(record.getPrice());
                recordBySearch.setTitle(record.getTitle());
                recordBySearch.setType(record.getType());
                recordRepository.save(recordBySearch);
            } catch (Exception e) {
                throw new RunTimeException(e.getMessage());
            }
        } else {
            throw new NotFoundException("Record dose'nt exist");
        }
    }

    @Override
    public void delete(UUID uuid) {
        Optional<Record> byId = recordRepository.findById(uuid);
        if (byId.isPresent()) {
            try {
                recordRepository.deleteById(uuid);
            } catch (Exception e) {
                throw new RunTimeException(e.getMessage());
            }
        } else {
            throw new NotFoundException("Record dose'nt exist");
        }
    }

    @Override
    public List<Record> getAll() {
        try {
            return recordRepository.findAll();
        } catch (Exception e) {
            throw new RunTimeException(e.getMessage());
        }
    }

    @Override
    public List<Record> getAll(int type, String title, String price) {

        List<Predicate> predicateList = new ArrayList<>();

        try {
            Specification<Record> recordSpecification = (Specification<Record>) (root, query, criteriaBuilder) -> {

                if (type != -1)
                    predicateList.add(criteriaBuilder.equal(root.get(Record_.type), type));
                if (title != null)
                    predicateList.add(criteriaBuilder.equal(root.get(Record_.title), title));
                if (price != null)
                    predicateList.add(criteriaBuilder.equal(root.get(Record_.price), price));
                return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
            };

            return recordRepository.findAll(recordSpecification);
        } catch (Exception e) {
            throw new RunTimeException(e.getMessage());
        }
    }

    @Override
    public Record get(UUID uuid) {
        Optional<Record> byId = recordRepository.findById(uuid);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new NotFoundException("Record dose'nt exist");
        }
    }

    @Override
    public Set<Record> getRecords(UUID uuid) {

        Optional<Profile> profile = profileRepository.findById(uuid);

        if (profile.isPresent()) {
            try {
                return profile.get().getRecords();
            } catch (Exception e) {
                throw new RunTimeException(e.getMessage());
            }
        } else {
            throw new NotFoundException("Profile dose'nt exist");
        }
    }
}
