package studis.studenten;

import java.util.Collection;
import java.util.Optional;

public interface StudentRepository {
	StudentRepository INSTANCE = new StudentRepositoryImpl();

	void saveOrUpdate(Student student);

	Collection<Student> findAll();

	Optional<Student> findByMatrikelnummer(String matrikelnummer);

	Optional<Student> findOldestStudent();

	Collection<Student> findByNachname(String nachname);

	static StudentRepository getInstance() {
		return INSTANCE;
	};
}
