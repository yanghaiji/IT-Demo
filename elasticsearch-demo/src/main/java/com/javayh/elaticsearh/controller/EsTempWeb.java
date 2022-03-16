package com.javayh.elaticsearh.controller;

import com.javayh.elaticsearh.docment.UserEntity;
import com.javayh.elaticsearh.template.EsRestTemplateImpl;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateResponse;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.elaticsearh.controller → EsWeb
 * @since 2022-02-09
 */
@RequestMapping(value = "/es")
@RestController
public class EsTempWeb {
    @Autowired
    private EsRestTemplateImpl restTemplate;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @PutMapping
    public void save() {
        restTemplate.index();
        restTemplate.create();
        restTemplate.insertItemDocBulk();
    }


    /**
     * <p>
     * 删除索引
     * </p>
     *
     * @param
     * @return void
     * @version 1.0.0
     * @author hai ji
     * @since 2022/2/9
     */
    @DeleteMapping
    public void del() {
        elasticsearchTemplate.delete("1", IndexCoordinates.of("sys_user"));

        // 自定义删除
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.termQuery("title", 1214666))
                .build();
        elasticsearchTemplate.delete(nativeSearchQuery, UserEntity.class, IndexCoordinates.of("sys_user"));
    }

    /**
     * <p>
     * 更新
     * </p>
     *
     * @param
     * @return void
     * @version 1.0.0
     * @author hai ji
     * @since 2022/2/9
     */
    @PostMapping
    public void update() {
        Document document = Document.create();
        document.put("title", 1214666);
        document.put("price", 66.6);
        UpdateQuery updateQuery = UpdateQuery.builder("164439571754").withDocument(document).build();
        // 单条更新
        UpdateResponse response = elasticsearchTemplate.update(updateQuery, IndexCoordinates.of("sys_user"));
        System.out.println(response.getResult().name());
        // 批量更新
        List<UpdateQuery> list = new LinkedList<>();
        list.add(updateQuery);
        elasticsearchTemplate.bulkUpdate(list, IndexCoordinates.of("sys_user"));
    }

    /**
     * <p>
     * 自定义查询
     * </p>
     *
     * @param
     * @return org.springframework.data.elasticsearch.core.SearchHits<com.javayh.elaticsearh.docment.UserEntity>
     * @version 1.0.0
     * @author hai ji
     * @since 2022/2/10
     */
    @GetMapping
    public SearchHits<UserEntity> get() {
        // 构建查询条件
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.termQuery("title", 1214666))
                .build();
        return elasticsearchTemplate.search(nativeSearchQuery, UserEntity.class, IndexCoordinates.of("sys_user"));
    }


    @GetMapping("/agg")
    public SearchHits<UserEntity> agg() {
        // 构建查询条件
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .addAggregation(AggregationBuilders.terms("titles").field("title.keyword"))
                .addAggregation(AggregationBuilders.sum("price sum").field("price"))
                .build();
        SearchHits<UserEntity> search = elasticsearchTemplate.search(nativeSearchQuery, UserEntity.class);
        return search;
    }


    @GetMapping("/filter")
    public SearchHits<UserEntity> filter() {
        // 构建查询条件
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .addAggregation(AggregationBuilders.filter("titles", QueryBuilders.termQuery("title", 1214666)))
                .build();
        SearchHits<UserEntity> search = elasticsearchTemplate.search(nativeSearchQuery, UserEntity.class);
        return search;
    }


}
