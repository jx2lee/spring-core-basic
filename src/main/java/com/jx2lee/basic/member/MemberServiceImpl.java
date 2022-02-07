package com.jx2lee.basic.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 자동으로 의존 관계를 주입하는 Autowired
    // 주입을 자동으로 주입하길 원하는 생성자에 해당 annotation 작성
    //    @Autowired
    //    public MemberServiceImpl(MemberRepository memberRepository) {
    //        this.memberRepository = memberRepository;
    //    }
    // RequiredArgsConstructor annotion 사용 시 아래 생성자를 자동으로 만들어준다.
    // 대..박

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Just for Test

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
