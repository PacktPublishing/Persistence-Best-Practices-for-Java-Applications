package org.soujava.ddd.elder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TeamTest {


    @Test
    public void shouldCreateTeam() {
        Team bahia = Team.of("Bahia");

        Assertions.assertNotNull(bahia);
        Assertions.assertEquals("Bahia", bahia.getName());
        Assertions.assertTrue(bahia.isEmpty());
    }

    @Test
    public void shouldNotBeOverPlayer() {
        Team bahia = Team.of("Bahia");

        for (int index = 0; index < 11; index++) {
            Player player = Player.builder().name("Player " + index)
                    .build();
            bahia.add(player);
        }

        TeamException exception = Assertions.assertThrows(TeamException.class, () ->
                bahia.add(Player.builder().name("Otavio")
                        .build()));
        System.out.println("Error message: "  + exception.getMessage());

    }

}