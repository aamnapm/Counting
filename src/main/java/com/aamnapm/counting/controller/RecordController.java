package com.aamnapm.counting.controller;

import com.aamnapm.counting.dto.RecordDTO;
import com.aamnapm.counting.dto.ResponseApi;
import com.aamnapm.counting.mapper.RecordMapper;
import com.aamnapm.counting.service.RecordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(value = "Record Controller")
@RequestMapping("/record")
public class RecordController {

    private RecordMapper recordMapper;
    private RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService, RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
        this.recordService = recordService;
    }

    @GetMapping
    ResponseEntity<List<RecordDTO>> getAll() {
        List<RecordDTO> recordDTOS = recordMapper.toRecordsDTO(recordService.getAll());
        return ResponseEntity.status(HttpURLConnection.HTTP_CREATED).body(recordDTOS);
    }

    @GetMapping("/{id}")
    ResponseEntity<RecordDTO> getByRecordId(@PathVariable("id") UUID uuid) {
        RecordDTO recordDTO = recordMapper.convertToRecordDTO(recordService.get(uuid));
        return ResponseEntity.status(HttpURLConnection.HTTP_CREATED).body(recordDTO);
    }

    @GetMapping("/profileProfile")
    ResponseEntity<List<RecordDTO>> getProfileRecords(@RequestHeader("profileId") UUID id) {
        List<RecordDTO> recordDTO = recordMapper.toRecordsDTO(recordService.getRecords(id));
        return ResponseEntity.status(HttpURLConnection.HTTP_CREATED).body(recordDTO);
    }

    @PostMapping("/{profileId}")
    ResponseEntity<ResponseApi> save(@RequestBody @Valid RecordDTO recordDTO, @PathVariable("profileId") UUID id) {
        ResponseApi responseApi = recordService.save(recordMapper.convertToRecord(recordDTO), id);
        return ResponseEntity.status(HttpURLConnection.HTTP_CREATED).body(responseApi);
    }

    @PutMapping("/{id}")
    ResponseEntity update(@RequestBody @Valid RecordDTO recordDTO, @PathVariable("id") UUID uuid) {
        recordService.update(recordMapper.convertToRecord(recordDTO), uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") UUID uuid) {
        recordService.delete(uuid);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/")
    ResponseEntity<List<RecordDTO>> getAll(
            @RequestParam(value = "type", required = false, defaultValue = "-1") int type,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "price", required = false) String price) {
        List<RecordDTO> profileDTOList = recordMapper.toRecordsDTO(recordService.getAll(type, title, price));
        return ResponseEntity.status(HttpURLConnection.HTTP_OK).body(profileDTOList);
    }

}
