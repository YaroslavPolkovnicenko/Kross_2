package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

                ArrayList<Sotrudnik> sotrudnikArrayList = new ArrayList<>();
                Logger logs = Logger.getInstance();
                Obrabotchik o = new Obrabotchik();
                o.Go(sotrudnikArrayList);
            }
}
