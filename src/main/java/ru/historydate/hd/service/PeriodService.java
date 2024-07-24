package ru.historydate.hd.service;

import ru.historydate.hd.dto.PeriodDto;

import java.util.List;

public interface PeriodService {
    public PeriodDto createCentury(PeriodDto century);

    public PeriodDto getCenturyById(Long id);

    public List<PeriodDto> getAllCentury();
}
