package org.soujava.ddd.elder;

public class TeamDAO {

    public Team insert(Team team) {
        TeamRelational relational = TeamRelational.of(team);
        return relational.toTeam();
    }


    static class TeamRelational {

        public static TeamRelational of(Team team) {
            return new TeamRelational();
        }

        public Team toTeam() {
            return null;
        }
    }
}
