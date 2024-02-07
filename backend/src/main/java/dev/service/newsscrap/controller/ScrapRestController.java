package dev.service.newsscrap.controller;

import dev.service.newsscrap.dto.ScrapRequest;
import dev.service.newsscrap.dto.ScrapUpdateRequestDTO;
import dev.service.newsscrap.dto.ScrapUpdateResponseDTO;
import dev.service.newsscrap.entity.Scrap;
import dev.service.newsscrap.exception.NotExistDataException;
import dev.service.newsscrap.service.ScrapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/scrap")
@RestController
@RequiredArgsConstructor
public class ScrapRestController {

    private final ScrapService scrapService;

    @PostMapping("/create")
    public void addScrap(@RequestBody ScrapRequest scrapRequest) {

        scrapService.save(scrapRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
        Scrap scrap = scrapService.findById(id);

        return ResponseEntity.ok(scrap);
        } catch (NotExistDataException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * Scrap 수정
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateScrap(@PathVariable Long id, @RequestBody ScrapUpdateRequestDTO scrapupdateRequestDTO) {
        Scrap scrap = scrapupdateRequestDTO.toEntity();

        try {
            Scrap updatedScrap = scrapService.update(id, scrap);
            ScrapUpdateResponseDTO scrapResponseDTO = ScrapUpdateResponseDTO.toDTO(updatedScrap);

            return ResponseEntity.ok(scrapResponseDTO);
        } catch (NotExistDataException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PostMapping("/delete")
    public void deleteScrap(@RequestParam Long scrapId, Long memberId) {

        scrapService.deleteById(scrapId, memberId);
    }
}