package com.pos_system.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {

    private long status_code;
    private String message_status;
    private String message;
    private Object data;

}
