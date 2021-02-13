package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    /**
     * 스프링 DB 접근 기술 - 5. JPA 에서 사용
     */
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    /**
     * 스프링 DB 접근 기술 - 6. 스프링 데이터 JPA 에서 사용
     */
    private final MemberRepository memberRepository;

    @Autowired // 생성자가 1개인 경우에는 생략 가능, 일단 적어둠
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 스프링 DB 접근 기술 - 6. 스프링 데이터 JPA 에서 수정
     */
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository); // Ctrl + p 하면 괄호 안에 변수 어떤 것을 넣어야 하는지 알 수 있음
    }

    /**
     * 스프링 DB 접근 기술 - 6. 스프링 데이터 JPA 에서 생략
     */
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

    /**
     * AOP - 2. AOP 적용에서 사용해도 됨
     */
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
