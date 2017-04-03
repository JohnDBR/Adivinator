/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import structures.linkedlist.LinkedList;
import java.util.Scanner;
import structures.tree.Node;
import structures.tree.Tree;

/**
 *
 * @author John
 */
public class TreeManager {

    private LinkedList<Tree> forest;
    private Tree selectedTree;

    private BufferedReader read;
    private int sons, height;
    private LinkedList<String> levels;

    public TreeManager() {
        forest = new LinkedList();

        read = new BufferedReader(new InputStreamReader(System.in));
        sons = -1;
        height = 0;
        levels = new LinkedList<>();
    }

    //IMPORTANT METHODS
    public void saveAll() {
        if (forest != null) {
            for (int i = 0; i < forest.size(); i++) {
                forest.get(i).save();
            }
        }
    }

    public void loadAll() {
        forest.clear();
        forest.addAll(Tree.loadAll());
    }

    public Tree get(String name) {
        for (int i = 0; i < forest.size(); i++) {
            if (forest.get(i).getName().equals(name)) {
                return forest.get(i);
            }
        }
        return null;
    }

    public void createTree(String name) {
        if (name != null) {
            forest.add(new Tree(name));
        } else {
            forest.add(new Tree());
        }
    }

    public void addToTree(String name, String string, int level, int position) {
        try {
            get(name).add(string, level, position);
        } catch (Exception e) {
        }
    }

    public void deleteToTree(String name, String string) {
        try {
            get(name).deleteNode(string);
        } catch (Exception e) {
        }
    }

    public String moveInTree(String name, boolean direction) {
        try {
            return get(name).run(direction);
        } catch (Exception e) {
            return null;
        }
    }

    public void learnInTree(String name, String question, String answer) {
        try {
            get(name).learn(question, answer);
        } catch (Exception e) {
        }
    }

    public String doubtMoveInTree(String name, String answer) {
        try {
            return get(name).doubt(answer);
        } catch (Exception e) {
            return null;
        }
    }

    public String getInTree(String name) {
        try {
            return get(name).get();
        } catch (Exception e) {
            return null;
        }
    }

    public void saveTree(String name) {
        try {
            get(name).save();
        } catch (Exception e) {
        }
    }

    public boolean selectTree(String name) {
        selectedTree = get(name);
        return selectedTree != null;
    }

    public boolean selectTree(int position) {
        selectedTree = forest.get(position);
        return selectedTree != null;
    }

    private Tree getSelectedTree() {
        for (int i = 0; i < forest.size(); i++) {
            if (forest.get(i).equals(selectedTree)) {
                return forest.get(i);
            }
        }
        return null;
    }

    public void addToSelectedTree(String string, int level, int position) {
        if (selectedTree != null) {
            getSelectedTree().add(string, level, position);
        }
    }

    public void deleteToSelectedTree(String string) {
        if (selectedTree != null) {
            getSelectedTree().deleteNode(string);
        }
    }

    public String moveInSelectedTree(boolean direction) {
        if (selectedTree != null) {
            return getSelectedTree().run(direction);
        }
        return null;
    }

    public void learnInSelectedTree(String question, String answer) {
        try {
            getSelectedTree().learn(question, answer);
        } catch (Exception e) {
        }
    }

    public String doubtMoveInSelectedTree(String answer) {
        if (selectedTree != null) {
            return getSelectedTree().doubt(answer);
        }
        return null;
    }

    public String getInSelectedTree() {
        if (selectedTree != null) {
            return selectedTree.get();
        }
        return null;
    }

    public void saveInSelectedTree() {
        if (selectedTree != null) {
            selectedTree.save();
        }
    }
    
    public void clearRouteInSelectedTree(){
        try{
            selectedTree.clearRoute();
        }catch(Exception e){}
    }

    public void updateTree(String oldName, String newName) {
        Tree tree;
        if ((tree = get(oldName)) != null && get(newName) == null) {
            tree.setName(newName);
        }
    }

    public void deleteTree(String name) {
        forest.delete(get(name));
    }

    //JUST-IN-CASE METHODS
    public void preOrder(Node p, LinkedList<String> travel) {
        if (p != null) {
            travel.add(p.getString());
            preOrder(p.getLeft(), travel);
            preOrder(p.getRight(), travel);
        }
    }

    public void inOrder(Node p, LinkedList<String> travel) {
        if (p != null) {
            inOrder(p.getLeft(), travel);
            travel.add(p.getString());
            inOrder(p.getRight(), travel);
        }
    }

