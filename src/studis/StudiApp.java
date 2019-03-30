package studis;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Optional;

import studis.studenten.Student;
import studis.studenten.StudentRepository;

public class StudiApp {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");

	public static void main(String[] args) {
		StudentRepository repo = new StudentRepository();

		repo.saveOrUpdate(new Student("q1", "Peter", "Müller", LocalDate.of(1980, 7, 12)));
		repo.saveOrUpdate(new Student("q2", "Werner", "Meyer", LocalDate.parse("2000-04-01")));
		repo.saveOrUpdate(new Student("q3", "Frauke", "Stein", LocalDate.now()));
		repo.saveOrUpdate(
				new Student("q4", "Claudia", "Falke", LocalDate.ofInstant(Instant.now(), ZoneId.of("Europe/Berlin"))));
		repo.saveOrUpdate(new Student("q5", "Wolfgang", "Gut", LocalDate.of(1960, 2, 28)));
		repo.saveOrUpdate(new Student("q6", "Per", "Ulrich", LocalDate.of(1971, 12, 24)));
		repo.saveOrUpdate(new Student("q7", "Pia", "Schiffa", LocalDate.of(1900, 1, 1)));

		Collection<Student> findByNachname = repo.findByNachname("Ulrich");
		System.out.println(findByNachname);

		Optional<Student> result = repo.findByMatrikelnummer("q4");

		if (result.isPresent()) {
			System.out.println(result.get());
		}
		
		System.out.println("Der Älteste ist: " + repo.findOldestStudent());
		System.out.println("Formatiert: " + FORMATTER.format(result.get().getGeburtstag()));
	}

}
