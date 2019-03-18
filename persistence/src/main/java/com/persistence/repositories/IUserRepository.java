package com.persistence.repositories;

import com.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface IUserRepository extends PagingAndSortingRepository<User,Long> {
}
