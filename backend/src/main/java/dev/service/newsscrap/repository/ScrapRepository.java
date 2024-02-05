package dev.service.newsscrap.repository;

import dev.service.newsscrap.entity.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {

}
