public class Person {
	Person(final String firstName, final String lastName, final Date birthDate) {
		m_firstName = firstName;
		m_lastName  = lastName;
		m_birthDate = birthDate;
	}

	Person(final Person other) {
		m_firstName = other.m_firstName;
		m_lastName  = other.m_lastName;
		m_birthDate = other.m_birthDate;
	}

	public String get_first_name() {
		return m_firstName;
	}

	public String get_last_name() {
		return m_lastName;
	}

	public Date get_birth_date() {
		return m_birthDate;
	}

	public void set_first_name(final String newFirstName) {
		m_firstName = newFirstName;
	}

	public void set_last_name(final String newLastName) {
		m_lastName = newLastName;
	}

	private String m_firstName;
	private String m_lastName;
	private final Date m_birthDate;
}