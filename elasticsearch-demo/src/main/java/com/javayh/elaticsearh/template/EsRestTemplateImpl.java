package com.javayh.elaticsearh.template;

import com.javayh.elaticsearh.docment.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.elaticsearh.service → EsServiceImpl
 * @since 2022-02-09
 */
@Service
public class EsRestTemplateImpl {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;


    /**
     * <p>
     * 保存索引
     * </p>
     *
     * @param
     * @return void
     * @version 1.0.0
     * @author hai ji
     * @since 2022/2/9
     */
    public void create() {
        UserEntity userEntity = UserEntity.builder().id(System.currentTimeMillis()).brand("javayh").images("es.png").price(2020.29).title("Java有货").build();
        elasticsearchTemplate.save(userEntity);
    }

    public String index() {
        UserEntity userEntity = UserEntity.builder().id(System.currentTimeMillis()).brand("javayh").images("es.png").price(2020.29).title("Java有货").build();
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(userEntity).build();
        String sys_user = elasticsearchTemplate.index(indexQuery, IndexCoordinates.of("sys_user"));
        return sys_user;
    }

    /**
     * <p>
     * 批量信息
     * </p>
     *
     * @param
     * @return void
     * @version 1.0.0
     * @author hai ji
     * @since 2022/2/9
     */
    public void insertItemDocBulk() {
        List<IndexQuery> list = new ArrayList<>();
        list.add(new IndexQueryBuilder().withObject(UserEntity.builder().id(System.currentTimeMillis()).brand("javayh").images("es.png").price(2020.29).title("Java有货").build()).build());
        list.add(new IndexQueryBuilder().withObject(UserEntity.builder().id(System.currentTimeMillis() + 1).brand("javayh").images("es.png").price(2020.29).title("Java有货").build()).build());
        elasticsearchTemplate.bulkIndex(list, IndexCoordinates.of("sys_user"));
    }

}
