package com.demo.capmgnmt.repository;

import com.demo.capmgnmt.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

public interface RegionRepository extends JpaRepository<Region, Long> {
}