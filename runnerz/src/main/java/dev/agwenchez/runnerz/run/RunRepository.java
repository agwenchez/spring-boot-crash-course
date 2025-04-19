package dev.agwenchez.runnerz.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {
    private static final Logger logger = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    List<Run> runs = new ArrayList<>();

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> getRuns() {
        return jdbcClient.sql("SELECT * FROM runs").query(Run.class).list();
    }
}
