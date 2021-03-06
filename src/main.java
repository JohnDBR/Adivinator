
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import managers.Master;
import structures.tree.Tree;
import view.Log_in_Frame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author john
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Este main es de desarrollo esta preprogramado para iniciar automaticamente la version de usuario.
        //System.out.println("CARGANDO ARBOL! Espera hey...");
        Master m = new Master();
        m.getTm().selectTree(0);
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int op, r;
        do {
            System.out.println(
                    "NOTA: el valor -1 en mi laboratorio es nulo, vacio\n\n"
                    + "Opciones:\n"
                    + " 1. Crear Arbol\n"
                    + " 2. Mostrar Arbol\n"
                    + " 3. Recorrer Arbol mediante booleanos\n"
                    + " 4. Guardar Arbol\n"
                    + " 5. Seleccionar Arbol\n"
                    + " 6. Ejecutar programa con vistas\n"
                    + " 0. Salir"
            );
            System.out.println("OPCION: ");
            //op = Integer.valueOf(read.readLine());
            op = 6;
            System.out.println("");
            switch (op) {
                case 1:
                    m.getTm().createTree();
                    break;
                case 2:
                    m.getTm().justShow();
                    break;
                case 3:
                    r = 1;
                    System.out.println(m.getTm().getInSelectedTree());
                    do {
                        System.out.println("1-True, 2-False)");
                        r = Integer.valueOf(read.readLine());
                        String result = "";
                        if (r == 1) {
                            result = m.getTm().moveInSelectedTree(true);
                        } else if (r == 2) {
                            result = m.getTm().moveInSelectedTree(false);
                        }
                        System.out.println(result);
                        if (result.equals("No se!")) {
                            String a, q;
                            System.out.println("Digite informacion a aprender: (pregunta Enter respuesta)");
                            q = read.readLine();
                            a = read.readLine();
                            System.out.println(q + "-" + a);
                            if (!q.contains("-") && !a.contains("-")) {
                                m.getTm().learnInSelectedTree(q, a);
                            }
                            r = 3;
                        } else if (result.equals("Juego terminado!")) {
                            r = 3;
                        }
                    } while (r == 1 || r == 2);
                    break;
                case 4:
                    m.getTm().saveInSelectedTree();
                    break;
                case 5:
                    System.out.println("ARBOL: ");
                    r = Integer.valueOf(read.readLine());
                    System.out.println(m.getTm().selectTree(r));
                    break;
                case 6:
                    new Log_in_Frame();
                    op = 0;
                    break;
                case 7:

                    break;

                case 8:

                    break;
                default:
                    op = 0;
                    break;
            }
            System.out.println("\n");
            //System.out.println("\n\n");
        } while (op != 0);
        m.close();
    }

}
