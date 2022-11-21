package edu.school21.app;

import edu.school21.classes.Car;
import edu.school21.classes.User;

import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private enum inType {_String, _Integer, _int, _Double, _Boolean, _Long}

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Object[] classes = getClasses();
        System.out.println("Classes:");
        Object selectedClass = selectClass(classes);
        Field[] fields = printFields(selectedClass);
        Method[] methods = printMethods(selectedClass);
        if (fields.length > 0){
            createObject(selectedClass, fields);
            updateObject(selectedClass, fields);
        }
        if (methods.length > 0){
            getMethod(selectedClass, methods);
        }
        sc.close();
    }

    private static void getMethod(Object selectedClass, Method[] methods) throws InvocationTargetException, IllegalAccessException {
        System.out.print("Enter name of the method for call:\n-> ");
        String line;
        while (true){
            line = sc.nextLine();
            for (Method method:methods) {
                String param = method.getName() + "(";
                Parameter [] parameters = method.getParameters();
                for (int i = 0; i < parameters.length - 1; i++) {
                    param += parameters[i].getType().getSimpleName() + ", ";
                }
                if (parameters.length != 0)
                    param += parameters[parameters.length - 1].getType().getSimpleName();
                param += ")";
                if (line.equals(param)){
                    Object[] args = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        do {
                            System.out.print("Enter " + parameters[i].getType().getSimpleName() + " value \n->");
                            args[i] = convertValue("_" + parameters[i].getType().getSimpleName());
                        } while (args[i] == null);
                    }
                    Object result = null;
                    method.setAccessible(true);
                    result = method.invoke(selectedClass, args);
                    if (!(method.getReturnType().getSimpleName().equals("void"))) {
                        System.out.println("Method returned:");
                        System.out.println(result);
                    }
                    return;
                }
            }
            System.out.print("No this method. Try again.\n-> ");
        }
    }

    private static Object convertValue(String s) {
        inType _type = inType.valueOf(s);
        String nextLine;
        while (true){
            try{
                nextLine = sc.nextLine();
                switch (_type){
                    case _String:
                        return nextLine;
                    case _Integer:
                        return Integer.getInteger(nextLine);
                    case _int:
                        return Integer.decode(nextLine).intValue();
                    case _Double:
                        return Double.valueOf(nextLine);
                    case _Boolean:
                        return Boolean.getBoolean(nextLine);
                    case _Long:
                        return Long.getLong(nextLine);
                    default:
                        System.out.println("Error type");
                        System.exit(-1);
                }
            } catch (RuntimeException e){
                System.out.print("Try again\n-> ");
            }
        }
    }


    private static void updateObject(Object selectedClass, Field[] fields){
        System.out.print("Enter name of the field for changing:\n-> ");
        String line;
        while (true){
            line = sc.nextLine();
            for (Field fl:fields) {
                if (line.equals(fl.getName())){
                    System.out.print("Enter " + fl.getType().getSimpleName() + " value\n-> ");
                    inType _type = inType.valueOf("_" + fl.getType().getSimpleName());
                    updateField(selectedClass, fl, _type);
                    System.out.println("Object updated: " + selectedClass.toString());
                    return;
                }
            }
            System.out.print("No this field. Try again.\n-> ");
        }
    }

    private static void updateField(Object selectedClass, Field field, inType _type){
        field.setAccessible(true);
        String inp;
        boolean flag = true;
        while (flag){
            try {
                inp = sc.nextLine();
                switch (_type){
                    case _String:
                        field.set(selectedClass, inp);
                        break;
                    case _Integer:
                        field.set(selectedClass, Integer.parseInt(inp));
                        break;
                    case _int:
                        field.set(selectedClass, Integer.decode(inp).intValue());
                        break;
                    case _Double:
                        field.set(selectedClass, Double.valueOf(inp));
                        break;
                    case _Boolean:
                        field.set(selectedClass, Boolean.getBoolean(inp));
                        break;
                    case _Long:
                        field.set(selectedClass, Long.getLong(inp));
                        break;
                    default:
                        System.out.println("Error type");
                        System.exit(-1);
                }
                flag = false;
            } catch (RuntimeException | IllegalAccessException e){
                System.out.print("Error, try again\n-> ");
            }
        }
        field.setAccessible(false);
    }
    private static void createObject(Object selectedClass, Field[] fields){
        System.out.println("Let's create an object:");
        for (Field field:fields) {
            inType _type = inType.valueOf("_" + field.getType().getSimpleName());
            System.out.print(field.getName() + "\n-> ");
            updateField(selectedClass, field, _type);
        }
        System.out.println("Object created: " + selectedClass.toString());
    }

    private static Method[] printMethods(Object selectedClass){
        System.out.println("Methods:");
        Method[] methods = selectedClass.getClass().getDeclaredMethods();
        for (Method method:methods) {
            System.out.print("\t" + method.getReturnType().getSimpleName() + "\t" + method.getName() + "(");
            Parameter [] parameters = method.getParameters();
            for (int i = 0; i < parameters.length - 1; i++) {
                System.out.print(parameters[i].getType().getSimpleName() + ", ");
            }
            if (parameters.length != 0)
                System.out.print(parameters[parameters.length - 1].getType().getSimpleName());
            System.out.println(")");
        }
        return methods;
    }

    private static Field[] printFields(Object selectedClass){
        Field[] fields = selectedClass.getClass().getDeclaredFields();
        System.out.println("Fields:");
        for (Field field:fields) {
            System.out.println("\t" + field.getType().getSimpleName() + "\t" + field.getName());
        }
        return fields;
    }

    private static Object selectClass(Object[] classes){
        Object selectClass;
        for (Object object: classes) {
            System.out.println(object.getClass().getSimpleName());
        }
        System.out.print("Enter class name:\n-> ");
        while (true){
            String inp = sc.nextLine();
            if (inp.equals(classes[0].getClass().getSimpleName())){
                selectClass = classes[0];
                break;
            }
            if (inp.equals(classes[1].getClass().getSimpleName())){
                selectClass = classes[1];
                break;
            }
            System.out.print("Wrong class name. Try again\n->");
        }
        return selectClass;
    }

    private static Object[] getClasses(){
        Object[] objects = new Object[2];
        objects[0] = new User();
        objects[1] = new Car();
        return objects;
    }
}