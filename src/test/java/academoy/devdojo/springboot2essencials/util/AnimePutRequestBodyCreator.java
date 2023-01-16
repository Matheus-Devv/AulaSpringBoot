package academoy.devdojo.springboot2essencials.util;

import academoy.devdojo.springboot2essencials.domain.Anime;
import academoy.devdojo.springboot2essencials.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {

    public static AnimePutRequestBody createAnimePutRequestBody() {
        return AnimePutRequestBody.builder()
                .id(AnimeCreator.createValidUpdatedAnime().getId())
                .name(AnimeCreator.createValidUpdatedAnime().getName())
                .build();
    }
}
