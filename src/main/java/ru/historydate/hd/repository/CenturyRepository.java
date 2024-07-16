package ru.historydate.hd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.historydate.hd.entity.Century;

public interface CenturyRepository extends JpaRepository<Century,Long> {
}
