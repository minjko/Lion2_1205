package app.controller;

import app.dto.EmpUpdateDto;
import app.dto.EmpUpdateRequest;
import app.entity.Dept;
import app.entity.Emp;
import app.repository.DeptRepository;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Emp;
import app.repository.EmpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RequiredArgsConstructor
@RestController
public class EmpAPIController {

    private final EmpRepository empRepository;
    private final DeptRepository deptRepository;
    
    @GetMapping("/api/emps")
    public List<Emp> getEmps() {
    	List<Emp> emps = empRepository.findAll();
    	
    	if (emps != null) {
    		return emps;
    	} else {
    		return "{\"msg\":\"사원정보가 존재하지 않습니다\"}";
    	}
    	
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
}