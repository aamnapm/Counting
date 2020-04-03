package com.aamnapm.counting.service;

import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.exeption.ConflictException;
import com.aamnapm.counting.exeption.NotFoundException;
import com.aamnapm.counting.exeption.RunTimeException;
import com.aamnapm.counting.model.Profile;
import com.aamnapm.counting.model.Profile_;
import com.aamnapm.counting.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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
        Optional<Profile> byNationalCode = profileRepository.findByNationalCode(profile.getNationalCode());

        if (!byNationalCode.isPresent()) {
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
        } else {
            throw new ConflictException("User already exist");
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
    public List<Profile> getAll(String name, int age, String family, String nationalCode) {

        List<Predicate> profileList = new ArrayList<>();
        try {
            Specification<Profile> result = (Specification<Profile>) (root, query, criteriaBuilder) -> {
                if (name != null)
                    profileList.add(criteriaBuilder.equal(root.get(Profile_.name), name));
                if (age != -1)
                    profileList.add(criteriaBuilder.equal(root.get(Profile_.age), age));
                if (family != null)
                    profileList.add(criteriaBuilder.equal(root.get(Profile_.family), family));
                if (nationalCode != null)
                    profileList.add(criteriaBuilder.equal(root.get(Profile_.nationalCode), nationalCode));
                return criteriaBuilder.and(profileList.toArray(new Predicate[0]));
            };

            return profileRepository.findAll(result);

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
