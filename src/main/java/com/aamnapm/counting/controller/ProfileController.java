package com.aamnapm.counting.controller;

import com.aamnapm.counting.dto.ProfileDTO;
import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.mapper.ProfileMapper;
import com.aamnapm.counting.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.util.UUID;


@RestController("/profile")
public class ProfileController {

    private ProfileMapper profileMapper;
    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileMapper profileMapper, ProfileService profileService) {
        this.profileMapper = profileMapper;
        this.profileService = profileService;
    }

    @PostMapping("/save")
    ResponseEntity<ResponseApi> save(@RequestBody @Valid ProfileDTO profileDTO) {
        ResponseApi responseApi = profileService.save(profileMapper.convertToProfile(profileDTO));
        return ResponseEntity.status(HttpURLConnection.HTTP_CREATED).body(responseApi);
    }

    @PutMapping("/update")
    ResponseEntity<Void> update(ProfileDTO profileDTO, UUID uuid) {
        profileService.update(profileMapper.convertToProfile(profileDTO), uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<Void> delete(UUID uuid) {
        profileService.delete(uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

}
