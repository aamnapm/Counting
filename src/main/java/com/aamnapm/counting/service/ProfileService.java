package com.aamnapm.counting.service;


import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.model.Profile;

import java.util.List;
import java.util.UUID;

public interface ProfileService {

    ResponseApi save(Profile profile);

    void update(Profile profile, UUID uuid);

    void delete(UUID uuid);

    List<Profile> getAll();

    List<Profile> getAll(String name, int age, String family, String nationalCode);

    Profile get(UUID uuid);

    String getReport();

}
