package com.javayh.advanced.flink.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream.window → UrlViewCount
 * @since 2022-06-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlViewCount {

    public String url;
    public Long next;
    public Long start;
    public Long end;

}
