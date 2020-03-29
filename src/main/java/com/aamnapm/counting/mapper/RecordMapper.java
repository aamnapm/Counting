package com.aamnapm.counting.mapper;

import com.aamnapm.counting.dto.RecordDTO;
import com.aamnapm.counting.model.Profile;
import com.aamnapm.counting.model.Record;
import com.aamnapm.counting.model.WithdrawDeposit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface RecordMapper {

    @Mapping(target = "id", source = "uuid")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
//    @Mapping(target = "profile", source = "profileId", qualifiedByName = "")
    @Mapping(target = "type", source = "type", qualifiedByName = "convertIntToType")
    Record convertToRecord(RecordDTO recordDTO);


    @Mapping(target = "uuid", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "profileId", source = "profile", qualifiedByName = "convertProfileToProfileId")
    @Mapping(target = "type", source = "type", qualifiedByName = "convertTypeToInt")
    RecordDTO convertToRecordDTO(Record record);


    List<RecordDTO> toRecordsDTO(List<Record> recordList);

    List<RecordDTO> toRecordsDTO(Set<Record> recordList);


    @Named("convertIntToType")
    default WithdrawDeposit convertToType(Integer id) {
        return WithdrawDeposit.fromValue(id);
    }


    @Named("convertTypeToInt")
    default Integer convertToInt(WithdrawDeposit type) {
        return type.getId();
    }

    @Named("convertProfileToProfileId")
    default UUID convertProfileToProfileId(Profile profile) {
        return profile.getId();
    }


    @Named("convertSetToList")
    default List<Record> convertSetToList(Set<Record> records) {
        return new ArrayList<Record>(records);
    }


//    @Named("convertProfileIdToProfile")
//    default Integer convertProfileIdToProfile(WithdrawDeposit type) {
//        return type.getId();
//    }


}
