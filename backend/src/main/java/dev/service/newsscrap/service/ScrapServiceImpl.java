package dev.service.newsscrap.service;

import dev.service.newsscrap.dto.ScrapRequest;
import dev.service.newsscrap.entity.Member;
import dev.service.newsscrap.entity.Scrap;
import dev.service.newsscrap.repository.MemberRepository;
import dev.service.newsscrap.repository.ScrapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScrapServiceImpl implements ScrapService {

    private final ScrapRepository scrapRepository;
    private final MemberRepository memberRepository;

    @Override
    public Scrap findById(Long id) {

        Optional<Scrap> scrapOptional = scrapRepository.findById(id);

        return scrapOptional.orElse(null);
    }

    @Override
    public Scrap save(ScrapRequest scrapRequest) {

        Optional<Member> memberOptional = memberRepository.findById(scrapRequest.getMemberId());

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();

            Scrap scrap = ScrapRequest.toEntity(scrapRequest, member);

            return scrapRepository.save(scrap);

        } else {
            throw new RuntimeException("ID가 " + scrapRequest.getMemberId() + "인 사용자를 찾을 수 없습니다.");
        }
    }

    public List<Scrap> findAll() {
        List<Scrap> scraps = new ArrayList<>();
        scrapRepository.findAll().forEach(scraps::add);

        return scraps;
    }

    @Override
    public void deleteById(Long scrapId, Long memberId) {

        if (findById(scrapId).getMember().getId() == memberId) {
            scrapRepository.deleteById(scrapId);

        } else {
            throw new RuntimeException("Error Occurred.");
        }
    }

}
