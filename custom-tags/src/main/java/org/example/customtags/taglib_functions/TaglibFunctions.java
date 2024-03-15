package org.example.customtags.taglib_functions;

import java.util.Date;

public class TaglibFunctions {
    public static String replaceCertainString(String source, String target, String replacement) {
        return source.replaceAll(target, replacement);
    }

    public static String reverseString(String source) {
        StringBuilder builder = new StringBuilder();
        for(int i = source.length()-1; i > -1; --i) {
            builder.append(source.charAt(i));
        }
        return builder.toString();
    }

    public static Date dateNow() {
        return new Date();
    }
}
