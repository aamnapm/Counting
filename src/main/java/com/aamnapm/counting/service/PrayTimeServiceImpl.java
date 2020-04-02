package com.aamnapm.counting.service;

import com.aamnapm.counting.exeption.NotFoundException;
import com.aamnapm.counting.exeption.RunTimeException;
import com.aamnapm.counting.model.PrayTime;
import com.aamnapm.counting.repository.PrayTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrayTimeServiceImpl implements PrayTimeService {

    private PrayTimeRepository prayTimeRepository;

    @Autowired
    public PrayTimeServiceImpl(PrayTimeRepository prayTimeRepository) {
        this.prayTimeRepository = prayTimeRepository;
    }

    @Override
    public void save(PrayTime prayTime) {
        try {
            prayTimeRepository.save(prayTime);
        } catch (Exception e) {
            System.out.println("==> " + e.getMessage());
        }
    }

    @Override
    public void delete(UUID uuid) {
        try {
            Optional<PrayTime> byId = prayTimeRepository.findById(uuid);
            if (byId.isPresent()) {
                prayTimeRepository.delete(byId.get());
            } else {
                throw new NotFoundException("object not found");
            }
        } catch (Exception e) {
            throw new RunTimeException(e.getMessage());
        }
    }

    @Override
    public List<PrayTime> getAll() {
        try {
            return prayTimeRepository.findAll();
        } catch (Exception e) {
            throw new RunTimeException(e.getMessage());
        }
    }

    @Override
    public PrayTime get(UUID uuid) {
        try {
            Optional<PrayTime> byId = prayTimeRepository.findById(uuid);
            if (byId.isPresent()) {
                return byId.get();
            } else {
                throw new NotFoundException("object not found");
            }
        } catch (Exception e) {
            throw new RunTimeException(e.getMessage());
        }
    }
}