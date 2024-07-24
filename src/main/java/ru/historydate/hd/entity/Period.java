package ru.historydate.hd.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "periods")
public class Period {
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
