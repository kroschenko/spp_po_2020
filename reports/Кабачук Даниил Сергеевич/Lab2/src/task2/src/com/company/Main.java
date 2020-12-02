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
                    System.out.println(tailFile(new File(PATH), lines));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                break;
            case 3:
                try {
                    lines = Integer.parseInt(args[1]);
                    String PATH = dir +"/" +args[2];
                    System.out.println(tailFile(new File(PATH), lines));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                break;
            default:
                if(size < 2 || size > 3)
                    System.out.println("unknown option");
        }


    }
    public static String tailFile(File file, int lines) {
        RandomAccessFile fileHandler = null;
        try {
            fileHandler = new RandomAccessFile( file, "r" );
            long fileLength = fileHandler.length() - 1;
            StringBuilder stringBuilder = new StringBuilder();
            int line = 0;

            for(long filePointer = fileLength; filePointer != -1; filePointer--){
                fileHandler.seek( filePointer );
                byte readByte = fileHandler.readByte();

                if( readByte == 0xA ) {
                    if (filePointer < fileLength) {
                        stringBuilder.append(fileHandler.readLine()).append("\n");
                        line = line + 1;
                    }
                } else if( readByte == 0xD ) {
                    if (filePointer < fileLength-1) {
                        stringBuilder.append(fileHandler.readLine()).append("\n");
                        line = line + 1;
                    }
                }
                if (line >= lines) {
                    break;
                }
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

