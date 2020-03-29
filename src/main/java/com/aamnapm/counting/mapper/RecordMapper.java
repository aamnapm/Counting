package com.aamnapm.counting.mapper;

import com.aamnapm.counting.dto.RecordDTO;
import com.aamnapm.counting.model.Record;
import com.aamnapm.counting.model.WithdrawDeposit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordMapper {

    @Mapping(target = "id", source = "uuid")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "type", source = "type", qualifiedByName = "convertTypeToInt")
    Record convertToRecord(RecordDTO recordDTO);


    @Mapping(target = "uuid", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "type", source = "type", qualifiedByName = "convertIntToType")
    RecordDTO convertToRecordDTO(Record record);


    List<RecordDTO> toRecordsDTO(List<Record> userList);


    @Named("convertIntToType")
    default WithdrawDeposit convertToWithdrawDeposit(Integer id) {
        return WithdrawDeposit.fromValue(id);
    }


    @Named("convertTypeToInt")
    default Integer convertToWithdrawDeposit(WithdrawDeposit type) {
        return type.getId();
    }


}
