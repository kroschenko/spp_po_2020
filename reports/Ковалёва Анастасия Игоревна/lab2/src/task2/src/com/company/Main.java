package com.company;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        final String dir = System.getProperty("user.dir");
        int lines = 0;
        int size = args.length;

        switch (size){
            case 2:
                try {
                    lines = Integer.parseInt(args[0]);
                    String PATH = dir +"/" +args[1];
                    System.out.println(headFile(new File(PATH), lines));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                break;
            case 3:
                try {
                    lines = Integer.parseInt(args[1]);
                    String PATH = dir + "/" +args[2];
                    System.out.println(headFile(new File(PATH), lines));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                break;
            default:
                if(size < 2 || size > 3)
                    System.out.println("unknown option");
        }
    }

    public static String headFile(File file, int lines) {
        RandomAccessFile fileHandler = null;
        try {
            fileHandler = new RandomAccessFile(file, "r" );
            StringBuilder stringBuilder = new StringBuilder();

            for(int i = 0; i < lines; i++) {
                stringBuilder.append(fileHandler.readLine()).append("\n");
            }

            String utf = new String(stringBuilder.toString()
                    .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            return utf;
        } catch( java.io.FileNotFoundException e ) {
            e.printStackTrace();
            return null;
        } catch( java.io.IOException e ) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (fileHandler != null )
                try {
                    fileHandler.close();
                } catch (IOException e) {
                }
        }
    }
}

