package com.dimentials.shop.unit.domain.entity;

import com.dimentials.shop.domain.entity.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    @Test
    @DisplayName("Test of constructor of Client with 6 parameters")
    public void testClientConstructor6Parameters() {
        Client client = new Client(1, "John", "Doe", "Smith", "mail@mail.com", false);

        assertAll(
                () -> assertEquals(1, client.getClientId()),
                () -> assertEquals("John", client.getFirstName()),
                () -> assertEquals("Doe", client.getLastName1()),
                () -> assertEquals("Smith", client.getLastName2()),
                () -> assertEquals("mail@mail.com", client.getEmail()),
                () -> assertFalse(client.getIsAdmin())
        );

    }

    @Test
    @DisplayName("Test of constructor of Client with 12 parameters")
    public void testClientConstructor12Parameters() {
        Client client = new Client(1, "John", "Doe", "Smith", "mail@mail.com", false, "Spain", "Madrid", "Gran Via", "1", "1", "A");

        assertAll(
                () -> assertEquals(1, client.getClientId()),
                () -> assertEquals("John", client.getFirstName()),
                () -> assertEquals("Doe", client.getLastName1()),
                () -> assertEquals("Smith", client.getLastName2()),
                () -> assertEquals("mail@mail.com", client.getEmail()),
                () -> assertFalse(client.getIsAdmin()),
                () -> assertEquals("Spain", client.getCountry()),
                () -> assertEquals("Madrid", client.getCity()),
                () -> assertEquals("Gran Via", client.getStreet()),
                () -> assertEquals("1", client.getBuildingNumber()),
                () -> assertEquals("1", client.getFloor()),
                () -> assertEquals("A", client.getDoor())
        );

    }
}