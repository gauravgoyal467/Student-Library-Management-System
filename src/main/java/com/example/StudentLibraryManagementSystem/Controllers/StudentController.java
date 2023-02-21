package com.example.StudentLibraryManagementSystem.Controllers;

import com.example.StudentLibraryManagementSystem.DTO.UpdateMobileRequestDTO;
import com.example.StudentLibraryManagementSystem.Models.Student;
import com.example.StudentLibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentService.findNameByEmail(email);
    }

    @GetMapping("/get_user_by_country")
    public List<Student> findByCountry(@RequestParam("country") String country){
        List<Student> students=studentService.findByCountry(country);
        return students;
    }

   /* @PutMapping("/update_mob")
    public String updateMobNo(@RequestBody Student student){
        return studentService.updateMobNo(student);
    }
    */
   @PutMapping("/update_mob")
   public String updateMobNo(@RequestBody UpdateMobileRequestDTO updateMobileRequestDTO){
       return studentService.updateMobNo(updateMobileRequestDTO);
   }

}
