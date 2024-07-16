package ru.historydate.hd.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.historydate.hd.dto.CenturyDto;
import ru.historydate.hd.entity.Century;
import ru.historydate.hd.mapper.CenturyMapper;
import ru.historydate.hd.repository.CenturyRepository;
import ru.historydate.hd.service.CenturyService;

@Service
@AllArgsConstructor
@Slf4j
public class CenturyServiceImpl implements CenturyService {
    private final CenturyRepository centuryRepository;
    @Override
    public CenturyDto createCentury(CenturyDto centurydto) {
        Century century = CenturyMapper.mapFromDtoToCentury(centurydto);
        Century savedCentury = centuryRepository.save(century);
        log.info("Век создан: {}", savedCentury);
        return CenturyMapper.mapCenturyToDto(savedCentury);
    }
}
