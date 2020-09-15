public class User extends Person {
	User(final String firstName, final String lastName, final Date birthDate, final String email) {
		super(firstName, lastName, birthDate);
		m_email = email;
		m_codeID = counter++;
	}
	User(final User other) {
		super(other);
		m_email = other.m_email;
		m_codeID = other.m_codeID;
	}

	public String get_email() {
		return m_email;
	}

	public Long get_ID_code() {
		return m_codeID;
	}

	public Boolean equal(final User other) {
		return m_codeID == other.m_codeID;
	}

	public void set_email(final String newEmail) {
		m_email = newEmail;
	}

	private final long m_codeID;
	private String m_email;
	private static long counter = 1;
}