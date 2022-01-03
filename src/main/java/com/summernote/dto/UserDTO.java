package com.summernote.dto;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author Miguel Castro
 */
@Data
public class UserDTO {

    private Long id;

    private String name;

    private LocalDateTime dateNow;

    private String profission;

    private String biography;
}
