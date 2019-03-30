package studis;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import studis.studenten.Student;
import studis.studenten.StudentRepository;

public class StudiApp {

	public static void main(String[] args) {
		StudentRepository repo = new StudentRepository();
		
		repo.saveOrUpdate(new Student("q1", "Peter", "Müller"));
		repo.saveOrUpdate(new Student("q2", "Werner", "Meyer"));
		repo.saveOrUpdate(new Student("q3", "Frauke", "Stein"));
		repo.saveOrUpdate(new Student("q4", "Claudia", "Falke"));
		repo.saveOrUpdate(new Student("q5", "Wolfgang", "Gut"));
		repo.saveOrUpdate(new Student("q6", "Per", "Ulrich"));
		repo.saveOrUpdate(new Student("q7", "Pia", "Schiffa"));

		Collection<Student> findByNachname = repo.findByNachname("Ulrich");
		System.out.println(findByNachname);
		
		Optional<Student> result = repo.findByMatrikelnummer("q4");
		
		if (result.isPresent()) {
			System.out.println(result.get());
		}
	}

}
