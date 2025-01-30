package com.unicorn.store.data;

import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.agroal.api.AgroalDataSource;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import io.agroal.api.AgroalDataSource.FlushMode;

public class CheckpointUtil implements Resource, ServletContextListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    AgroalDataSource dataSource;

    public void contextInitialized(ServletContextEvent event) {
        Core.getGlobalContext().register(this);
    }

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        logger.info("Preparing for checkpoint ...");
        dataSource.flush(FlushMode.ALL);
        // dataSource.close();
        logger.info("Checkpoint prepared ...");
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        logger.info("Restoring from checkpoint ...");
    }
}
