package app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Dept {
    @Id
    @Column(name = "deptno")
    private Integer deptno;

    @Column(name="dname")
    private String dname;

    @Column(name = "loc")
    private String loc;

}
