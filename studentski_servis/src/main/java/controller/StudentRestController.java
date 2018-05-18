package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import dto.StudentDTO;
import service.interfaces.IStudentService;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
	@Autowired
	IStudentService studentService;
	
	@RequestMapping("/all")
	public List<StudentDTO> getStudents()
	{
		return studentService.getStudents();
	}
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public StudentDTO save(
			@RequestBody
			@Valid
			StudentDTO studentDTO) {
		System.out.println("\nPOGODIO");
		studentService.save(studentDTO);
		return studentDTO;
	}

}
