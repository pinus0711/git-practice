package dev.service.newsscrap.service;

import dev.service.newsscrap.dto.ScrapRequest;
import dev.service.newsscrap.entity.Scrap;
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

    @Override
    public Scrap findById(Long id) {
        Optional<Scrap> scrapOptional = scrapRepository.findById(id);

        return scrapOptional.orElse(null);
    }

    @Override
    public Scrap save(Scrap scrap) {

        return scrapRepository.save(scrap);
    }

    public List<Scrap> findAll() {
        List<Scrap> scraps = new ArrayList<>();
        scrapRepository.findAll().forEach(scraps::add);

        return scraps;
    }
}
