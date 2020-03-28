package com.aamnapm.counting.service;

import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.model.Profile;
import com.aamnapm.counting.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Profile profileSaved = null;
        Optional<Profile> byNationalCode = profileRepository.findByName(profile.getNationalCode());

        if (byNationalCode.isPresent()) {
            System.out.printf("User is available");
        } else {
            profileSaved = profileRepository.save(profile);
        }

        ResponseApi responseApi = new ResponseApi();
        responseApi.setMessage("User save success.");
        responseApi.setResult(profileSaved.getId());
        responseApi.setStatus(true);

        return responseApi;
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
        } else {
            System.out.printf("User is not available");
        }
    }

    @Override
    public void delete(UUID uuid) {
        Optional<Profile> byId = profileRepository.findById(uuid);
        if (byId.isPresent()) {
            profileRepository.deleteById(uuid);
        } else {
            System.out.printf("User is not available");
        }
    }
}
