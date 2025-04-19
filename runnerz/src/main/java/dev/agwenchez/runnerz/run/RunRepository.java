package dev.agwenchez.runnerz.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private static final Logger logger = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient
                .sql("SELECT * FROM runs")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient
                .sql("SELECT * FROM runs where ID= :id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public Run create(Run run) {
        var newRun = jdbcClient
                .sql("INSERT INTO runs (title, miles, completed_on, started_on, location) VALUES (?,?,?,?,?)")
                .params(List.of(run.title(), run.miles(), run.completedOn(), run.startedOn(), run.location().name()))
                .update();

        Assert.state(newRun == 1, "Failed to create new run" + run.title());

        return new Run(newRun, run.title(), run.miles(), run.completedOn(), run.startedOn(), run.location());

    }

    public Run update(Run run, Integer id) {
        var updatedRun = jdbcClient
                .sql("update runs set TITLE = ?, MILES = ?, STARTED_ON = ?, COMPLETED_ON = ?, LOCATION = ? where ID = ?")
                .params(List.of(run.title(), run.miles(), run.startedOn(), run.completedOn(), run.location().name(), id))
                .update();

        Assert.state(updatedRun == 1, "Failed to update run" + run.title());
        return new Run(id, run.title(), run.miles(), run.completedOn(), run.startedOn(), run.location());
    }

    public String deleteById(Integer id) {
        jdbcClient.
                sql("delete from runs where ID = :id")
                .param("id", id)
                .update();
        return "Successfully Deleted run with id:" + id;
    }

    public int count() {
        return jdbcClient
                .sql("SELECT * FROM RUNS")
                .query()
                .listOfRows()
                .size();
    }

    public void saveAll(List<Run> runs) {
        runs.forEach(this::create);
    }
}
