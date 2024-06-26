package Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MonthCaculator {

    private List<Integer> toArray = new ArrayList<>();

    public String getSumMonth(String input) { //ລວມເດືອນ
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();
        while (matcher.find()) {
            output.append(matcher.group()).append(", ");
        }
        output.setLength(output.length() - 2);
        return "[" + output.toString() + "]";
    }

    public String getArrangeMonth(String str) { // ລຽງຕົວເລກເດືອນຕາມລະດັບ
        String data = str;
        if (str.equals("[]")) {
            return "[]";
        } else {
            String[] numbersArray = data.substring(1, data.length() - 1).split(", ");
            int[] numbers = new int[numbersArray.length];
            for (int i = 0; i < numbersArray.length; i++) {
                numbers[i] = Integer.parseInt(numbersArray[i]);
            }
            Arrays.sort(numbers);
            ArrayList strlist = new ArrayList();
            for (int num : numbers) {
                strlist.add(num);
            }
            return strlist.toString();
        }
    }

    public String getMissingMonth(String missingValue) {
        String value = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]";
        if (missingValue.equals("[]")) {
            return value;
        } else {
            List<Integer> missingNumbers = new ArrayList<>();
            // Convert the string values to arrays of integers
            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            int[] missingNumbersArray = parseMonth(missingValue);
            // Create a HashSet to store the missing numbers
            HashSet<Integer> missingSet = new HashSet<>();
            for (int num : missingNumbersArray) {
                missingSet.add(num);
            }
            // Iterate over the numbers array and check for missing values
            for (int num : numbers) {
                if (!missingSet.contains(num)) {
                    missingNumbers.add(num);
                }
            }
            toArray.clear();
            toArray = missingNumbers;
            String payFull = missingNumbers.toString();
            return payFull.equals("[]") ? "ຈ່າຍຄົບຖ້ວນ" : payFull;
        }
    }

    public List<Integer> getToArray() {
        return toArray;
    }

    public int[] parseMonth(String missingMonth) {
        missingMonth = missingMonth.equals("[]") ? "" : missingMonth;
        String strmonth = missingMonth.equals("") ? "," : missingMonth;
        String nullMonth = strmonth.replaceAll("\\[],", "");
        String cleanedString = nullMonth.replaceAll("\\[|\\]|\\s", "");
        // Split the cleaned string by comma
        String[] stringArray = cleanedString.split(",");
        // Convert the string array to an integer array
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    public List<Integer> StringToArray(String str) {
        List<Integer> arr = new ArrayList<>();
        String result = str.replaceAll("\\[\\],\\s*", "").trim();
        if (result.equals("[]")) {
            arr.add(0);
            return arr;
        } else {
            String[] numbersArray = result.replaceAll("[\\[\\]]", "").split(",");
            for (String numbersArray1 : numbersArray) {
                arr.add(Integer.valueOf(numbersArray1.trim()));
            }
            return arr;
        }
    }

    public List<Integer> ToArrayMonth(String months) {
        // Remove "[" and "]" characters
        String cleanedInput = months.replaceAll("\\[", "").replaceAll("\\]", "");
        // Split the cleaned string into individual elements
        if (!cleanedInput.equals("[]")) {
            String[] elements = cleanedInput.split(",\\s*");
            // Create an int array to store the resul
            List<Integer> result = new ArrayList<>();
            // Convert each element to int and store in the result array
            for (String element : elements) {
                System.out.println(element);
                if (element.trim().equalsIgnoreCase("null") || element.equals("")) {
                    // Use a special value or handle as needed for null
                    result.add(0);
                } else {
                    int data = Integer.parseInt(element.trim());
                    result.add(data);
                }
            }
            result.removeIf(item -> item == 0);
            return result;
        } else {
            return null;
        }
    }

    public List<Integer> getFormatAllMonthToArray(String months) {
        if (!months.isEmpty() && !months.isBlank()) {
            String[] parts = months.replaceAll("[\\[\\]]", "").split(",\\s*");
            // Filter out empty strings and convert to integers
            List<Integer> result = Arrays.stream(parts)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return result;
        } else {
            List<Integer> result = new ArrayList<>();
            return result;
        }
    }

}
