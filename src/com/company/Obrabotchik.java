package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Obrabotchik {

        public void Go(ArrayList<Sotrudnik> sotrudnikArrayList) {

           Reader.readInfo("C:/Users/21091/Downloads/Laba2/Sotrudniks.csv", sotrudnikArrayList);
            for(Sotrudnik f: sotrudnikArrayList){
               System.out.println(f);
            }
            try {
                Reader.serializationToFile("C:/Users/21091/Downloads/Laba2/serialization.txt", sotrudnikArrayList);

                Reader.deserializationFromFile("C:/Users/21091/Downloads/Laba2/serialization.txt", sotrudnikArrayList.size());

            //fileRW.surDis("C:/Users/Tom/Desktop/Laba2/fff.txt", sotrudnikArrayList);
            } catch (IOException e) {
                Logger.addLog(e.getMessage());
                e.printStackTrace();
            }
        }

}
