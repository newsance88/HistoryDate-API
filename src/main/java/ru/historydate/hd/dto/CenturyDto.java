package ru.historydate.hd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CenturyDto {
    private Long id;
    private String centuryName;
    private int centuryYearBeginning;
    private int centuryYearEnding;
    private Boolean ourEra;
}
