package ru.historydate.hd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.historydate.hd.entity.Period;

public interface PeriodRepository extends JpaRepository<Period,Long> {
}
