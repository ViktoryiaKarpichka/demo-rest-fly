package com.example.demorestfly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity of Book")
public class BookDto implements Serializable {
    @Schema(description = "Identifier", example = "1")
    @Min(1)
    private Long id;
    @Schema(description = "Book`s name", example = "Book1")
    private String name;
    @Schema(description = "Book`s description", example = "description1")
    @JsonProperty("description")
    private String desc;
}
