package experiment1;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DFArecognition {
    private Map<String, Map<String, String>> DFATable;
    private ArrayList<String> value;
    private ArrayList<String> state;

    public DFArecognition() {
        DFATable = new HashMap<>();
        value = new ArrayList<>();
        state = new ArrayList<>();
    }

    public ArrayList<String> getSubUtil(String soap, String rgex) {
        ArrayList<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
    }


    public void input(Scanner in) {
        char src = 0;
        String inputValue = in.nextLine();
//        while (inputValue.equals("") && in.hasNextLine()) {
//            inputValue = in.nextLine();
//        }
        value = getSubUtil(inputValue.toString(), "([a-z])");
        //System.out.println(value);
        String inputState = in.nextLine();
//        while (inputState.equals("") && in.hasNextLine()) {
//            inputState = in.nextLine();
//        }
        state = getSubUtil(inputState.toString(), "([a-zA-Z0-9])");
        //System.out.println(state);
        String edge;
        int flag = 0;
        while (in.hasNextLine()) {
            ArrayList<String> table;
            Map<String, String> aMap = new HashMap<>();
            edge = in.nextLine();
            if (edge.equals("")) {
                break;
            }
            String s = edge.substring(0, 1);
            table = getSubUtil(edge.toString(), "(\\S->\\S)");
            table.forEach(x -> aMap.put(x.substring(0, 1), x.substring(3, 4)));
            DFATable.put(s, aMap);
        }
        //System.out.println(DFATable);
    }

    public boolean test(String str) {
        int length = str.length();
        String nowState = "X";
        for (int i = 0; i < length - 1; i++) {
            String nowValue = str.substring(i, i + 1);
            if (DFATable.get(nowState) != null && DFATable.get(nowState).get(nowValue) != null) {
                System.out.println(nowValue);
                nowState = DFATable.get(nowState).get(nowValue);
            } else {
                return false;
            }
        }
        return nowState.equals("Y");
    }

    public static void main(String[] args) throws IOException {
        DFArecognition aDFA = new DFArecognition();
        Scanner in = new Scanner(System.in);
        aDFA.input(in);
        String testStr;
        boolean test;

        while (in.hasNextLine()) {
            testStr = in.nextLine();
//            testStr = in.nextLine();
//            while (testStr.equals("") && in.hasNextLine()) {
//                testStr = in.nextLine();
//            }
            test = aDFA.test(testStr);
            if (test) {
                System.out.println("pass");
            } else {
                System.out.println("error");
            }
        }
    }
}
