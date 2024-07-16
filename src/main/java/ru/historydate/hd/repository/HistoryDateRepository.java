package ru.historydate.hd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.historydate.hd.entity.HistoryDate;

public interface HistoryDateRepository extends JpaRepository<HistoryDate, Long> {
}
