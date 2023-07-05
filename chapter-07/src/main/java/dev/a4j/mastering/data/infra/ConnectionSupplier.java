package dev.a4j.mastering.data.infra;


import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

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
    private static final String URL= "db.url";

    private static final String USER = "db.username";

    private static final String PASSWORD = "db.password";

    private static final Config CONFIG = ConfigProvider.getConfig();


    @ApplicationScoped
    @Produces
    public Connection get() throws SQLException {
        LOGGER.fine("Starting the database connection");
        var url = CONFIG.getValue(URL, String.class);
        var password = CONFIG.getOptionalValue(PASSWORD, String.class).orElse("");
        var user = CONFIG.getValue(USER, String.class);
        return DriverManager.getConnection(                   url, user, password);
    }

    public void close(@Disposes Connection connection) throws SQLException {
        connection.close();
        LOGGER.fine("closing the database connection");
    }

}
