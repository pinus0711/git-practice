package dev.service.newsscrap.controller;

import dev.service.newsscrap.dto.ScrapRequestDTO;
import dev.service.newsscrap.dto.ScrapUpdateRequestDTO;
import dev.service.newsscrap.dto.ScrapUpdateResponseDTO;
import dev.service.newsscrap.entity.Scrap;
import dev.service.newsscrap.exception.InvalidMemberException;
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
    public void addScrap(@RequestBody ScrapRequestDTO scrapRequestDTO) {

        scrapService.save(scrapRequestDTO);
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
        } catch (InvalidMemberException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

}