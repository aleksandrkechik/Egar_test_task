package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarDto.class),
		@JsonSubTypes.Type(value = AirplaneDto.class),
		@JsonSubTypes.Type(value = AirplaneValuationDto.class),
		@JsonSubTypes.Type(value = CarValuationDto.class)

})
public interface Collateral {
}
