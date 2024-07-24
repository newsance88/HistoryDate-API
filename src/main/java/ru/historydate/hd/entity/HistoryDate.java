package ru.historydate.hd.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dates")
public class HistoryDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "beginning_year")
    private int beginningYear;
    @Column(name = "beginning_month")
    private int beginningMonth;
    @Column(name = "beginning_day")
    private int beginningDay;
    @Column(name = "ending_year")
    private int endingYear;
    @Column(name = "ending_month")
    private int endingMonth;
    @Column(name = "ending_day")
    private int endingDay;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "century_id", referencedColumnName = "id")
    private Period period;
}
