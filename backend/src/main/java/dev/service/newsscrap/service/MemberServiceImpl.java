package dev.service.newsscrap.service;

import dev.service.newsscrap.entity.Member;
import dev.service.newsscrap.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long save(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    @Override
    public Optional<Member> findById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

    @Override
    public Long validLogin(String name, String password) {
        Optional<Member> loginMember = memberRepository.findByNameAndPassword(name, password);
        return loginMember.get().getId();
    }
}
