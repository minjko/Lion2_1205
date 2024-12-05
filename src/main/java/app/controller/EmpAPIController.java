package app.controller;


import app.entity.Emp;

import app.dto.EmpUpdateDto;
import app.dto.EmpUpdateRequest;

import app.entity.Dept;
import app.entity.Emp;
import app.repository.DeptRepository;

import app.repository.EmpRepository;

import app.request.EmpRequest;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


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

    @GetMapping("/api/emp/{id}")
    public Emp getEmpById(@PathVariable Integer id) {
        return empRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("사원 정보가 존재하지 않습니다."));
    }

    @PutMapping("/api/emp/{id}")
    @Transactional
    public Emp updateEmp(@PathVariable Integer id, @RequestBody EmpUpdateRequest update) {
        Emp emp = empRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("사원 정보가 존재하지 않습니다."));

        EmpUpdateDto dto = EmpUpdateDto.of(update);
        Dept dept = deptRepository.findById(update.getDeptno())
                .orElseThrow(() -> new NoSuchElementException("부서 정보가 존재하지 않습니다."));

        emp.update(dto, dept);
        return emp;
    }

    @DeleteMapping("/emp/{empno}")
    public Emp deleteEmpByEmpno(@PathVariable Integer empno) {
    	Emp emp = empRepository.findById(empno).orElseThrow();
    	empRepository.deleteById(emp.getEmpno());
    	return emp;
    }
}
