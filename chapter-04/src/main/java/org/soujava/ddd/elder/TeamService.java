package org.soujava.ddd.elder;

import javax.money.MonetaryAmount;

//service
public class TeamService {

    public void contratar(Player player) {
        Email email = player.getEmail();
        //enviar-email
        MonetaryAmount salary = player.getSalary();
        //negociar salario
        //verificar tenho dinheiro
        //manda um email confirmando a jogador
        //anuncio a impressa
        //adiciono no time
    }
}
