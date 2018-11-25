package com.company;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {

    static public void readInfo(String direction, ArrayList<Sotrudnik> sotrudnikArrayList) {
        Scanner sc = null;
        String[] sotrudnikData = null;
        try {
            sc = new Scanner(new File(direction));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert sc != null;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            sotrudnikData = line.split(";");

            try {
                Exceptions.checkString(sotrudnikData[0]);
                Exceptions.checkString(sotrudnikData[2]);
                Exceptions.checkString(sotrudnikData[3]);

                //System.out.println(sotrudnikData[0]);

                if (sotrudnikData[0].equals("Преподаватель")) {
                    sotrudnikArrayList.add(new Prepodavatel(Integer.parseInt(sotrudnikData[1]), sotrudnikData[2], sotrudnikData[3], sotrudnikData[0],
                                                            Integer.parseInt(sotrudnikData[4]),Integer.parseInt(sotrudnikData[5])));

                } else if (sotrudnikData[0].equals("Уборщица")) {
                    sotrudnikArrayList.add(new Uborchica(Integer.parseInt(sotrudnikData[1]), sotrudnikData[2], sotrudnikData[3], sotrudnikData[0],
                            Integer.parseInt(sotrudnikData[4]),Integer.parseInt(sotrudnikData[5])));

                } else if (sotrudnikData[0].equals("Охранник")) {
                    sotrudnikArrayList.add(new Ohrannik(Integer.parseInt(sotrudnikData[1]), sotrudnikData[2], sotrudnikData[3], sotrudnikData[0],
                            Integer.parseInt(sotrudnikData[4]), Integer.parseInt(sotrudnikData[5])));
                }

            }   catch (NumberFormatException e){
                Logger.addLog(e.getMessage());
                e.printStackTrace();
            }
            catch (Exception e) {
                Logger.addLog(e.getMessage());
                e.printStackTrace();
            }

//System.out.println(sotrudnikData[0] + sotrudnikData[1] + sotrudnikData[2] + sotrudnikData[3] + sotrudnikData[4] + sotrudnikData[5] + sotrudnikData[6]);
        }
    }

    static public void serializationToFile(String directory, ArrayList<Sotrudnik> sotrudnikArrayList) throws IOException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(os);
        for(Sotrudnik s: sotrudnikArrayList) {
            oos.writeObject(s.getAll());
    }
        oos.flush();
        os.flush();
        oos.close();
        os.close();

        byte[] bArray = os.toByteArray();

        FileOutputStream outFile = new FileOutputStream(directory);

        Logger.addLog("Файл» " + directory + " открыт для записи");

        outFile.write(bArray);

        Logger.addLog("Записано: " + bArray.length + " байт‚");
    }

    static public void deserializationFromFile(String direction, int numOfElements) {

        byte[] bytesReaded = null;
        FileInputStream inFile = null;
        int bytesAvailable = 0;
        try {
            inFile = new FileInputStream(direction);
            bytesAvailable = inFile.available();
            bytesReaded = new byte[bytesAvailable];

            Logger.addLog("Файл " + direction + " открыт для чтения");
            Logger.addLog("Готово к считыванию: " + bytesAvailable + " байт‚");

            int count = inFile.read(bytesReaded, 0, bytesAvailable);
            Logger.addLog("Считано: " + count + " байт");
           // System.out.println("\n Сериализация: \n");
            for (int i = 0; i < count; i++) {
                System.out.print(bytesReaded[i]);
            }
            System.out.println();
            inFile.close();

            ByteArrayInputStream is = new ByteArrayInputStream(bytesReaded);
            ObjectInputStream ois = new ObjectInputStream(is);
            //System.out.println("\n Десериализация: \n");
            for (int i = 0; i < numOfElements; i++) {
                String a = (String) ois.readObject();
                System.out.println(a);
            }

        } catch (IOException | ClassNotFoundException e) {
            Logger.addLog(e.getMessage());
            e.printStackTrace();
        }
    }

    /*public void surDis(String direction, ArrayList<Sotrudnik> sotrudnikArrayList) throws IOException {
        ByteArrayOutputStream os =
                new ByteArrayOutputStream();

        ObjectOutputStream oos =
                new ObjectOutputStream(os);
        for(Sotrudnik f: sotrudnikArrayList) {
            System.out.println(f.getAll());
            oos.writeObject(f.getAll());
        }

        byte[] bArray = os.toByteArray();

        oos.flush();
        os.flush();
        oos.close();
        os.close();

        for(byte b: bArray) {
            System.out.print(b);
        }
        System.out.println();

        ByteArrayInputStream is = new ByteArrayInputStream(bArray);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            for(Sotrudnik f: sotrudnikArrayList) {
                String a = (String) ois.readObject();
                System.out.println(a);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}