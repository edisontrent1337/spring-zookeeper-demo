package com.trent.labs.springzookeeperdemo.usecases;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// This only exists for demonstration purposes
@RestController
public class UseCaseController {

    private final UseCaseRepository useCaseRepository;

    public UseCaseController(UseCaseRepository useCaseRepository) {
        this.useCaseRepository = useCaseRepository;
    }

    @GetMapping("/usecases/{id}")
    public ResponseEntity<UseCase> getUseCase(@RequestHeader("X-Tenant-Id") String tenantId, @PathVariable("id") String id){
        return useCaseRepository.getUseCase(tenantId, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usecases")
    public ResponseEntity<List<UseCase>> getUseCases(@RequestHeader("X-Tenant-Id") String tenantId){
        return ResponseEntity.ok(useCaseRepository.getUseCases(tenantId));
    }
}
