package com.helix.explore.quarkus;

import com.helix.explore.quarkus.service.MySimpleService;
import com.helix.explore.quarkus.dto.FilmDTO;
import io.smallrye.mutiny.Uni;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class TestMailGraphQL {

    @Inject
    MySimpleService mySimpleService;

    @Query("checkMailSend")
    public Uni<FilmDTO> checkMailSend(String targetAddress) {
        return mySimpleService.doSomethingAndSendMail();
    }

}
