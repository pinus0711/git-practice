package dev.service.newsscrap.controller;

import dev.service.newsscrap.dto.MemberRequest;
import dev.service.newsscrap.entity.Member;
import dev.service.newsscrap.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     */
    @PostMapping("/register")
    public Long Register(@RequestBody MemberRequest memberRequest) {
        Member member = memberRequest.toEntity();
        return memberService.save(member);
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public Long Login(@RequestBody MemberRequest memberRequest) {
        Member member = memberRequest.toEntity();
        return memberService.Login(member.getName(), member.getPassword());
    }

}
