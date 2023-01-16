package academoy.devdojo.springboot2essencials.util;

import academoy.devdojo.springboot2essencials.domain.Anime;
import academoy.devdojo.springboot2essencials.requests.AnimePostRequestBody;
import academoy.devdojo.springboot2essencials.requests.AnimePutRequestBody;

public class AnimePostRequestBodyCreator {

    public static AnimePostRequestBody createAnimePostRequestBody() {
        return AnimePostRequestBody.builder()
                .name(AnimeCreator.createAnimeToBeSaved().getName())
                .build();
    }
}
