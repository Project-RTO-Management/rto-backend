package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ExamData;

public interface ExamDataDao extends  JpaRepository<ExamData, Long>{

}
