package com.javayh.jxls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-06-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private String name;
    private Employee chief;
    private List<Employee> staff = new ArrayList<Employee>();
    private String link;

}



