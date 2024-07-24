package ru.historydate.hd.mapper;

import ru.historydate.hd.dto.HistoryDateDto;
import ru.historydate.hd.entity.Period;
import ru.historydate.hd.entity.HistoryDate;

public class HistoryDateMapper {

    public static HistoryDateDto mapToDto(HistoryDate historyDate) {
        return new HistoryDateDto(
                historyDate.getId(),
                historyDate.getBeginningYear(),
                historyDate.getBeginningMonth(),
                historyDate.getBeginningDay(),
                historyDate.getEndingYear(),
                historyDate.getEndingMonth(),
                historyDate.getEndingDay(),
                historyDate.getDescription(),
                historyDate.getPeriod() != null ? historyDate.getPeriod().getId() : null,
                historyDate.getPeriod().getCenturyName()
        );
    }

    public static HistoryDate mapToHd(HistoryDateDto historyDateDto, Period period) {
        return new HistoryDate(
                historyDateDto.getId(),
                historyDateDto.getBeginningYear(),
                historyDateDto.getBeginningMonth(),
                historyDateDto.getBeginningDay(),
                historyDateDto.getEndingYear(),
                historyDateDto.getEndingMonth(),
                historyDateDto.getEndingDay(),
                historyDateDto.getDescription(),
                period
        );
    }
}
