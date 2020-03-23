package com.aamnapm.counting.mapper;

import com.aamnapm.counting.dto.ProfileDTO;
import com.aamnapm.counting.model.Profile;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-23T23:31:33+0430",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public Profile convertToProfile(ProfileDTO profileDto) {
        if ( profileDto == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setName( profileDto.getName() );
        profile.setNationalCode( profileDto.getNationalCode() );
        profile.setFamily( profileDto.getFamily() );
        profile.setAge( profileDto.getAge() );

        return profile;
    }

    @Override
    public ProfileDTO convertToProfileDTO(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setName( profile.getName() );
        profileDTO.setNationalCode( profile.getNationalCode() );
        profileDTO.setFamily( profile.getFamily() );
        profileDTO.setAge( profile.getAge() );

        return profileDTO;
    }
}
