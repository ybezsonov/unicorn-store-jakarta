package com.unicorn.store.data;

// import io.agroal.api.AgroalDataSource;
import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import jakarta.inject.Inject;
import jakarta.servlet.ServletContextListener;

public class CheckpointUtil implements Resource, ServletContextListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    // @Inject
    // AgroalDataSource dataSource;

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        logger.info("Preparing for checkpoint ...");
        // dataSource.close();
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        logger.info("Restoring from checkpoint ...");
    }
}
