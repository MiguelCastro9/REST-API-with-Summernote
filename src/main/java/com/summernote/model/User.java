package com.summernote.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Miguel Castro
 */
@Entity
@Data
@Table(name = "users")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Please fill in your name.")
    @Size(max = 45, min = 3, message = "The name must contain between {min} to {max} characters.")
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "date_now", nullable = false)
    private LocalDateTime dateNow;
    
    @NotBlank(message = "Please fill in your profession.")
    @Size(max = 45, min = 3, message = "The profession must contain between {min} to {max} characters.")
    @Column(name = "profission", nullable = false)
    private String profission;
    
    @NotBlank(message = "Please fill in your biography.")
    //@Size(max = 255, message = "Biography must contain a maximum of {max} characters.")
    @Column(name = "biography", nullable = false, columnDefinition = "TEXT")
    private String biography;
}
