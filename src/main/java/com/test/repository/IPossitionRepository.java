package com.test.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Position;
public interface IPossitionRepository extends JpaRepository<Position, Short>{
}
