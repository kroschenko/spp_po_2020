public class StringUtils {

    static String keep(String str, String pattern){

        if(str == null & pattern == null){
            throw new NullPointerException();
        }

        if(str == null){
            return null;
        }

        if((str == "") || (pattern == null) || (pattern == "")){
            return "";
        }


        char [] arrStr = str.toCharArray();
        char [] arrPattern = pattern.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(" ");

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < arrPattern.length; j++) {
                if(arrStr[i] == arrPattern[j]){
                    stringBuilder.append(arrStr[i]);
                }
            }
        }

        stringBuilder.append(" ");

        return stringBuilder.toString();
    }
}
