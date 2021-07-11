package com.javayh.wenflux.service;

import com.javayh.wenflux.entity.DemoEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-08
 */
@Service
public class DemoService {

    public Mono<DemoEntity> save(DemoEntity entity) throws InterruptedException {
        return Mono.create(cityMonoSink -> cityMonoSink.success(entity));
    }

    public Mono<DemoEntity> findById(int id) {
        return Mono.justOrEmpty(DemoEntity.listEntityBuild().get(id));
    }

    public Flux<DemoEntity> findAllEntity() {
        return Flux.fromIterable(DemoEntity.listEntityBuild());
    }

    public Mono<Long> delete(Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(DemoEntity.del()));
    }
}
