package dev.agwenchez.runnerz.run;

public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(Integer id) {
        super("Run with id " + id + " not found");
    }
}
