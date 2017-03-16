/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import structures.linkedlist.LinkedList;

/**
 *
 * @author john
 */
public class User {

    private String name;
    private int topScore;

    private final String fileRoute;
    private File storer;
    private final int ownId;
    private static int id = 0;

    public User(String name) {
        this.name = name;
        topScore = 0;
        fileRoute = "./database/userStorer.txt";
        if (checkFile()) {
            setId();
        }
        ownId = id++;
    }

    public void updateScore(int newScore) {
        if (newScore > topScore) {
            topScore = newScore;
        }
    }

    //BUFFERING METHODS
    private boolean checkFile() {
        storer = new File(fileRoute);
        if (!storer.exists()) {
            try {
                storer.createNewFile();
                id = 0;
                return false;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    private void setId() {
        try {
            FileReader fr = new FileReader(storer);
            BufferedReader br = new BufferedReader(fr);

            int cont = 0;
            while (br.readLine() != null) {
                cont++;
            }
            id = cont;
            //System.out.println(id);

            br.close();
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int save() {
        try {
            String c = "|";
            File fileModification = new File("./modification.txt");
            fileModification.createNewFile();

            FileReader fr = new FileReader(storer);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(fileModification);
            PrintWriter pw = new PrintWriter(fw);

            String line, sUser = this.getClass().getSimpleName() + c + ownId + c + name + c + topScore;
            boolean insert = false;
            while ((line = br.readLine()) != null) {
                String[] field = line.split("\\|");
                if (field[1].equals(Integer.toString(ownId))) {
                    pw.println(sUser);
                    insert = true;
                } else {
                    pw.println(line);
                }
            }
            if (!insert) {
                pw.println(sUser);
            }

            pw.close();
            fw.close();

            br.close();
            fr.close();

            boolean delete;
            boolean rename;
            do {
                delete = storer.delete();
                //rename = fileModification.renameTo(storer);
                rename = fileModification.renameTo(new File(fileRoute));
                fileModification.delete();
                //storer = fileModification;
                System.out.println(delete + " " + rename);
            } while (!(delete && rename));
            return (id - 1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static User load(int id) {
        try {
            File f = new File("./database/userStorer.txt");
            if (f.exists()) {

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                int sw = 0;
                String line;
                while ((line = br.readLine()) != null && sw == 0) {
                    String[] field = line.split("\\|");
                    if (field[1].equals(Integer.toString(id))) {

                        User user = new User(field[2]);
                        user.setTopScore(Integer.valueOf(field[3]));

                        br.close();
                        fr.close();

                        return user;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static LinkedList<User> loadAll() {
        try {
            File f = new File("./database/userStorer.txt");
            if (f.exists()) {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                LinkedList<User> users = new LinkedList<>();
                String line;
                while ((line = br.readLine()) != null) {
                    String[] field = line.split("\\|");
                    User user = new User(field[2]);
                    user.setTopScore(Integer.valueOf(field[3]));
                    users.add(user);
                }

                br.close();
                fr.close();

                return users;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //GETTERS SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTopScore() {
        return topScore;
    }

    private void setTopScore(int topScore) {
        this.topScore = topScore;
    }

}
