package dev.agwenchez.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

     /*Find All*/
    @GetMapping("")
    List<Run> findAll() {
        return this.runRepository.findAll();
    }

    /*Find One */
    @GetMapping("/{id}")
    ResponseEntity<Map<String, Object>> findById(@PathVariable Integer id) {
        Optional<Run> existingRun = this.runRepository.findById(id);

        if (existingRun.isEmpty()) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "Run with ID " + id + " not found.");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("Run", existingRun);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*Update */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Run run, @PathVariable Integer id) {
        Optional<ResponseEntity<Map<String, Object>>> existing = Optional.ofNullable(findById(id));
        Run updatedRun = this.runRepository.update(run, id);

        if (existing.isEmpty() || updatedRun == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "Run with ID " + id + " not found.");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("Updated Run", updatedRun);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*Create*/
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody Run run) {
        Run createdRun = this.runRepository.create(run);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("Created Run", createdRun);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /*Delete*/
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return this.runRepository.deleteById(id);
    }

}
