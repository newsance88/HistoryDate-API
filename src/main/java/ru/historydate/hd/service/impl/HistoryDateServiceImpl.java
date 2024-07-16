package ru.historydate.hd.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.historydate.hd.Exception.ResourceNotFoundException;
import ru.historydate.hd.dto.HistoryDateDto;
import ru.historydate.hd.entity.Century;
import ru.historydate.hd.entity.HistoryDate;
import ru.historydate.hd.mapper.HistoryDateMapper;
import ru.historydate.hd.repository.CenturyRepository;
import ru.historydate.hd.repository.HistoryDateRepository;
import ru.historydate.hd.service.HistoryDateService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class HistoryDateServiceImpl implements HistoryDateService {

    private final HistoryDateRepository historyDateRepository;
    private final CenturyRepository centuryRepository;

    @Override
    public HistoryDateDto createHistoryDate(HistoryDateDto historyDateDto) {
        Century century = centuryRepository.findById(historyDateDto.getCenturyId())
                .orElseThrow(() -> new RuntimeException("Century not found"));

        HistoryDate historyDate = HistoryDateMapper.mapToHd(historyDateDto, century);
        HistoryDate savedHistoryDate = historyDateRepository.save(historyDate);

        log.info("Дата создана: {}", savedHistoryDate);

        return HistoryDateMapper.mapToDto(savedHistoryDate);
    }

    @Override
    public HistoryDateDto updateHistoryDate(Long HistoryDateId, HistoryDateDto historyDateDto) {
        HistoryDate historyDateToUpdate = historyDateRepository.findById(HistoryDateId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("History date not found with id:" + HistoryDateId));

        Century century = centuryRepository.findById(historyDateDto.getCenturyId())
                .orElseThrow(() -> new ResourceNotFoundException("Century date not found with id:" + historyDateDto.getCenturyId()));

        historyDateToUpdate.setBeginningYear(historyDateDto.getBeginningYear());
        historyDateToUpdate.setBeginningMonth(historyDateDto.getBeginningMonth());
        historyDateToUpdate.setBeginningDay(historyDateDto.getBeginningDay());
        historyDateToUpdate.setEndingYear(historyDateDto.getEndingYear());
        historyDateToUpdate.setEndingMonth(historyDateDto.getEndingMonth());
        historyDateToUpdate.setEndingDay(historyDateDto.getEndingDay());
        historyDateToUpdate.setDescription(historyDateDto.getDescription());
        historyDateToUpdate.setCentury(century);

        HistoryDate updatedHistoryDate = historyDateRepository.save(historyDateToUpdate);
        return HistoryDateMapper.mapToDto(updatedHistoryDate);

    }

    @Override
    public HistoryDateDto deleteHistoryDateById(Long id) {
        HistoryDate historyDate = historyDateRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("History date not found with id:" + id));

        historyDateRepository.deleteById(id);
        return HistoryDateMapper.mapToDto(historyDate);
    }

    @Override
    public HistoryDateDto getHistoryDateById(Long id) {
        HistoryDate historyDate = historyDateRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("History date not found with id:" + id));
        return HistoryDateMapper.mapToDto(historyDate);
    }

    @Override
    public List<HistoryDateDto> getAllHistoryDates() {
        List<HistoryDate> historyDates = historyDateRepository.findAll();
        return historyDates.stream()
                .map(HistoryDateMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
