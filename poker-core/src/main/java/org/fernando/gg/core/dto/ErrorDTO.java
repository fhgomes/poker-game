package org.fernando.gg.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDTO {
    @JsonProperty("code")
    private Long code;
    @JsonProperty("messageKey")
    private String messageKey;

    @JsonProperty("detail")
    private String detail;

    public ErrorDTO(Long code, String messageKey, String detail) {
        this.code = code;
        this.messageKey = messageKey;
        this.detail = detail;
    }

    public ErrorDTO(Long code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }
}