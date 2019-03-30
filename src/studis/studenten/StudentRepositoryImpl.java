package studis.studenten;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class StudentRepositoryImpl implements StudentRepository {
	private Map<String, Student> repo = new ConcurrentHashMap<>();

	@Override
	public void saveOrUpdate(Student student) {
		repo.put(student.getMatrikelnummer(), student);
	}

	@Override
	public Collection<Student> findAll() {
		return repo.values();
	}

	@Override
	public Optional<Student> findByMatrikelnummer(String matrikelnummer) {
		Student result = repo.get(matrikelnummer);
		return Optional.ofNullable(result);
	}

	@Override
	public Optional<Student> findOldestStudent() {
		return repo.values().stream().sorted((Student o1, Student o2) -> {
			return o1.getGeburtstag().compareTo(o2.getGeburtstag());
		}).findFirst();

	}

	@Override
	public Collection<Student> findByNachname(String nachname) {
		return repo.values().stream().filter(compareNachname(nachname)).collect(Collectors.toSet());
	}

	private Predicate<? super Student> compareNachname(String nachname) {
		return s -> s.getNachname().equals(nachname);
	}

}
