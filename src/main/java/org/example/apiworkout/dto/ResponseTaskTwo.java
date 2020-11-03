package org.example.apiworkout.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTaskTwo {

    private Long id;
    private String name;
    private String description;
}
