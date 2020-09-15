public class Date {
	Date(int day, int month, int year) {
		m_year = year;
		m_month = month;
		m_day = day;
	}

	public int year() {
		return m_year;
	}

	public int month() {
		return m_month;
	}

	public int day() {
		return m_day;
	}

	public String toString() {
		String monthStr = Integer.toString(m_month);
		if (m_month < 10)
			monthStr = "0" + monthStr;
		return Integer.toString(m_day) + "." + Integer.toString(m_month) + "." + Integer.toString(m_year);
	}

	private final int m_year;
	private final int m_month;
	private final int m_day;
}