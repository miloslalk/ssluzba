package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dto.StudentDTO;

import model.Student;
import repository.StudentRepository;
import service.interfaces.IStudentService;

@Service
public class StudentService implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	


	@Override
	public List<StudentDTO> getStudents() {
	
		return studentRepository.findAll().stream()
				.map(x->new StudentDTO(x))
				.collect(Collectors.toList());
		
		
	}



	@Override
	public void save(StudentDTO studentDTO) {
		Student student;
		System.out.println("\n USAO U SAVE");
		if(studentDTO.getIndex() == 0) {
			student = new Student();
			
			student.setIme(studentDTO.getIme());
			student.setPrezime(studentDTO.getPrezime());
		//	student.setGodinaRodjenja(studentDTO.getDatumS()); Konvertovati u Datum
			student.setHobi(studentDTO.getHobi());
			student.setPol(studentDTO.getPol());
			student.setSport(studentDTO.getSport());
			
		} else {
			student = studentRepository.findById(studentDTO.getIndex()).orElse(null);
			if (student == null) {
				//throw new CustomException("no student with that ID", HttpStatus.NOT_FOUND);
				//za sad
				System.out.println("DJE SI POSO MAJKANE");
			}
			student.setIme(studentDTO.getIme());
			student.setPrezime(studentDTO.getPrezime());
			student.setGodinaRodjenja(studentDTO.getGodRodjenja());
			student.setHobi(studentDTO.getHobi());
			student.setPol(studentDTO.getPol());
			student.setSport(studentDTO.getSport());
		}
		studentRepository.save(student);
		
	}



	@Override
	public StudentDTO get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
