package com.java.spel.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventor {
    private String name;
    private Date time;
    private String pwd;
}
