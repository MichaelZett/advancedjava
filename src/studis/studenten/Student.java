package studis.studenten;

import java.time.LocalDate;

public class Student {
	private String matrikelnummer;
	private String vorname;
	private String nachname;
	private LocalDate geburtstag;
	
	public Student(String matrikelnummer, String vorname, String nachname, LocalDate geburtstag) {
		super();
		this.matrikelnummer = matrikelnummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtstag = geburtstag;
	}

	public String getMatrikelnummer() {
		return matrikelnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}
	
	public LocalDate getGeburtstag() {
		return geburtstag;
	}

	@Override
	public String toString() {
		return "Student [matrikelnummer=" + matrikelnummer + ", vorname=" + vorname + ", nachname=" + nachname
				+ ", geburtstag=" + geburtstag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matrikelnummer == null) ? 0 : matrikelnummer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (matrikelnummer == null) {
			if (other.matrikelnummer != null)
				return false;
		} else if (!matrikelnummer.equals(other.matrikelnummer))
			return false;
		return true;
	}	

}
