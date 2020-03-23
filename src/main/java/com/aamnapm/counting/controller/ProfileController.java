package com.aamnapm.counting.controller;

import com.aamnapm.counting.dto.ProfileDTO;
import com.aamnapm.counting.mapper.ProfileMapper;
import com.aamnapm.counting.service.ProfileService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.util.UUID;


@RestController("/profile/")
public class ProfileController {

    private ProfileMapper profileMapper;
    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileMapper profileMapper, ProfileService profileService) {
        this.profileMapper = profileMapper;
        this.profileService = profileService;
    }

    @PostMapping
    ResponseEntity<String> save(@Valid ProfileDTO profileDTO) {
        UUID save = profileService.save(profileMapper.convertToProfile(profileDTO));
        return  ResponseEntity.status(HttpURLConnection.HTTP_CREATED).body(save.toString());
    }

    @PutMapping
    ResponseEntity<Void> update(ProfileDTO profileDTO, UUID uuid) {
        profileService.update(profileMapper.convertToProfile(profileDTO), uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity<Void> delete(UUID uuid) {
        profileService.delete(uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

}
