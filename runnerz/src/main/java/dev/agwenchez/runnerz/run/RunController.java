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
//
//     /*Find All*/
//    @GetMapping("")
//    List<Runs> findAll() {
//        return this.runRepository.findAll();
//    }
//
//    /*Find One */
//    @GetMapping("/{id}")
//    Runs findById(@PathVariable Integer id) {
//        Optional<Runs> run = this.runRepository.findById(id);
//        return run.orElseThrow(() -> new RunNotFoundException(id));
//    }
//
//    /*Update */
//    @PutMapping("/{id}")
//    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Runs run, @PathVariable Integer id) {
//        Runs updatedRun = this.runRepository.update(run, id);
//
//        if (updatedRun == null) {
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("success", false);
//            errorResponse.put("message", "Run with ID " + id + " not found.");
//            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//        }
//        Map<String, Object> response = new HashMap<>();
//        response.put("success", true);
//        response.put("Updated Run", updatedRun);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    /*Create*/
//    @PostMapping("")
//    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody Runs run) {
//        Runs createdRun = this.runRepository.create(run);
//        Map<String, Object> response = new HashMap<>();
//        response.put("success", true);
//        response.put("Created Run", createdRun);
//
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    /*Delete*/
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Integer id) {
//        return this.runRepository.delete(id);
//    }

}
