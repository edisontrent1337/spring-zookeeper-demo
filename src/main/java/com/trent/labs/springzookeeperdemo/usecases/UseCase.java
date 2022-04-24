package com.trent.labs.springzookeeperdemo.usecases;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UseCase {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
