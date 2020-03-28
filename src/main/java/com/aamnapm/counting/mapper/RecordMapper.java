package com.aamnapm.counting.mapper;

import com.aamnapm.counting.dto.ProfileDTO;
import com.aamnapm.counting.dto.RecordDTO;
import com.aamnapm.counting.model.Profile;
import com.aamnapm.counting.model.Record;
import com.aamnapm.counting.model.WithdrawDeposit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordMapper {

    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "type", source = "type", qualifiedByName = "convertIntToType")
    Record convertToRecord(RecordDTO recordDTO);


    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "type", source = "type", qualifiedByName = "convertTypeToInt")
    RecordDTO convertToRecordDTO(Record record);


    List<ProfileDTO> toRecordsDTO(List<Profile> userList);


    @Named("convertIntToType")
    default WithdrawDeposit convertToWithdrawDeposit(Integer id) {
        return WithdrawDeposit.fromValue(id);
    }


    @Named("convertTypeToInt")
    default Integer convertToWithdrawDeposit(WithdrawDeposit type) {
        return type.getId();
    }


}
