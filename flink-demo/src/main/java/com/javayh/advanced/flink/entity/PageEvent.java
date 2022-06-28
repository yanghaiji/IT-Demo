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
 * @className advanced-demo → com.javayh.advanced.flink.entity → PageEvent
 * @since 2022-06-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageEvent {
    public String name;
    public String url;
    public Long time;
}
