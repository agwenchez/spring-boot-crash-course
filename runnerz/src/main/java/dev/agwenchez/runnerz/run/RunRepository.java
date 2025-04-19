package dev.agwenchez.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private final List<Runs> runs = new ArrayList<>();

    public List<Runs> findAll() {
        return runs;
    }

    public Runs create(Runs run) {
        runs.add(run);
        return run;
    }

    public Runs update(Runs run, Integer id) {
        Optional<Runs> existingRun = findById(id);
        if(existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run );
            return run;
        }
        throw new RunNotFoundException(id);
    }

    public Optional<Runs> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    public String delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
        return "Deleted successfully run with id: " + id;
    }

    @PostConstruct
    public void init() {
        runs.add(new Runs(1, "Monday Morning run", 12, LocalDateTime.now(), LocalDateTime.now().plusHours(1), Location.INDOOR));
        runs.add(new Runs(2, "Wednesday Morning run", 12, LocalDateTime.now(), LocalDateTime.now().plusHours(1), Location.OUTDOOR));
    }
}
