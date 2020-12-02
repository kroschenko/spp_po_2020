package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        InputStreamReader ir;
        try {
            if (args.length == 0)
                ir = new InputStreamReader(System.in);
            else
                ir = new InputStreamReader(new FileInputStream(args[0]));
        } catch (IOException e) {
            System.out.println("File not found");
            ir = new InputStreamReader(System.in);
        }

        BufferedReader br = new BufferedReader(ir);
        Calculator calculator = new Calculator(br);

        try { calculator.run(); }
        catch(Exception e) { System.out.println(e.getMessage()); }
    }
}

enum Ops {
    comment("//", null), pop("pop", 0),
    push("push", 1),
    add("+", 0), sub("-", 0),
    mult("*", 0),
    div("/", 0), sqrt("sqrt", 0),
    print("print", 0),
    define("define", 2);

    private String name;
    private Integer numParams;

    Ops(String opName, Integer numParams) {
        this.name = opName;
        this.numParams = numParams;
    }

    public Integer numParams() {
        return this.numParams;
    }

    public String opName() {
        return this.name;
    }
}

class ExecutionContext {
    private HashMap<String, Double> parameters;
    private Stack<Object> stack;

    ExecutionContext() {
        parameters = new HashMap<>();
        stack = new Stack<>();
    }

    public void setParameter(String name, Double value) {
        parameters.put(name, value);
    }

    public Double getParameter(String name) {
        return parameters.get(name);
    }

    public boolean hasParameter(String name) {
        return parameters.containsKey(name);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(Object element) throws IOException {
        if(!(element.getClass() == Ops.class) &&
                !(element.getClass() == Double.class)
                && !(element.getClass() == String.class))
            throw new IOException();
        stack.push(element);
    }

    public Object pop() {
        return stack.pop();
    }

    public Object peek() {
        return stack.peek();
    }
}


class Calculator {
    private static final String ESC_WORD = "quit";
    private BufferedReader reader;
    private ExecutionContext context;

    public Calculator() {
        reader = null;
        context = new ExecutionContext();
    }

    public Calculator(BufferedReader r) {
        setReader(r);
        context = new ExecutionContext();
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void run() throws IOException, NullPointerException {
        if(reader == null) throw new NullPointerException();
        while(true) {
            String line = reader.readLine();
            if(line == null || ESC_WORD.equals(line)) return;
            try {
                CalculationsHandler.parse(line, context); CalculationsHandler.execute(context);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class CalculationsHandler {

    public static void execute(ExecutionContext context) throws EmptyStackException, IOException {

        if(context.isEmpty()) return;
        Ops op = (Ops)context.pop();

        switch (op) {
            case add:
                add(context);
                break;
            case div:
                div(context);
                break;
            case sub:
                sub(context);
                break;
            case sqrt:
                sqrt(context);
                break;
            case mult:
                mult(context);
                break;
            case push:
                push(context);
                break;
            case pop:
                pop(context);
                break;
            case print:
                print(context);
                break;
            case define:
                define(context);
                break;
            case comment:
                break;
        }
    }

    private static void add(ExecutionContext context) throws IOException, EmptyStackException {
        double result = (double)context.pop() + (double)context.pop(); context.push(result);
    }

    private static void div(ExecutionContext context) throws
            IOException, EmptyStackException {
        double result = (double)context.pop() / (double)context.pop();
        context.push(result);
    }

    private static void sub(ExecutionContext context) throws IOException, EmptyStackException {
        double result = (double)context.pop() - (double)context.pop(); context.push(result);
    }

    private static void sqrt(ExecutionContext context) throws IOException, EmptyStackException {
        double result = Math.sqrt((double)context.pop()); context.push(result);
    }

    private static void mult(ExecutionContext context) throws IOException, EmptyStackException {
        double result = (double)context.pop() * (double)context.pop(); context.push(result);
    }

    private static void push(ExecutionContext context) throws IOException {
        String val = (String)context.pop();
        if(!context.hasParameter(val)) {
            try {
                context.push(Double.parseDouble(val));
            } catch(Exception e) {
                throw new IOException(val);
            }
        } else {
            context.push(context.getParameter(val));
        }
    }

    private static void pop(ExecutionContext context) {
        context.pop();
    }

    private static void print(ExecutionContext context) {
        System.out.println(context.peek());
    }

    private static void define(ExecutionContext context) throws IOException {
        String name = (String)context.pop();
        String val = (String)context.pop();

        if(Character.isDigit(name.charAt(0))) {
            throw new IOException(name);
        }

        double convertedVal;
        if(!context.hasParameter(val)) {
            try { convertedVal = Double.parseDouble(val); }
            catch(Exception e) { throw new IOException(val);}
        } else {
            convertedVal = context.getParameter(val);
        }

        context.setParameter(name, convertedVal);
    }

    public static ExecutionContext parse(String op, ExecutionContext context) throws IOException {

        Ops convertedOp;
        String[] tokens = op.split("\\s+");
        if(tokens[0].isEmpty() || tokens[0].equals(Ops.comment.opName())) {	context.push(Ops.comment);
            return context;
        }

        try { convertedOp = Ops.valueOf(tokens[0].toLowerCase()); }
        catch(Exception e) { throw new IOException(tokens[0]); }

        if(tokens.length != convertedOp.numParams() + 1) {
            throw new IOException("Illegal Number Of Args");
        }

        for(int i = tokens.length - 1; i > 0; i--)
            context.push((String)tokens[i]);
        context.push(convertedOp);
        return context;
    }
}

