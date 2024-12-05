package app.dto;

import app.entity.Emp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpUpdateDto {
    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    private LocalDate hiredate;

    private Double sal;

    private Double comm;

    public static EmpUpdateDto of(EmpUpdateRequest request) {
        return EmpUpdateDto.builder()
                .empno(request.getEmpno())
                .ename(request.getEname())
                .job(request.getJob())
                .mgr(request.getMgr())
                .hiredate(request.getHiredate())
                .sal(request.getSal())
                .comm(request.getComm())
                .build();
    }
}
