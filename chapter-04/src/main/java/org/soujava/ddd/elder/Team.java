package org.soujava.ddd.elder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//agregator
public class Team {

    public static final int JOGADORES_TIME = 11;

    private final String name;
    private List<Player> players;

    private Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Adiciona um novo jogador ao time
     * @param player um novo jogador
     * @throws NullPointerException quando o parametro é nulo
     * @throws TeamException quando o time está completo
     */
    public void add(Player player) {
        Objects.requireNonNull(player, "player is required");
        if (this.players.size() == JOGADORES_TIME) {
            throw new TeamException("O meu time já está completo, nao tem espaço para o jogador: "
            + player);
        }
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
    public boolean isEmpty() {
        return this.players.isEmpty();
    }

    public static Team of(String name) {
        Objects.requireNonNull(name, "name is required");
        return new Team(name);
    }

}
