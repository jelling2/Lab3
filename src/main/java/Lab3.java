 import java.io.IOException;
    import java.net.URL;
    import java.util.Scanner;
public class Lab3 {


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
            try {
                urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
            } catch (IOException e) {
                return "";
            }
            String contents = urlScanner.useDelimiter("\\A").next();
            urlScanner.close();
            return contents;
}
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String text = (urlToString("http://erdani.com/tdpl/hamlet.txt"));
        int wordCount = 0;
        boolean prevCharacterWasSpace =true;
        for (int i =0; i < text.length(); i++) {
            if(text.charAt(i) == ' ') {
                prevCharacterWasSpace =true;
            }
            else {
                if (prevCharacterWasSpace) {
                    wordCount++;
                    prevCharacterWasSpace =false;

                }
            }
        }
        System.out.println(wordCount);
    }
}

