package academoy.devdojo.springboot2essencials.repository;

import academoy.devdojo.springboot2essencials.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
