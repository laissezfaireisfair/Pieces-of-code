package Encoder;

import java.util.List;
import java.util.ArrayList;

public class Container {
    private final List<Integer> mEncryptedText;

    // Constructor for encoding
    public Container(final int loginHash, final int passwordHash, final String text) {
        mEncryptedText = new ArrayList<>(text.length());
        int stepModifier = 0;
        for (char symbol : text.toCharArray()) {
            final int code = (int)(symbol) ^ loginHash ^ passwordHash ^ stepModifier;
            mEncryptedText.add(code);
            stepModifier = (int) (((long) stepModifier + 1) % (long)Integer.MAX_VALUE);
        }
    }

    // Constructor for decoding
    public Container(final String encryptedText) {
        mEncryptedText = new ArrayList<>(encryptedText.length());
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
        int stepModifier = 0;
        for (int i : mEncryptedText) {
            final Character symbol =(char)(i ^ passwordHash ^ loginHash ^ stepModifier);
            stringBuilder.append(symbol);
            stepModifier = (int) (((long) stepModifier + 1) % (long)Integer.MAX_VALUE);
        }
        return stringBuilder.toString();
    }
}
