package com.helix.explore.quarkus.service;

import com.helix.explore.quarkus.dto.FilmDTO;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MySimpleService {

    @Inject
    ReactiveMailer mailer;

    public Uni<FilmDTO> doSomethingAndSendMailReactive() {
        // do something
        var film = new FilmDTO();
        film.setTitle("Best film ever!");
        film.setYear(2022);
        // do something

        var mailToSend = Mail.withText(
                "someAddress@mail.com",
                "A simple email from quarkus",
                "This is my body");

        return mailer.send(mailToSend)
                .onItem()
                .transform(v -> film);
    }

    public FilmDTO doSomethingAndSendMailImperative() {
        // do something
        var film = new FilmDTO();
        film.setTitle("Best film ever!");
        film.setYear(2022);
        // do something

        var mailToSend = Mail.withText(
                "someAddress@mail.com",
                "A simple email from quarkus",
                "This is my body");

        var ignoreSomething = mailer.send(mailToSend)
                .onItem()
                .transform(v -> "Ignore me.");

        return film;
    }

}
