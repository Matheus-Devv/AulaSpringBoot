package academoy.devdojo.springboot2essencials.client;

import academoy.devdojo.springboot2essencials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
//        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class,2);
//        log.info(entity);

//        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes", Anime.class,2);
//        log.info(object);

//        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
//        log.info(Arrays.toString(animes));
//
//        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Anime>>() {
//                });
//        log.info(exchange.getBody());

//        Anime kingdom = Anime.builder().name("Kingdom").build();
//        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes",kingdom,Anime.class);
//        log.info("Anime saved: {}",kingdomSaved);

        Anime kingdom = Anime.builder().name("Samurai x").build();
        ResponseEntity<Anime> kingdomSaved = new RestTemplate().exchange("http://localhost:8080/animes",
                HttpMethod.POST,
                new HttpEntity<>(kingdom),
                Anime.class);
        log.info("Anime saved: {}",kingdomSaved);


        Anime animeSaved = kingdomSaved.getBody();
        animeSaved.setName("Samurai x 2");
        ResponseEntity<Void> kingdomUpdated = new RestTemplate().exchange("http://localhost:8080/animes",
                HttpMethod.PUT,
                new HttpEntity<>(animeSaved),
                Void.class);
        log.info("Anime updated: {}",kingdomUpdated);


        ResponseEntity<Void> kingdomDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                18);
        log.info("Anime updated: {}",kingdomDeleted);


    }
}
