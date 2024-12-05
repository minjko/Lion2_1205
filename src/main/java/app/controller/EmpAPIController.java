package app.controller;

import app.entity.Emp;
import app.repository.EmpRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmpAPIController {

    private final EmpRepository empRepository;

    
    @DeleteMapping("/emp/{empno}")
    public Emp deleteEmpByEmpno(@PathVariable Integer empno) {
    	Emp emp = empRepository.findById(empno).orElseThrow();
    	empRepository.deleteById(emp.getEmpno());
    	return emp;
    }

}