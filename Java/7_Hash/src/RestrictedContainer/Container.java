package RestrictedContainer;

import java.util.List;
import java.util.ArrayList;

public class Container {
    private final List<Integer> mEncryptedText;

    public Container(final int loginHash, final int passwordHash, final String text) {
        mEncryptedText = new ArrayList<Integer>(text.length());
        for (char symbol : text.toCharArray()) {
            final int code = (int)(symbol) ^ loginHash ^ passwordHash;
            mEncryptedText.add(code);
        }
    }

    public Container(final String encryptedText) {
        mEncryptedText = new ArrayList<Integer>(encryptedText.length());
        for (char i : encryptedText.toCharArray()) {
            mEncryptedText.add((int) i);
        }
    }

    public String getEncrypted() {
        StringBuilder stringBuilder = new StringBuilder(mEncryptedText.size());
        for (int i : mEncryptedText) {
            final Character symbol =(char)(i);
            stringBuilder.append(symbol);
        }
        return stringBuilder.toString();
    }

    public String getText(final int loginHash, final int passwordHash) {
        StringBuilder stringBuilder = new StringBuilder(mEncryptedText.size());
        for (int i : mEncryptedText) {
            final Character symbol =(char)(i ^ passwordHash ^ loginHash);
            stringBuilder.append(symbol);
        }
        return stringBuilder.toString();
    }
}
