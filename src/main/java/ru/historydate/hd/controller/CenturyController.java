package ru.historydate.hd.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.historydate.hd.dto.CenturyDto;
import ru.historydate.hd.dto.HistoryDateDto;
import ru.historydate.hd.entity.Century;
import ru.historydate.hd.service.CenturyService;

@AllArgsConstructor
@RestController
@RequestMapping("/centuries")
public class CenturyController {
    private CenturyService centuryService;

    @PostMapping
    public ResponseEntity<CenturyDto> createHistoryDate(@RequestBody CenturyDto century) {
        CenturyDto created = centuryService.createCentury(century);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
