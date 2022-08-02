package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //ctrl + shift + t
    //private final MemberRepository memberRepository  = new MemoryMemberRepository();
    private final MemberRepository memberRepository ;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입( 같은 이름이면 안된다)
     */
    public Long join(Member member){
        //중복 이름은 허용하지 않는다.
        //Optional<Member> result = memberRepository.findByName(member.getName());
        validatieDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validatieDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
           .ifPresent(m -> {
            try {
                throw new IllegalAccessException("이미 존재하는 회원입니다");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
