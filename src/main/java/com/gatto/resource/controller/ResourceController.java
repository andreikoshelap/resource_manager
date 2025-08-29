package com.gatto.resource.controller;

import com.gatto.resource.entity.Resource;
import com.gatto.resource.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceRepository repository;


    @PostMapping
    public Resource create(@RequestBody Resource resource) {
        return repository.save(resource);
    }


    @GetMapping
    public List<Resource> all() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Resource get(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }


    @PutMapping("/{id}")
    public Resource update(@PathVariable Long id, @RequestBody Resource updated) {
        Resource r = repository.findById(id).orElseThrow();
        updated.setId(id);
        return repository.save(updated);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
