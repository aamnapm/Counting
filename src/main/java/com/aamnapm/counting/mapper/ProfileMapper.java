package com.aamnapm.counting.mapper;

import com.aamnapm.counting.dto.ProfileDTO;
import com.aamnapm.counting.model.Profile;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(target = "age", source = "age")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "family", source = "family")
    @Mapping(target = "nationalCode", source = "nationalCode")
    public Profile convertToProfile(ProfileDTO profileDto);


    @Mapping(target = "age", source = "age")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "family", source = "family")
    @Mapping(target = "nationalCode", source = "nationalCode")
    public ProfileDTO convertToProfileDTO(Profile profile);


    List<ProfileDTO> toProfilesDTO(List<Profile> userList);


}
