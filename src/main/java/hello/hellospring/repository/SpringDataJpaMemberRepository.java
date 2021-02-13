package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Interface가 Interface 받을 때는 extends ( implements X )
// Interface는 다중 상속 가능
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL : select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
