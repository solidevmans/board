package com.soli.dev.common.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseDto {
    private String regId;
    private LocalDateTime createdAt;
    private String updateId;
    private LocalDateTime updatedAt;
}
