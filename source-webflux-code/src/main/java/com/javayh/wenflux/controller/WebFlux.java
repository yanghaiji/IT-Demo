package com.javayh.wenflux.controller;

import com.javayh.wenflux.entity.DemoEntity;
import com.javayh.wenflux.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-08
 */
@RestController
public class WebFlux {

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "save")
    public Mono<DemoEntity> save(String name) throws InterruptedException {
        return demoService.save(new DemoEntity(name));
    }

    @GetMapping(value = "findById")
    public Mono<DemoEntity> findById(int id) {
        return demoService.findById(id);
    }

    @GetMapping(value = "findAllEntity")
    public Flux<DemoEntity> findAllEntity() {
        return demoService.findAllEntity();
    }

    @GetMapping(value = "delete")
    public Mono<Long> delete(Long id) {
        return demoService.delete(id);
    }
}
