import javax.naming.NameAlreadyBoundException;

class EncodeDecode {
    public String encode(String[] tokens) {
        StringBuilder encodedString = new StringBuilder("");

        for (int i = 0; i < tokens.length; i++) {
            if (i == tokens.length - 1) {
                encodedString.append(tokens[i]);
            } else {
                encodedString.append(tokens[i] + "#");
            }
        }

        return new String(encodedString);
    }

    public String[] decode(String encodedString) {
        String[] decodedTokens = new String[]{};

        decodedTokens = encodedString.split("#");
        return decodedTokens;
    }

    public static void main(String[] args) {
        EncodeDecode ed = new EncodeDecode();
        String res = ed.encode(new String[]{"bat", "shit", "cow"});
        System.out.println(res);

        for (String token: ed.decode(res)) {
            System.out.println(token);
        }

    }
}
