package ru.historydate.hd.mapper;

import ru.historydate.hd.dto.PeriodDto;
import ru.historydate.hd.entity.Period;

public class PeriodMapper {
    public static Period mapFromDtoToCentury(PeriodDto periodDto) {
        return new Period(
                periodDto.getId(),
                periodDto.getCenturyName(),
                periodDto.getCenturyYearBeginning(),
                periodDto.getCenturyYearEnding(),
                periodDto.getOurEra()
        );
    }
    public static PeriodDto mapCenturyToDto(Period period) {
        return new PeriodDto(
                period.getId(),
                period.getCenturyName(),
                period.getCenturyYearBeginning(),
                period.getCenturyYearEnding(),
                period.getOurEra()
        );
    }
}
