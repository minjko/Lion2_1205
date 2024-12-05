package app.controller;

import app.entity.Dept;
import app.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DeptAPIController {

    private final DeptService deptService;

    @GetMapping("/test")
    public String deptApi() {
        return "dept api controller";
    }

    @GetMapping("/app")
    public String appApi() {
        return "Project Changed";
    }

    @GetMapping("/depts")
    public List<Dept> getDepts() {
        List<Dept> depts = deptService.getDepts();
        return depts;
    }

    @GetMapping("/depts/{deptno}")
    public Dept getDeptByDeptno(@PathVariable Integer deptno) {
        Dept dept = deptService.getDeptByDeptno(deptno);
        return dept;
    }

    @PostMapping("/depts")
    public Dept registerDept(@RequestBody Dept newDept) {
        Dept dept = deptService.registerDept(newDept);
        return dept;
    }

    @PutMapping("/depts/{deptno}")
    public Dept updateDept(@RequestBody Dept updateDept, @PathVariable Integer deptno) {
        Dept dept = deptService.updateDept(updateDept, deptno);
        return dept;
    }

    @DeleteMapping("/depts/{deptno}")
    public Dept deleteDeptByDeptno(@PathVariable Integer deptno) {
        Dept dept = deptService.deleteDeptByDeptno(deptno);
        return dept;
    }
}

