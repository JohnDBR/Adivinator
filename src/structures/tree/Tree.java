/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import structures.linkedlist.LinkedList;

/**
 *
 * @author John
 */
public class Tree implements java.io.Serializable {

    private String name;
    private Node root;
    private LinkedList<Node> stack;
    private LinkedList<Node> doubt;
    private int sons = -1, height = 0;

    private final String fileRoute;
    private final int ownId;
    private static int id = 0;
    private static boolean idSet = false;

    public Tree() {
        fileRoute = "./database/treeStorer.txt";
        if (checkFile()) {
            setId();
        }
        stack = new LinkedList<>();
        doubt = new LinkedList<>();
        this.setRoot(null);
        this.name = "";
        ownId = id++;
    }

    public Tree(String name) {
        fileRoute = "./database/treeStorer.txt";
        if (checkFile()) {
            setId();
        }
        stack = new LinkedList<>();
        doubt = new LinkedList<>();
        this.setRoot(null);
        this.name = name;
        ownId = id;
        id++;
    }

    public Tree(int ownId, String name) {
        fileRoute = "./database/treeStorer.txt";
        stack = new LinkedList<>();
        doubt = new LinkedList<>();
        this.setRoot(null);
        this.name = name;
        this.ownId = ownId;
    }

    public void add(String string, int level, int position) {
        int maxPosition = maxPosition(level);
        String positions = allPositions(maxPosition);
        if (position < maxPosition) {
            if (!exist(string, root, false)) {
                Node q = new Node(string);
                if (getRoot() == null && level == 0 && position == 0) {
                    q.setLevel(0);
                    q.setPosition(0);
                    setRoot(q);
                    stack.add(q);
                    setSons(getSons() + 1);
                } else {
                    Node p = getRoot(), antp = null;
                    String firstHalf = "", secondHalf = "";
                    int levelCounter = 0;
                    while (p != null) {
                        levelCounter++;
                        firstHalf = positions.substring(0, positions.length() / 2);
                        secondHalf = positions.substring(positions.length() / 2, positions.length());
                        antp = p;
                        if (firstHalf.contains("" + position)) {
                            p = p.getLeft();
                            positions = firstHalf;
                        } else {
                            p = p.getRight();
                            positions = secondHalf;
                        }
                        if (levelCounter == level && p != null) {
                            p = null;
                            levelCounter = -1;
                        }
                    }
                    if (levelCounter == level) {
                        q.setLevel(level);
                        q.setPosition(position);
                        setSons(getSons() + 1);
                        if (firstHalf.contains("" + position)) {
                            antp.setLeft(q);
                        } else {
                            antp.setRight(q);
                        }
                    }
                }
            }
        }
        height(root, 0);
    }

    public void deleteNode(String string) {
        Node p = findNode(string, root, null);
        Node antp = findFather(string, root, null);
        if (antp != null) {
            if (antp.getRight() != null) {
                if (antp.getRight().getString().equals(string)) {
                    antp.setRight(null);
                }
            }
            if (antp.getLeft() != null) {
                if (antp.getLeft().getString().equals(string)) {
                    antp.setLeft(null);
                }
            }
        } else if (p != null) {
            root = null;
        }
    }

    public boolean exist(String string, Node p, boolean bool) {
        if (p != null) {
            if (p.getString().equals(string)) {
                bool = true;
            } else {
                bool = exist(string, p.getRight(), bool);
                if (bool == false) {
                    bool = exist(string, p.getRight(), bool);
                }
            }
        }
        return bool;
    }

    public Node findNode(String string, Node p, Node target) {
        if (p != null) {
            if (p.getString().equals(string)) {
                target = p;
            } else {
                target = findNode(string, p.getLeft(), target);
                if (target == null) {
                    target = findNode(string, p.getRight(), target);
                }
            }
        }
        return target;
    }

    public Node findFather(String string, Node p, Node target) {
        if (p != null) {
            if (p.getRight() != null) {
                if (p.getRight().getString().equals(string)) {
                    target = p;
                }
            }
            if (p.getLeft() != null) {
                if (p.getLeft().getString().equals(string)) {
                    target = p;
                }
            }
            if (target == null) {
                target = findFather(string, p.getRight(), target);
                if (target == null) {
                    target = findFather(string, p.getLeft(), target);
                }
            }
        }
        return target;
    }

    public int maxPosition(int level) {
        //for (int i = 0; i < level; i++) {
        //    maxPosition = maxPosition * 2;
        //}
        return (int) Math.pow(2, level);
    }

    public String allPositions(int maxPositions) {
        String positions = "";
        for (int i = 0; i < maxPositions; i++) {
            if (i < 10) {
                positions = positions + i + "-";
            } else {
                positions = positions + i;
            }
        }
        return positions;
    }

