package dev.agwenchez.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Runs(
        Integer id,
        @NotEmpty
        String title,
        @Positive
        Integer miles,
        LocalDateTime completedOn,
        LocalDateTime startedOn,
        Location location
) {
//        public Runs(){
//                if(completedOn().isAfter(startedOn())){
//                        throw new IllegalArgumentException("Completed on must be after started on");
//                }
//        }
}
