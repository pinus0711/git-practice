package dev.service.newsscrap.controller;

import dev.service.newsscrap.dto.MemberRequest;
import dev.service.newsscrap.entity.Member;
import dev.service.newsscrap.exception.LoginFailedException;
import dev.service.newsscrap.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public ResponseEntity<?> Login(@RequestBody MemberRequest memberRequest, HttpServletRequest request) {
        Member member = memberRequest.toEntity();

        try {
            Long id = memberService.login(member.getName(), member.getPassword());

            HttpSession session = request.getSession(true);

            session.setAttribute("memberId", id);

            return ResponseEntity.ok(id);

        } catch (LoginFailedException e) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

    /**
     * 로그아웃
     */
    @PostMapping("/logout")
    public void Logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session !=null) {
            session.invalidate();
        }
    }

}
