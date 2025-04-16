package org.example.sjindividuellainlamning.repositories;

import org.example.sjindividuellainlamning.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    boolean existsByEmail(String email);

}
