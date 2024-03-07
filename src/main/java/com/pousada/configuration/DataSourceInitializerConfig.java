/*package com.pousada.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DataSourceInitializerConfig {

    @Value("classpath:schema.sql")
    private Resource mainSchemaScript;

    @Value("classpath:data.sql")
    private Resource mainDataScript;

    @Value("classpath:schema-test.sql")
    private Resource testSchemaScript;

    @Value("classpath:data-test.sql")
    private Resource testDataScript;

    @Profile("!test")
    @Bean
    public DataSourceInitializer dataSourceInitializerMain(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator(mainSchemaScript, mainDataScript));
        return initializer;
    }

    @Profile("test")
    @Bean
    public DataSourceInitializer dataSourceInitializerTest(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator(testSchemaScript, testDataScript));
        return initializer;
    }

    private ResourceDatabasePopulator databasePopulator(Resource schemaScript, Resource dataScript) {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaScript);
        populator.addScript(dataScript);
        return populator;
    }
}
*/
