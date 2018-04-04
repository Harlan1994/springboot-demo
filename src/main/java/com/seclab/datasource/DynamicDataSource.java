package com.seclab.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 09:38
 * Description:
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Logger logger = LoggerFactory.getLogger(DynamicDataSource.class.getName());

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("Datasource is now changed to {}", CustomContextHolder.getDataSource());
        return CustomContextHolder.getDataSource();
    }
}
