public class Date {
	Date(int year, int month, int day) {
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
	private final int m_year;
	private final int m_month;
	private final int m_day;
}