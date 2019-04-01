package com.persistence.repositories;

import com.domain.models.HourRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHourRegistrationRepository extends JpaRepository<HourRegistration, Long> {
}
