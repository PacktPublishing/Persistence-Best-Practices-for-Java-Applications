package dev.a4j.mastering.data.infra;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

@ApplicationScoped
class ConnectionSupplier {

    private static final Logger LOGGER = Logger.getLogger(ConnectionSupplier.class.getName());




    @ApplicationScoped
    @Produces
    public Connection get() throws SQLException {
        LOGGER.fine("Starting the database connection");

        var url = "jdbc:h2:~/jakarta-db";
        var password = "";
        var user = "sa";
        return DriverManager.getConnection(url, user, password);
    }

    public void close(@Disposes Connection connection) throws SQLException {
        connection.close();
        LOGGER.fine("closing the database connection");
    }


}
