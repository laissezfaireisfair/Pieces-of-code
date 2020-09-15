public class User {
	User(String firstName, String lastName, Date birthDate) {
		m_firstName = firstName;
		m_lastName  = lastName;
		m_birthDate = birthDate;
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

	private String m_firstName;
	private String m_lastName;
	private final Date m_birthDate;
}