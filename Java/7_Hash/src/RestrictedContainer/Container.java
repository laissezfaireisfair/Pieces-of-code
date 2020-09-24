package RestrictedContainer;

public class Container {
    private static final String mText;
    private static final String mAnswerToWrong;
    private static final int mLoginHash;
    private static final int mPasswordHash;

    static {
        mText = "Welcome to the club, buddy! *slap*";
        mAnswerToWrong = "Wrong credentials, hacker!";
        mLoginHash = 96327377;
        mPasswordHash = -627014902;
    }

    public static String getText(final String login, final String password) {
        if (login.hashCode() == mLoginHash && password.hashCode() == mPasswordHash) {
            return mText;
        } else {
            return mAnswerToWrong;
        }
    }
}
