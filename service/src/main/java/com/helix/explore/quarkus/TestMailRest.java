package com.helix.explore.quarkus;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("")
public class TestMailRest {

    @Inject
    Mailer mailer;

    @GET
    @Path("/mail")
    public void send() {
        var mailToSend = Mail.withText(
                "to@acme.org",
                "A simple email from quarkus",
                "This is my body");
        mailer.send(mailToSend);
    }

}
