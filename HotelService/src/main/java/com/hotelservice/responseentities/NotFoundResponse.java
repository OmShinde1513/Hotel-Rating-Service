package com.hotelservice.responseentities;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotFoundResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
