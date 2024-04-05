package com.userservice.responseentities;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EResponse  {
    private String message;
    private boolean success;
    private HttpStatus status;
}
