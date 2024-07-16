package ru.historydate.hd.mapper;

import ru.historydate.hd.dto.HistoryDateDto;
import ru.historydate.hd.entity.Century;
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
                historyDate.getCentury() != null ? historyDate.getCentury().getId() : null
        );
    }

    public static HistoryDate mapToHd(HistoryDateDto historyDateDto, Century century) {
        return new HistoryDate(
                historyDateDto.getId(),
                historyDateDto.getBeginningYear(),
                historyDateDto.getBeginningMonth(),
                historyDateDto.getBeginningDay(),
                historyDateDto.getEndingYear(),
                historyDateDto.getEndingMonth(),
                historyDateDto.getEndingDay(),
                historyDateDto.getDescription(),
                century
        );
    }
}
