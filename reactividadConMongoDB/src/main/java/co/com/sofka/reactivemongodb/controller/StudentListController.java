package co.com.sofka.reactivemongodb.controller;

import co.com.sofka.reactivemongodb.model.Student;
import co.com.sofka.reactivemongodb.StudentReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class StudentListController {

    // Esta es una interfaz, no hay código! Esta es la magia de Spring Data!
    @Autowired
    private StudentReactiveRepository repository;

    @GetMapping("/list-students")
    public String listStudents(Model model){
        Flux<Student> flux = repository.findAll(); // recuperamos todos los registros de forma reactiva
        model.addAttribute("students", flux); 
        return "students"; // direccionamos al students.html
    }

    /*@GetMapping("/list-students-reactive")
    public String listUsersReactive(Model model)
    {
        Flux<Student> userFlux = repository.findAll();
        model.addAttribute("students", new ReactiveDataDriverContextVariable(userFlux, 50));
        return "students";
    }

    @GetMapping("/list-students-reactive")
    public String listUsersReactive(Model model)
    {
        Flux<Student> userFlux = repository.findAll().delayElements(Duration.ofSeconds(1));
        model.addAttribute("students", new ReactiveDataDriverContextVariable(userFlux, 1));
        return "students";
    }*/

    @GetMapping("/list-students-reactive")
    public String listUsersReactive(Model model)
    {
        Flux<Student> userFlux = repository.findAll().delayElements(Duration.ofSeconds(1));
        model.addAttribute("students", new ReactiveDataDriverContextVariable(userFlux, 50));
        return "students";
    }
}