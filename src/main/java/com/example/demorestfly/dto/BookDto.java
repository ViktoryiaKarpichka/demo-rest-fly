package com.example.demorestfly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Entity of Book")
public class BookDto extends BaseDto {

    @Schema(description = "Book`s name", example = "Book1")
    private String name;
    @Schema(description = "Book`s description", example = "description1")
    @JsonProperty("description")
    private String desc;
}
