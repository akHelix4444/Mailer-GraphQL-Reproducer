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

    @Query("checkMailSendReactive")
    public Uni<FilmDTO> checkMailSendReactive(String targetAddress) {
        return mySimpleService.doSomethingAndSendMailReactive();
    }

    @Query("checkMailSendImperative")
    public FilmDTO checkMailSendImperative(String targetAddress) {
        return mySimpleService.doSomethingAndSendMailImperative();
    }

}
