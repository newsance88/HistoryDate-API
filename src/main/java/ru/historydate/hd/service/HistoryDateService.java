package ru.historydate.hd.service;

import ru.historydate.hd.dto.HistoryDateDto;

import java.util.List;

public interface HistoryDateService {
    HistoryDateDto createHistoryDate(HistoryDateDto historyDateDto);

    HistoryDateDto updateHistoryDate(Long HistoryDateId, HistoryDateDto historyDateDto);

    HistoryDateDto deleteHistoryDateById(Long id);

    HistoryDateDto getHistoryDateById(Long id);

    List<HistoryDateDto> getAllHistoryDates();
}
