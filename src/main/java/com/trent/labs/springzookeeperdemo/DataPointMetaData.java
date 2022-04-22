package com.trent.labs.springzookeeperdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class DataPointMetaData {
    @JsonProperty
    private String name;
    @JsonProperty
    private String id;
}
