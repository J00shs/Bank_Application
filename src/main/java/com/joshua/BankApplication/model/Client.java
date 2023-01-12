package com.joshua.BankApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Client {
    private final UUID id;

//    @NotBlank
    private final String name;

//@JsonProperty allows clients to be added to the database in Postman. Use body->raw->Select Json on the dropdown menu
    public Client(@JsonProperty("ClientID") UUID id,
                  @JsonProperty("ClientName") String name) {
        this.id = id;
        this.name = name;
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
