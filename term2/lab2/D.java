import java.io.*;
import java.util.*;

public class D {
    private static final int MOD = 1000000007;
    private static final List<List<List<Long>>> dynamicProgMatrix = new ArrayList<>();
    private static final List<StringTransformation> transformations = new ArrayList<>();
    private static final List<CharacterPair> singleCharTransforms = new ArrayList<>();

    private static class CharacterPair {
        private final Character source;
        private final Character target;

        public CharacterPair(Character source, Character target) {
            this.source = source;
            this.target = target;
        }
    }

    private static class StringTransformation {
        private final Character source;
        private final String target;

        public StringTransformation(Character source, String target) {
            this.source = source;
            this.target = target;
        }
    }

    private static void buildDynamicProgMatrix(String input) {
        int len = input.length();
        for (int i = 0; i < 54; i++) {
            dynamicProgMatrix.add(new ArrayList<>());
            for (int j = 0; j < len; j++) {
                dynamicProgMatrix.get(i).add(new ArrayList<>());
                for (int k = 0; k < len; k++) {
                    long tmp = 0;
                    dynamicProgMatrix.get(i).get(j).add(tmp);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (CharacterPair pair : singleCharTransforms) {
                if (pair.target == input.charAt(i)) {
                    char transformCharIndex = (char) (pair.source - 'A');
                    long tmp = 1;
                    dynamicProgMatrix.get(transformCharIndex).get(i).set(i, tmp);
                }
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                for (StringTransformation transformation : transformations) {
                    for (int u = 0; u < i; u++) {
                        char sourceCharIndex = (char) (transformation.source - 'A');
                        char firstCharIndex = (char) (transformation.target.charAt(0) - 'A');
                        char secondCharIndex = (char) (transformation.target.charAt(1) - 'A');
                        long count = dynamicProgMatrix.get(sourceCharIndex).get(j).get(j + i)
                                + dynamicProgMatrix.get(firstCharIndex).get(j).get(j + u)
                                * dynamicProgMatrix.get(secondCharIndex).get(j + u + 1).get(j + i);
                        dynamicProgMatrix.get(sourceCharIndex).get(j).set(j + i, count % MOD);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("nfc.in"));
        String[] input = reader.readLine().split(" ");
        int numTransformations = Integer.parseInt(input[0]);
        char initialChar = input[1].charAt(0);

        for (int i = 0; i < numTransformations; i++) {
            input = reader.readLine().split(" ");
            char source = input[0].charAt(0);
            String target = input[2];
            if (target.length() == 2) {
                transformations.add(new StringTransformation(source, target));
            } else {
                singleCharTransforms.add(new CharacterPair(source, target.charAt(0)));
            }
        }

        String inputString = reader.readLine();
        reader.close();

        buildDynamicProgMatrix(inputString);

        BufferedWriter writer = new BufferedWriter(new FileWriter("nfc.out"));
        writer.write(Long.toString(dynamicProgMatrix.get(initialChar - 'A').get(0).get(inputString.length() - 1)));
        writer.newLine();
        writer.close();
    }
}