package ru.historydate.hd.mapper;

import ru.historydate.hd.dto.CenturyDto;
import ru.historydate.hd.entity.Century;

public class CenturyMapper {
    public static Century mapFromDtoToCentury(CenturyDto centuryDto) {
        return new Century(
                centuryDto.getId(),
                centuryDto.getCenturyName(),
                centuryDto.getCenturyYearBeginning(),
                centuryDto.getCenturyYearEnding(),
                centuryDto.getOurEra()
        );
    }
    public static CenturyDto mapCenturyToDto(Century century) {
        return new CenturyDto(
                century.getId(),
                century.getCenturyName(),
                century.getCenturyYearBeginning(),
                century.getCenturyYearEnding(),
                century.getOurEra()
        );
    }
}
