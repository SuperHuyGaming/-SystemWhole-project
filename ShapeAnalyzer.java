import java.sql.SQLOutput;

public class ShapeAnalyzer {
    private static final Object EMPTY_PROPERTY = new Object();

    public static Machine analyze(String json) {
        String[][] parseEntriesResult = parseEntries(json); //parses json into a 2D array
        String reifyKindMethodCall = reifyKind(parseEntriesResult); // @return String "kind" value
        Object[] reifyPropertiesMethodCall = reifyProperties(parseEntriesResult); // @return Object array of PartState
        //properties

        return new Machine(reifyKindMethodCall, reifyPropertiesMethodCall, SystemWhole.isHumanoid(reifyPropertiesMethodCall));
        // @return machine object for each emergence


//        parseEntries(json);
//        }
//        return; //something for machine class


    }

    public static String[][] parseEntries(String flatJson) {
        String[][] splitString = new String[flatJson.split(",", 0).length][];

        for (int i = 0; i < splitString.length; i++) {
            splitString[i] = new String[2]; // create null subarray so splitsString[i] exists
            String[] smallSplitString = (flatJson.split(",", 0)[i]).split(":", 0);
            // smallSplitString is an array that the flatJson string is split twice
            for (int j = 0; j < smallSplitString.length; j++) {
                smallSplitString[j] = smallSplitString[j].replaceAll("\"", "");
                smallSplitString[j] = smallSplitString[j].replaceAll("\\{", "");
                smallSplitString[j] = smallSplitString[j].replaceAll(" ", "");
                smallSplitString[j] = smallSplitString[j].replaceAll("}", "");
                //syntax the string so it's more neat
                splitString[i][j] = smallSplitString[j];
                // assign each element into splitString

            }
        }
        return splitString;


    }

    public static String reifyKind(String[][] entries) {
        for (int i = 0; i < entries.length; i++) {
            for (int a = 0; a < entries[i].length; a++) {
                if (entries[i][a].equals("kind")) {
                    return entries[i][a + 1];
                }
            }
        }
        return null;
    }

    public static Object[] reifyProperties(String[][] entries) {
        int j = 0;
        Object[] properties = new String[entries.length - 1];
        for (int i = 0; i < entries.length; i += 1) {
            if (!(entries[i][0].equals("kind"))) {

                PartState innit = new PartState(entries[i][0], entries[i][1]);//creates PartState objects from
                // 1 property and 1 value
                properties[j] = innit.toString(); // add that object to properties array
                j++;
            }
        }
        return properties;
    }

    public static boolean isDigit(char c) {
        //@return true if c is a digit
        return "1234567890".contains(String.valueOf(c));
    }

    public static boolean hasNonNumbers(String value) {
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i); // let c be the character at i in value string
            if (!(isDigit(c) || c == '_' || c == '.')) {
                //@return true if character c is not digits or _ or .
                return true;

            }
        }
        return false;
    }

    public static Object inferObject(String value) {
        if ((value == null) || (value.isEmpty())) {
            // @return EMPTY_PROPETY if value is null
            return EMPTY_PROPERTY;
        }
        if (!hasNonNumbers(value)) {
            if (value.contains(".")) {
                //convert value to Double type if there is a . in the string
                return (Double.valueOf(value));

            }
            // convert value to Integer type if it passes hasNonNumbers check
            return (Integer.valueOf(value));

        }
        // if value doesn't pass any check, return value
        return value;
    }

//    public static void main(String[] args) {
//        String value = "222";
//        System.out.println(inferObject(value).getClass().getSimpleName());
//        int value2 = 2___2;

//    }
}
