package app.controller;

import app.entity.Dept;
import app.entity.Emp;
import app.repository.DeptRepository;
import app.repository.EmpRepository;
import app.request.EmpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmpAPIController {

    private final EmpRepository empRepository;
    private final DeptRepository deptRepository;


    // 새로운 직원 저장 - 241205
    @PostMapping("/api/emp")
    public Emp registerEmp(@RequestBody EmpRequest empRequest) {

        Dept dept = deptRepository.findById(empRequest.getDeptno()).orElseThrow(); // deptno 로 dept 찾기

        // 새로운 emp 생성
        Emp newEmp = Emp.builder()
                .empno(empRequest.getEmpno())
                .ename(empRequest.getEname())
                .job(empRequest.getJob())
                .mgr(empRequest.getMgr())
                .hiredate(empRequest.getHiredate())
                .sal(empRequest.getSal())
                .comm(empRequest.getComm())
                .dept(dept)
                .build();

        return empRepository.save(newEmp); // 저장
    }


}