package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // callback method - 밑에 save, findByName 과 같이 Test 1개 끝날 때마다 실행
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        // 반환 Type이 Optional 이므로 get()을 이용해서 값을 꺼냄
        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = " + (result == member));

        // Jupiter Assertions 사용
        // Assertions.assertEquals(member, member); // expected, actual

        // assertj assertThat 사용, Assertions에서 Alt+Enter를 통해서 static import 하여 생략시킴
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // Shift + F6을 통해서 한번에 변수명을 rename 할 수 있음
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // shift + f6 을 통해서 이름을 한꺼번에 바꿀 수 있음
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
