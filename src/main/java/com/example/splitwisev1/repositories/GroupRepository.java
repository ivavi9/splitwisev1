package com.example.splitwisev1.repositories;

import com.example.splitwisev1.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group,Long> {

    @Query(value = "SELECT COUNT(*) FROM group_information_participants gp " +
            "WHERE gp.groups_information_id = ?1 AND gp.participants_id = ?2", nativeQuery = true)
    int countUserAsGroupMember(Long groupId, Long userId);

}
