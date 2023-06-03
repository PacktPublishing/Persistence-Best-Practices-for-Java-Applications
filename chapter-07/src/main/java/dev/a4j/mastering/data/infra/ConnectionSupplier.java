package dev.a4j.mastering.data.infra;


import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Supplier;
import java.util.logging.Logger;

@ApplicationScoped
class ConnectionSupplier {

    private static final Logger LOGGER = Logger.getLogger(ConnectionSupplier.class.getName());
    private static final String URL= "jakarta.db.url";

    private static final String USER = "jakarta.db.user";

    private static final String PASSWORD = "jakarta.db.password";

    private static final Config CONFIG = ConfigProvider.getConfig();


    @ApplicationScoped
    @Produces
    public Connection get() throws SQLException {
        LOGGER.fine("Starting the database connection");
        var url = CONFIG.getValue(URL, String.class);
        var password = CONFIG.getValue(PASSWORD, String.class);
        var user = CONFIG.getValue(USER, String.class);
        return DriverManager.getConnection(                   url, user, password);
    }

    public void close(@Disposes Connection connection) throws SQLException {
        connection.close();
        LOGGER.fine("closing the database connection");
    }

}
