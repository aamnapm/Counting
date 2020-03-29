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
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/profile")
public class ProfileController {

    private ProfileMapper profileMapper;
    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileMapper profileMapper, ProfileService profileService) {
        this.profileMapper = profileMapper;
        this.profileService = profileService;
    }

    @GetMapping
    ResponseEntity<List<ProfileDTO>> getAll() {
        List<ProfileDTO> profileDTOList = profileMapper.toProfilesDTO(profileService.getAll());
        return ResponseEntity.status(HttpURLConnection.HTTP_CREATED).body(profileDTOList);
    }

    @GetMapping("/{id}")
    ResponseEntity<ProfileDTO> getByID(@PathVariable("id") UUID uuid) {
        ProfileDTO profileDTOList = profileMapper.convertToProfileDTO(profileService.get(uuid));
        return ResponseEntity.status(HttpURLConnection.HTTP_CREATED).body(profileDTOList);
    }

    @PostMapping
    ResponseEntity<ResponseApi> save(@RequestBody @Valid ProfileDTO profileDTO) {
        ResponseApi responseApi = profileService.save(profileMapper.convertToProfile(profileDTO));
        return ResponseEntity.status(HttpURLConnection.HTTP_CREATED).body(responseApi);
    }

    @PutMapping("/{id}")
    ResponseEntity update(@RequestBody @Valid ProfileDTO profileDTO, @PathVariable("id") UUID uuid) {
        profileService.update(profileMapper.convertToProfile(profileDTO), uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") UUID uuid) {
        profileService.delete(uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

}
