package service.interfaces;

import java.util.List;

import dto.StudentDTO;

public interface IStudentService {

	public List<StudentDTO> getStudents();

	public void save(StudentDTO studentDTO);

	public StudentDTO get(int index);

}
