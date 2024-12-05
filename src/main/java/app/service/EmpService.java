package app.service;

import app.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmpService {

    private final EmpRepository empRepository;


}