    public void postOrder(Node p, LinkedList<String> travel) {
        if (p != null) {
            postOrder(p.getLeft(), travel);
            postOrder(p.getRight(), travel);
            travel.add(p.getString());
        }
    }

    public void levelOrder(Node root, LinkedList<String> travel) {
        if (root != null) {
            LinkedList<Node> queue = new LinkedList<>();
            queue.addLast(root);
            while (queue.size() > 0) {
                Node p = queue.getNode(0).getInfo();
                queue.pollFirst();
                travel.add(p.getString());
                if (p.getLeft() != null) {
                    queue.addLast(p.getLeft());
                }
                if (p.getRight() != null) {
                    queue.addLast(p.getRight());
                }
            }
        }
    }

    public void levelNodes(Node p, int level) {
        if (p != null) {
            String string = p.getString();
            int lvl = p.getLevel();
            if (lvl == level && !levels.contains(string)) {
                levels.add(string);
            }
            if (p.getLeft() == null && lvl + 1 == level) {
                levels.add(-1 + "");
            }
            levelNodes(p.getLeft(), level);
            if (p.getRight() == null && lvl + 1 == level) {
                levels.add(-1 + "");
            }
            levelNodes(p.getRight(), level);
            //levelNodes(p.getLeft(), level);
            //levelNodes(p.getRight(), level);
        }
    }

