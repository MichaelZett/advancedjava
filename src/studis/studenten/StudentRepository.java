package studis.studenten;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentRepository {
	private Map<String, Student> repo = new ConcurrentHashMap<>();
	
	public void saveOrUpdate(Student student) {
		repo.put(student.getMatrikelnummer(), student);
	}
	
	public Collection<Student> findAll() {
		return repo.values();
	}
	
	public Optional<Student> findByMatrikelnummer(String matrikelnummer) {
		Student result = repo.get(matrikelnummer);
		return Optional.ofNullable(result);
	}
	
	public Collection<Student> findByNachname(String nachname) {
		return repo.values().stream().filter(compareNachname(nachname)).collect(Collectors.toSet());
	}

	private Predicate<? super Student> compareNachname(String nachname) {
		return s -> s.getNachname().equals(nachname);
	}
}
