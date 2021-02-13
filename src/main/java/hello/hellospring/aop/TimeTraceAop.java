package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// AOP를 사용하려면 Aspect annotation 추가해야 함
@Aspect
// Component Scan방식으로 Bean 등록 해도 됨
@Component
// 보통 SpringConfig에 추가해서 Bean으로 등록해도 됨
public class TimeTraceAop {

    // Around 애노테이션을 통해 원하는 공통 관심 사항인 시간 측정을 Tartgeting 가능
    @Around("execution(* hello.hellospring..*(..))") // package 하위에 다 적용해라라는 의미
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());

        try {
//            Object result = joinPoint.proceed();
//            return result;

            // Inline variables
            return joinPoint.proceed();

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");


        }


    }
}
