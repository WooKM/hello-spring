package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Ctrl + Shift + T 단축키를 쓰면 편하게 Test를 만들 수 있음
// @Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X
        // Ctrl + Alt + v 하면 자동적으로 return type을 만들어줌
        /*Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다. ");
        });*/

        // AOP - 2. AOP 적용에서 생략
        /* long start = System.currentTimeMillis();*/

        // AOP - 2. AOP 적용에서 수정
        /* try {
            // 핵심 비즈니스 로직
            validateDuplicateMember(member); // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }*/

        // 핵심 비즈니스 로직
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // Ctrl+alt+m (refactor) 을 통해서 method를 만들었음
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조희
     */
    public List<Member> findMembers() {
        // AOP - 2. AOP 적용에서 생략
        /* long start = System.currentTimeMillis();*/

        // AOP - 2. AOP 적용에서 수정
        /* try {
            // 핵심 비즈니스 로직
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }*/

        // 핵심 비즈니스 로직
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
