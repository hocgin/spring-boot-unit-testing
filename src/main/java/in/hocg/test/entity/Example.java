package in.hocg.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author hocgin
 */
@Data
@Entity
@Table(name = "example")
public class Example implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "value")
    private String value;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
}
