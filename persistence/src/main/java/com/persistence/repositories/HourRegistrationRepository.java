package com.persistence.repositories;

import com.domain.models.HourRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourRegistrationRepository extends JpaRepository<HourRegistration,Long> {
}
