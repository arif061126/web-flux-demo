package com.webfluxdemo.mapVsFlatMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private List<String> phoneNumbers;
}
