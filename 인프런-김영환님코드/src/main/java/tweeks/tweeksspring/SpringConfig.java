package tweeks.tweeksspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tweeks.tweeksspring.repository.MemberRepository;
import tweeks.tweeksspring.repository.MemoryMemberRepository;
import tweeks.tweeksspring.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
