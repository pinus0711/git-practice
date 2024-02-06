package dev.service.newsscrap.repository;

import dev.service.newsscrap.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
