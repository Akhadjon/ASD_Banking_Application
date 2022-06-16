package project.framwork.util;

import java.util.Random;

public class CodeGenerator implements AccNumGenerator {
    private CodeGenerator() {
    }
    private final static CodeGenerator AccountGeneratorInstance = new CodeGenerator();
    public static CodeGenerator myAccountGenerator(){
        return AccountGeneratorInstance;
    }

    @Override
    public String generateCode() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
