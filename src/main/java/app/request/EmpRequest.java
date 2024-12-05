/*
* EmpRequest.java
* EmpAPIController - Post registerEmp() 처리할 때 사용
* 작성자 : 이홍비 (HIRedrain)
* 작성 일자 : 2024.12.05
*/


package app.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class EmpRequest {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private LocalDate hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
