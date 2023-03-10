package academoy.devdojo.springboot2essencials.service;

import academoy.devdojo.springboot2essencials.config.security.UserDetailsServiceImpl;
import academoy.devdojo.springboot2essencials.domain.Anime;
import academoy.devdojo.springboot2essencials.domain.UserModel;
import academoy.devdojo.springboot2essencials.exception.BadRequestException;
import academoy.devdojo.springboot2essencials.mapper.AnimeMapper;
import academoy.devdojo.springboot2essencials.repository.AnimeRepository;
import academoy.devdojo.springboot2essencials.requests.AnimePostRequestBody;
import academoy.devdojo.springboot2essencials.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> listAllNonPageble() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
//        Anime anime = Anime.builder()
//                .name(animePostRequestBody.getName())

        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }

}
