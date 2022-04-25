package com.trent.labs.springzookeeperdemo.datapoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Builder
@Data
public class DataPointMetaData {
    private List<Item> items;
    @JsonIgnoreProperties
    @ToString
    public static class Item {
        @JsonProperty
        private String unitCode;
        @JsonProperty
        private String id;
        @JsonProperty
        private String hexCode;
    }
}
