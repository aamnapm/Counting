package com.aamnapm.counting.mapper;

import com.aamnapm.counting.dto.ProfileDTO;
import com.aamnapm.counting.model.Profile;
import com.aamnapm.counting.model.Record;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(target = "id", source = "uuid")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "family", source = "family")
    @Mapping(target = "nationalCode", source = "nationalCode")
    Profile convertToProfile(ProfileDTO profileDto);


    @Mapping(target = "uuid", source = "id")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "family", source = "family")
//    @Mapping(target = "records", source = "records", qualifiedByName = "convertSetToList")
    @Mapping(target = "nationalCode", source = "nationalCode")
    ProfileDTO convertToProfileDTO(Profile profile);


    List<ProfileDTO> toProfilesDTO(List<Profile> userList);

    @Named("convertSetToList")
    default List<Record> convertSetToList(Set<Record> records) {
        return new ArrayList<Record>(records);
    }

}
