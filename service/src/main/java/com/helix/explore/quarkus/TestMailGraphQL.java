package com.helix.explore.quarkus;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class TestMailGraphQL {

    @Inject
    Mailer mailer;

    @Query("checkMailSend")
    public String checkMailSend(String targetAddress) {
        var mailToSend = Mail.withText(
                targetAddress,
                "A simple email from quarkus",
                "This is my body");
        mailer.send(mailToSend);
        return "Mail test!";
    }

}
