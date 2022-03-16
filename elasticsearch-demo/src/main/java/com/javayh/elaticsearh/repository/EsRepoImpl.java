package com.javayh.elaticsearh.repository;

import com.javayh.elaticsearh.docment.UserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.elaticsearh.repositry → EsRepoImpl
 * @since 2022-02-10
 */
@Repository
public interface EsRepoImpl extends ElasticsearchRepository<UserEntity,Long> {

}
