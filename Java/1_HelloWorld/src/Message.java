public class Message {
  Message(String text) {
    m_text = text;
  }
  public String get_text() {
    return m_text;
  }
  private final String m_text;
}