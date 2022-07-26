package com.example.reportingsystem.repository;

import com.example.reportingsystem.model.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Line, Long> {
}
