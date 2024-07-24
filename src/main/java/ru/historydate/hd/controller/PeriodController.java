package ru.historydate.hd.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.historydate.hd.dto.PeriodDto;
import ru.historydate.hd.service.PeriodService;

@AllArgsConstructor
@RestController
@RequestMapping("/periods")
public class PeriodController {
    private PeriodService periodService;

    @PostMapping
    public ResponseEntity<PeriodDto> createHistoryDate(@RequestBody PeriodDto century) {
        PeriodDto created = periodService.createCentury(century);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
