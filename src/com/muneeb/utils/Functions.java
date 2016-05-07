/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muneeb.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author curio
 */
public class Functions {

    private static String output;
    private static String entityName;

    private static ArrayList<String> list;
    private static ArrayList<String> camelCaseList;
    private static ArrayList<String> titleCaseList;

    private static JTextField entityTextField;
    private static JTextArea sourceTextArea;
    private static JTextArea outputTextArea;

    public static void init(JTextField entyTextField, JTextArea srcTextArea, JTextArea outTextArea) throws IOException {
        output = "";
        entityName = "";

        list = new ArrayList<>();
        camelCaseList = new ArrayList<>();
        titleCaseList = new ArrayList<>();

        entityTextField = entyTextField;

        sourceTextArea = srcTextArea;
        outputTextArea = outTextArea;
    }

    public static String getOutput() {
        return output;
    }

    public static boolean isRequirementComplete() {
        boolean flag = true;

        if (entityTextField.getText().isEmpty() && sourceTextArea.getText().isEmpty()) {
            flag = false;
            String errorMessage = "Entity name and Source Text must not be empty.";
            Functions.log(errorMessage);
            JOptionPane.showMessageDialog(null, errorMessage, "Data is Incomplete", JOptionPane.ERROR_MESSAGE);
        } else if (entityTextField.getText().isEmpty()) {
            flag = false;
            String errorMessage = "Entity name must not be empty.";
            Functions.log(errorMessage);
            JOptionPane.showMessageDialog(null, errorMessage, "Entity Name Missing", JOptionPane.ERROR_MESSAGE);
        } else if (sourceTextArea.getText().isEmpty()) {
            flag = false;
            String errorMessage = "Source Text must not be empty.";
            Functions.log(errorMessage);
            JOptionPane.showMessageDialog(null, errorMessage, "Source Data Missing", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public static void readDataFromFile(String pathname) throws IOException {
        Scanner sourceFile = new Scanner(new File(pathname));
        list = new ArrayList<String>();

        while (sourceFile.hasNextLine()) {
            sourceTextArea.append(sourceFile.next() + "\n");
        }

        convertListToCamelCase();
        convertListToTitleCase();

        sourceFile.close();
    }

    public static void buildEntityClass() {
        entityName = toTitleCase(entityTextField.getText());
        output = "public class " + entityName + "{\n\n";
        buildVariableDeclaration();
        buildConstructor();
        buildJsonToEntityClass();
        buildToString();

        output += "}";
    }

    public static void log(String data) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        String timestamp = dateFormat.format(date);

        data = timestamp + ": " + data + "\n";

        outputTextArea.append(data);
        try {
            File file = new File("log.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(Exception ex) {
        try {
            FileWriter fw = new FileWriter("log.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            log(sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveClassToFile(String path) {
        try {
            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(output);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillListFromSourceTextArea() {
        String s[] = sourceTextArea.getText().split("\\r?\\n");
        list = new ArrayList<>(Arrays.asList(s));

        convertListToCamelCase();
        convertListToTitleCase();
    }

    private static String toCamelCase(String item) {
        int idx = 0;
        StringBuilder st = new StringBuilder(item);
        while (true) {
            idx = st.indexOf("_");
            if (idx != -1) {
                st.replace(idx, idx + 2,
                        (st.charAt(idx + 1) + "").toUpperCase());
            } else {
                break;
            }
        }
        return st.toString();
    }

    private static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

    private static void convertListToTitleCase() {
        titleCaseList.clear();
        for (String item : camelCaseList) {
            titleCaseList.add(toTitleCase(item));
        }
    }

    private static void convertListToCamelCase() {
        camelCaseList.clear();
        for (int i = 0; i < list.size(); i++) {
            camelCaseList.add(toCamelCase(list.get(i)));
        }
    }

    private static String buildVariableDeclaration() {
        String variableDeclaration = "";

        for (String item : camelCaseList) {
            variableDeclaration += "String " + item + ";\n";
        }
        
        output += variableDeclaration + "\n\n";
        
        return variableDeclaration;
    }

    private static String buildConstructor() {
        String constructor = "public " + entityName + "(";

        for (int i = 0; i < list.size(); i++) {
            constructor += "String " + camelCaseList.get(i);
            if (i < list.size() - 1) {
                constructor += ", ";
            }
        }
        constructor += "){\n";

        for (int i = 0; i < list.size(); i++) {
            constructor += "this." + camelCaseList.get(i) + " = " + camelCaseList.get(i)
                    + ";\n";
        }
        constructor += "}";

        output += constructor + "\n\n";

        return constructor;
    }

    private static String buildToString() {
        String toStringFunction = "@Override\n";
        toStringFunction += "public String toString(){\n";
        toStringFunction += "return \"";

        Iterator<String> camelCaseIterator = camelCaseList.iterator();
        Iterator<String> titleCaseIterator = titleCaseList.iterator();

        while (camelCaseIterator.hasNext() && titleCaseIterator.hasNext()) {
            toStringFunction += titleCaseIterator.next().toString() + ": \" + this."
                    + camelCaseIterator.next().toString();
            if (camelCaseIterator.hasNext() && titleCaseIterator.hasNext()) {
                toStringFunction += " + \" - ";
            }
        }
        toStringFunction += ";\n}";

        output += toStringFunction + "\n\n";

        return toStringFunction;
    }

    private static String buildJsonToEntityClass() {
        String toJSON = "public void jsonTo" + entityName + "Object(String json){\n";
        toJSON += "JSONObject rootObject = new JSONObject(json);\n";
        toJSON += "JSONObject object = rootObject.getJSONObject(\"OBJECT_TAG\");\n";
        toJSON += "\n";

        for (String item : camelCaseList) {
            toJSON += "this." + item + " = object.getString(\"" + item + "\");\n";
        }

        toJSON += "}";

        output += toJSON + "\n\n";

        return toJSON;
    }

}
