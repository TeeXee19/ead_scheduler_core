
package com.interra.ead_scheduler_core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ESResponse {
    
     @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer responseCode;

    private String responseMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object responseResult;
    
      public HttpHeaders buildHeaders(){

        HttpHeaders headers = new HttpHeaders();
        headers.set("Cache-Control", "no-store");
        headers.set("Pragma", "no-cache");

        return headers;
    }
    
}
