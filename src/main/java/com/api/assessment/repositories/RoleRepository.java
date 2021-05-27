package com.api.assessment.repositories;

import com.api.assessment.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<List<Role>> findByRoleNameIn(List<String> roleNames);

    Optional<List<Role>> findByRoleSeqIn(List<Integer> rolesList);
}