    public boolean leaf(Node p) {
        if (p != null) {
            if (p.getLeft() != null || p.getRight() != null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void offspring(Node p) {
        if (p != null) {
            sons++;
            offspring(p.getLeft());
            offspring(p.getRight());
        }
    }

    public int nodes(Node p) {
        clean();
        offspring(p);
        return sons + 1;
    }

    public void height(Node p, int num) {
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

    private void clean() {
        sons = -1;
        height = 0;
        levels = new LinkedList<>();
    }

    //CONSOLE METHODS (don't use it) these methods are only for me, if you understand it you can use it to help you
    public void createTree() throws IOException {
        Tree tree = new Tree();
        String string;
        int op = 1, level = 0, position = 0;
        do {
            System.out.println("Digite info del nodo: (contenido Enter nivel Enter posicion Enter)");
            string = read.readLine();
            level = Integer.valueOf(read.readLine());
            position = Integer.valueOf(read.readLine());
            tree.add(string, level, position);
            System.out.println("Desea ingresar mas nodos 1-Si, 0-No");
            op = Integer.valueOf(read.readLine());
        } while (op == 1);
        //height(tree.getRoot(), 0);
        //tree.setHeight(height);

        if (tree.getRoot() != null) {
            forest.add(tree);
            selectedTree = tree;
            justShow();
        }

    } //Console method pls don't use it...

    public void showTree() throws IOException {
        if (selectedTree != null) {
            Node root = selectedTree.getRoot();
            LinkedList<String> travel = new LinkedList<>();
            System.out.println("Mostrar Arbol por 1.pre-orden - 2.in-orden 3.post-orden - 4.nivel-orden - 5.intento grafico");
            System.out.println("OPCION: ");
            int op = Integer.valueOf(read.readLine());
            System.out.println("");
            switch (op) {
                case 1:
                    preOrder(root, travel);
                    break;
                case 2:
                    inOrder(root, travel);
                    break;
                case 3:
                    postOrder(root, travel);
                    break;
                case 4:
                    levelOrder(root, travel);
                    break;
                case 5:
                    //int num = read.nextInt(); //fix, cousins from uncles...
                    //Node p = findNode(num);
                    graphicTree(selectedTree, root);
                    break;
                default:
                    break;
            }
            for (int i = 0; i < travel.size(); i++) {
                String string = travel.get(i);
                System.out.print(string + "-");
            }
            //for (String string : travel) {
            //    System.out.print(string + "-");
            //}
        }
    } //Console method pls don't use it...

    public void justShow() {
        System.out.println("");
        if (selectedTree != null) {
            graphicTree(selectedTree, selectedTree.getRoot());
        }
        System.out.println("");
    } //Console method pls don't use it...

    public void graphicTree(Tree tree, Node p) { //fix, missing Grandchildren from a missing son... I really need to fix this?...
        if (tree.getRoot() != null) {            //fix, add spaces for a better view...
            int hght = tree.getHeight();
            int level = p.getLevel() + 1;
            //System.out.println(level + "<" + height);
            System.out.println(p.getString() + "-");
            while (level <= hght) {
                clean();
                levelNodes(tree.getRoot(), level);
                for (int i = 0; i < levels.size(); i++) {
                    String node = levels.get(i);
                    System.out.print(node + "-");
                }
                //for (String node : levels) {
                //    System.out.print(node + "-");
                //}
                System.out.println("");
                level++;
            }
        }
    } //Console method pls don't use it...

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        String string = "";
        int op, treeIndex;
        Tree tree;
        do {
            System.out.println(
                    "NOTA: el valor -1 en mi laboratorio es nulo, vacio\n\n"
                    + "Opciones:\n"
                    + " 1. Crear Arbol\n"
                    + " 2. Mostrar Arbol\n"
                    + " 3. Informacion detallada del nodo\n"
                    + " 4. Eliminar nodo\n"
                    + " 5. Agregar nodo\n"
                    + " 6. Recorrer Arbol mediante booleanos\n"
                    + " 7. Rama mas grande\n"
                    + " 0. Salir"
            );
            System.out.println("OPCION: ");
            op = read.nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    Tree t = new Tree();
                    createTree(t);
                    if (t.getRoot() != null) {
                        forest.add(t);
                        justShow(t);
                    }
                    break;
                case 2:
                    System.out.println("Arbol:");
                    treeIndex = read.nextInt();
                    showTree(forest.get(treeIndex));
                    break;
                case 3:
                    clean();
                    System.out.println("Arbol:");
                    treeIndex = read.nextInt();
                    if ((tree = forest.get(treeIndex)) != null) {
                        System.out.println("Nodo:");
                        string = read.next();
                        System.out.println("");
                        Node p = tree.findNode(string, tree.getRoot(), null);
                        if (p != null) {
                            graphicTree(tree, tree.getRoot());
                            System.out.println("");
                            height(p, 0);
                            offspring(p);
                            System.out.println(leaf(p) + "- hoja");
                            System.out.println(height + "- altura");
                            System.out.println(sons + "- descendencia");
                            System.out.println(nodes(p) + "- nodos del arbol/sub-arbol");
                            System.out.println(p.getLevel() + "- nivel");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Arbol:");
                    treeIndex = read.nextInt();
                    if ((tree = forest.get(treeIndex)) != null) {
                        System.out.println("Nodo:");
                        string = read.next();
                        tree.deleteNode(string);
                        justShow(tree);
                    }
                    break;
                case 5:
                    System.out.println("Arbol:");
                    treeIndex = read.nextInt();
                    if ((tree = forest.get(treeIndex)) != null) {
                        createTree(tree);
                        justShow(tree);
                    }
                    break;
                case 6:
                    System.out.println("Arbol:");
                    treeIndex = read.nextInt();
                    if ((tree = forest.get(treeIndex)) != null) {
                        System.out.println("1.False - 2.True");
                        op = read.nextInt();
                        if (op == 1) {
                            string = tree.run(false);
                        } else if (op == 2) {
                            string = tree.run(true);
                        }
                        System.out.println(string);
                        if (string.equals("No se!")) {
                            String a, q;
                            System.out.println("Digite informacion a aprender: (pregunta Enter respuesta)");
                            q = read.next();
                            a = read.next();
                            tree.learn(q, a);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Arbol:");
                    treeIndex = read.nextInt();
                    if ((tree = forest.get(treeIndex)) != null) {
                        System.out.print("La Rama mas larga es: ");
                        LinkedList<Node> list = new LinkedList<>();
                        list = tree.biggerBranch(tree.getRoot(), list);
                        for (int i = 0; i < list.size(); i++) {
                            Node node = list.get(i);
                            System.out.print(node.getString() + "-");
                        }
                        //for (Node node : list) {
                        //    System.out.print(node.getString() + "-");
                        //}
                        justShow(tree);
                    }
                    break;

                case 8:
                    //System.out.println(tree.allNodes(tree.getRoot()));
                    System.out.println("1.Guardar - 2.Cargar: - 3.Guardar todo - 4.Cargar Todo (el primero) ");
                    int a = read.nextInt();
                    switch (a) {
                        case 1:
                            System.out.println("Arbol:");
                            treeIndex = read.nextInt();
                            if ((tree = forest.get(treeIndex)) != null) {
                                tree.save();
                            }
                            break;
                        case 2:
                            System.out.println("Arbol:");
                            treeIndex = read.nextInt();
                            forest.add(Tree.load(treeIndex));
                            break;
                        case 3:
                            saveAll();
                            break;
                        default:
                            forest.addAll(Tree.loadAll());
                            break;
                    }
                    break;
                default:
                    op = 0;
                    break;
            }
            System.out.println("\n");
            //System.out.println("\n\n");
        } while (op != 0);
    }*/
}
