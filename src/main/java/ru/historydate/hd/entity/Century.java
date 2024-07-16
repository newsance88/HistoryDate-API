package ru.historydate.hd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "centuries")
public class Century {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String centuryName;
    @Column(name = "beginning")
    private int centuryYearBeginning;
    @Column(name = "ending")
    private int centuryYearEnding;
    @Column(name = "our_era")
    private Boolean ourEra;
}