    private boolean leaf(Node p) {
        if (p != null) {
            if (p.getLeft() != null || p.getRight() != null) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void height(Node p, int num) {
        if (p != null) {
            //if (num > height) { //Doesnt matter...
            //    height = num;
            //}
            height(p.getLeft(), num + 1);
            if (num > height) {
                height = num;
            }
            height(p.getRight(), num + 1);
        }
    }

    public String run(boolean direction) { //Need to check doubt LinkedList...
        String string = "Arbol vacio";
        if (root != null) {
            Node p = null;
            if (stack.isEmpty()) {
                stack.add(root);
            }
            if (!direction) {
                p = stack.getLast().getLeft();
                if (p != null) {
                    string = p.getString();
                    stack.add(p);
                } else if (!doubt.isEmpty()) {
                    Node q = doubt.getLast();
                    doubt.pollLast();
                    if (stack.contains(q.getLeft())) {
                        stack.add(q.getRight());
                        string = q.getRight().getString();
                    } else {
                        stack.add(q.getLeft());
                        string = q.getLeft().getString();
                    }
                } else {
                    string = "No se!";
                }
            } else {
                p = stack.getLast().getRight();
                if (p != null) {
                    string = p.getString();
                    stack.add(p);
                } else {
                    string = "Juego Terminado!";
                }
            }

        }
        return string;
    }

    public void learn(String question, String answer) {
        if (!stack.isEmpty()) {
            Node qstn = new Node(question), answr = new Node(answer), p = stack.getLast();
            qstn.setLevel(p.getLevel() + 1);                        //I can use method add too, but I dont care...
            qstn.setPosition((p.getPosition() + 1) * 2 - 2);        //(p.getPosition() + 1)*2 - 1 Right son...

            answr.setLevel(qstn.getLevel() + 1);
            answr.setPosition((qstn.getPosition() + 1) * 2 - 1);    //(p.getPosition() + 1)*2 - 2 Left son...

            qstn.setRight(answr);

            p.setLeft(qstn);
            height(root, 0);
            stack.clear();
        }
    }

    public String doubt(String answer) {
        String string = "Arbol vacio";
        if (root != null) {
            if (stack.isEmpty()) {
                stack.add(root);
            }
            Node p = stack.getLast();
            if (p != null) {
                doubt.add(p);
                switch (answer) {
                    case "Probablemente Si":
                        string = run(true);
                        break;
                    case "Probablemente No":
                        string = run(false);
                        break;
                    case "Irrelevante":
                        //Should be discussed
                        break;
                    case "No se":
                        //Should be discussed
                        break;
                }
            }
        }
        return string;
    }

    public LinkedList<Node> biggerBranch(Node p, LinkedList<Node> list) {
        LinkedList<Node> bigger = new LinkedList<>();
        if (p != null) {
            list.add(p);
            LinkedList<Node> aux1 = biggerBranch(p.getLeft(), list);
            LinkedList<Node> aux2 = biggerBranch(p.getRight(), list);
            int a, b;
            try {
                a = aux1.size();
            } catch (Exception e) {
                a = 0;
            }
            try {
                b = aux2.size();
            } catch (Exception e) {
                b = 0;
            }
            if (a > b) {
                bigger.addAll(aux1);
            } else {
                bigger.addAll(aux2);
            }
            //list.remove(p);
            list.pollLast();
        } else {
            bigger.addAll(list);
        }
        return bigger;
    }

    public String get() {
        try {
            return stack.getLast().getString();
        } catch (Exception e) {
            return null;
        }
    }

    //BUFFERING METHODS
    private boolean checkFile() {
        File storer = new File(fileRoute);
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
        if (!idSet) {
            try {
                File storer = new File(fileRoute);
                FileReader fr = new FileReader(storer);
                BufferedReader br = new BufferedReader(fr);

                int cont = 0;
                while (br.readLine() != null) {
                    cont++;
                }
                id = cont;
                //System.out.println(id);

                idSet = true;

                br.close();
                fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public int save() {
        try {
            String c = "|";
            File storer = new File(fileRoute);
            File fileModification = new File("./database/modification.txt");
            fileModification.createNewFile();

            FileReader fr = new FileReader(storer);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(fileModification);
            PrintWriter pw = new PrintWriter(fw);

            String line, sTree = this.getClass().getSimpleName() + c + ownId + c + name + c + allNodes(root);
            boolean insert = false;
            while ((line = br.readLine()) != null) {
                //String[] field = line.split("\\|");
                //if (field[1].equals(Integer.toString(ownId))) {
                //    pw.println(sTree);
                //    insert = true;
                //} else {
                //    pw.println(line);
                //}

                LinkedList<String> field = new LinkedList<>(); //Add a try-catch on LinkedList class
                field.addAll(split(line, "|"));
                if (field.get(1).equals(Integer.toString(ownId))) {
                    pw.println(sTree);
                    insert = true;
                } else {
                    pw.println(line);
                }
            }
            if (!insert) {
                pw.println(sTree);
            }

            pw.close();
            fw.close();

            br.close();
            fr.close();

            boolean delete;
            boolean rename;
            do {
                delete = storer.delete();
                rename = fileModification.renameTo(storer);
                //rename = fileModification.renameTo(new File(fileRoute));
                //fileModification.delete();
                //storer = fileModification;
                System.out.println(delete + " " + rename);
            } while (!(delete && rename));
            return (id - 1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private String allNodes(Node p) {
        String c = ";", s = ",", line = "";
        if (p != null) {
            line = line + p.getString() + s + p.getLevel() + s + p.getPosition() + c + allNodes(p.getLeft()) + allNodes(p.getRight());
        }
        return line;
    }

    public static Tree load(int id) {
        try {
            File f = new File("./database/treeStorer.txt");
            if (f.exists()) {

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                int sw = 0;
                String line;
                while ((line = br.readLine()) != null && sw == 0) {
                    //String[] field = line.split("\\|");
                    //if (field[1].equals(Integer.toString(id))) {
                    //
                    //    Tree tree = new Tree(field[2]);
                    //    String[] nodes = field[3].split("\\;");
                    //    for (String node : nodes) {
                    //        String[] attr = node.split("\\,");
                    //        tree.add(attr[0], Integer.valueOf(attr[1]), Integer.valueOf(attr[2]));
                    //    }
                    //
                    //    br.close();
                    //    fr.close();
                    //
                    //    return tree;
                    //}

                    LinkedList<String> field = new LinkedList<>(); //Add a try-catch on LinkedList class
                    field.addAll(split(line, "|"));
                    if (field.get(1).equals(Integer.toString(id))) {
                        Tree tree = new Tree(Integer.valueOf(field.get(1)), field.get(2));
                        LinkedList<String> nodes = new LinkedList<>(); //Add a try-catch on LinkedList class
                        nodes.addAll(split(field.get(3), ";"));
                        for (int i = 0; i < nodes.size(); i++) {
                            String node = nodes.get(i);
                            LinkedList<String> attr = new LinkedList<>(); //Add a try-catch on LinkedList class
                            attr.addAll(split(node, ","));
                            tree.add(attr.get(0), Integer.valueOf(attr.get(1)), Integer.valueOf(attr.get(2)));
                        }

                        br.close();
                        fr.close();

                        return tree;
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static LinkedList<Tree> loadAll() {
        try {
            File f = new File("./database/treeStorer.txt");
            if (f.exists()) {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                LinkedList<Tree> forest = new LinkedList<>();
                String line;
                while ((line = br.readLine()) != null) {
                    //String[] field = line.split("\\|");
                    //Tree tree = new Tree(field[2]);
                    //String[] nodes = field[3].split("\\;");
                    //for (String node : nodes) {
                    //    String[] attr = node.split("\\,");
                    //    tree.add(attr[0], Integer.valueOf(attr[1]), Integer.valueOf(attr[2]));
                    //}
                    //forest.add(tree);

                    LinkedList<String> field = new LinkedList<>(); //Add a try-catch on LinkedList class
                    field.addAll(split(line, "|"));
                    Tree tree = new Tree(Integer.valueOf(field.get(1)), field.get(2));
                    LinkedList<String> nodes = new LinkedList<>(); //Add a try-catch on LinkedList class
                    nodes.addAll(split(field.get(3), ";"));
                    for (int i = 0; i < nodes.size(); i++) {
                        String node = nodes.get(i);
                        LinkedList<String> attr = new LinkedList<>(); //Add a try-catch on LinkedList class
                        attr.addAll(split(node, ","));
                        tree.add(attr.get(0), Integer.valueOf(attr.get(1)), Integer.valueOf(attr.get(2)));
                    }
                    forest.add(tree);
                }

                br.close();
                fr.close();

                return forest;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static LinkedList<String> split(String line, String s) {
        if (line != null && s != null) {
            int j = 0;
            LinkedList<String> piece = new LinkedList<>();
            for (int i = 0; i < line.length(); i++) {
                String c = line.substring(i, i + 1);
                if (c.equals(s)) {
                    piece.add(line.substring(j, i));
                    j = i + 1;
                }
            }
            if (j != line.length()) {
                piece.add(line.substring(j, line.length()));
            }
            return piece;
        }
        return null;
    }

    //GETTERS SETTERS
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node aRoot) {
        root = aRoot;
    }

    public int getSons() {
        return sons;
    }

    public void setSons(int aSons) {
        sons = aSons;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int aHeight) {
        height = aHeight;
    }

    public LinkedList<Node> getStack() {
        return stack;
    }

    public void setStack(LinkedList<Node> stack) {
        this.stack = stack;
    }

    public void setDoubt(LinkedList<Node> doubt) {
        this.doubt = doubt;
    }

    public LinkedList<Node> getDoubt() {
        return doubt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
