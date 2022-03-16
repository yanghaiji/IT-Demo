package com.javayh.elaticsearh.docment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.elaticsearh.docment → UserEntity
 * @since 2022-02-09
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "sys_user")
public class UserEntity {
    @Id
    private Long id;
    // title使用ik进行分词
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    // brand 不被分词
    @Field(type = FieldType.Keyword)
    private String brand;
    @Field(type = FieldType.Double)
    private Double price;
    // images 不被分词，且不创建索引
    @Field(index = false, type = FieldType.Keyword)
    private String images;
}
