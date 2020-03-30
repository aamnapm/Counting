package com.aamnapm.counting.service;

import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.exeption.ConflictException;
import com.aamnapm.counting.exeption.NotFoundException;
import com.aamnapm.counting.exeption.RunTimeException;
import com.aamnapm.counting.model.Profile;
import com.aamnapm.counting.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ResponseApi save(Profile profile) {
        Optional<Profile> byNationalCode = profileRepository.findByName(profile.getNationalCode());

        if (byNationalCode.isPresent()) {
            throw new ConflictException("User already exist");
        } else {
            try {
                Profile profileSaved = profileRepository.save(profile);
                ResponseApi responseApi = new ResponseApi();
                responseApi.setMessage("User save success.");
                responseApi.setResult(profileSaved.getId());
                responseApi.setStatus(true);
                return responseApi;
            } catch (Exception e) {
                throw new RunTimeException(e.getMessage());
            }
        }
    }

    @Override
    public void update(Profile profile, UUID uuid) {
        Optional<Profile> byId = profileRepository.findById(uuid);

        if (byId.isPresent()) {
            Profile profileBySearch = byId.get();
            profileBySearch.setAge(profile.getAge());
            profileBySearch.setName(profile.getName());
            profileBySearch.setFamily(profile.getFamily());
            profileBySearch.setNationalCode(profile.getNationalCode());
            profileRepository.save(profileBySearch);
        } else {
            throw new NotFoundException("Profile dose'nt exist");
        }
    }

    @Override
    public void delete(UUID uuid) {
        Optional<Profile> byId = profileRepository.findById(uuid);
        if (byId.isPresent()) {
            try {
                profileRepository.deleteById(uuid);
            } catch (Exception e) {
                throw new RunTimeException(e.getMessage());
            }
        } else {
            throw new NotFoundException("Profile dose'nt exist");
        }
    }

    @Override
    public List<Profile> getAll() {
        try {
            return profileRepository.findAll();
        } catch (Exception e) {
            throw new RunTimeException(e.getMessage());
        }
    }

    @Override
    public Profile get(UUID uuid) {
        Optional<Profile> byId = profileRepository.findById(uuid);

        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new NotFoundException("Profile dose'nt exist");
        }
    }
}
