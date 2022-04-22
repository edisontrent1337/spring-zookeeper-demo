package com.trent.labs.springzookeeperdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class DataPoint {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @Builder.Default
    @JsonProperty
    private List<String> blacklist = Collections.emptyList();
}
