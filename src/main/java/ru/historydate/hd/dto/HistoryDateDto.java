package ru.historydate.hd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDateDto {
    private Long id;
    private int beginningYear;
    private int beginningMonth;
    private int beginningDay;
    private int endingYear;
    private int endingMonth;
    private int endingDay;
    private String description;
    private Long centuryId;
}
