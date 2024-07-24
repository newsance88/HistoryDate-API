package ru.historydate.hd.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.historydate.hd.Exception.ResourceNotFoundException;
import ru.historydate.hd.dto.PeriodDto;
import ru.historydate.hd.entity.Period;
import ru.historydate.hd.mapper.PeriodMapper;
import ru.historydate.hd.repository.PeriodRepository;
import ru.historydate.hd.service.PeriodService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PeriodServiceImpl implements PeriodService {
    private final PeriodRepository periodRepository;

    @Override
    public PeriodDto createCentury(PeriodDto centurydto) {
        Period period = PeriodMapper.mapFromDtoToCentury(centurydto);
        Period savedPeriod = periodRepository.save(period);
        log.info("Век создан: {}", savedPeriod);
        return PeriodMapper.mapCenturyToDto(savedPeriod);
    }

    @Override
    public PeriodDto getCenturyById(Long id) {
        Period period = periodRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("History date not found with id:" + id));
        log.info("Век получен: {}", period);
        return PeriodMapper.mapCenturyToDto(period);
    }

    @Override
    public List<PeriodDto> getAllCentury() {

        List<Period> periodList = periodRepository.findAll();
        log.info("Получение всех веков");

        return periodList.stream()
                .map(PeriodMapper::mapCenturyToDto)
                .collect(Collectors.toList());
    }
}
