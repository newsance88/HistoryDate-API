package ru.historydate.hd.controller;

import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.historydate.hd.dto.HistoryDateDto;
import ru.historydate.hd.entity.HistoryDate;
import ru.historydate.hd.service.HistoryDateService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dates")
public class HistoryDateController {
    
    private HistoryDateService historyDateService;

    @PostMapping
    public ResponseEntity<HistoryDateDto> createHistoryDate(@RequestBody HistoryDateDto historyDateDto) {
        HistoryDateDto savedHistoryDate = historyDateService.createHistoryDate(historyDateDto);
        return new ResponseEntity<>(savedHistoryDate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HistoryDateDto>> getAllHistoryDates() {
        List<HistoryDateDto> historyDateDtos = historyDateService.getAllHistoryDates();
        return new ResponseEntity<>(historyDateDtos, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<HistoryDateDto> getHistoryDateById(@PathVariable("id") Long id) {
        HistoryDateDto historyDateDto = historyDateService.getHistoryDateById(id);
        return new ResponseEntity<>(historyDateDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<HistoryDateDto> updateHistoryDate(@PathVariable("id") Long id,
                                                            @RequestBody HistoryDateDto historyDateDto) {
        HistoryDateDto savedHistoryDate = historyDateService.updateHistoryDate(id, historyDateDto);
        return new ResponseEntity<>(savedHistoryDate, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HistoryDateDto> deleteHistoryDate(@PathVariable("id") Long id) {
        HistoryDateDto historyDateDto = historyDateService.deleteHistoryDateById(id);
        return new ResponseEntity<>(historyDateDto, HttpStatus.OK);
    }

}
