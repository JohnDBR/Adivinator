/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

/**
 *
 * @author john
 */
public class Master {

    private final TreeManager tm;
    private final UserManager um;

    private int pointsCounter;
    private float startTime;

    public Master() {
        tm = new TreeManager();
        um = new UserManager();
        init();
    }

    private void init() {
        tm.loadAll();
        um.loadAll();
    }

    public void close() {
        tm.saveAll();
        um.saveAll();
    }

    public TreeManager getTm() {
        return tm;
    }

    public UserManager getUm() {
        return um;
    }

    public void newGame() {
        pointsCounter = 0;
        startTime = System.nanoTime() / 1000000000;
    }

    public void addPoint() {
        pointsCounter++;
    }

    public int getPoints() {
        return pointsCounter;
    }

    private float getDeltaTime() {
        return System.nanoTime() / 1000000000 - startTime;
    }

    public String getTime() {
        String segundo = (int) getDeltaTime() % 60 + "", minuto = (int) (getDeltaTime() / 60) % 3600 + "", hora = (int) getDeltaTime() / 3600 + "";
        if (segundo.length() == 1) {
            segundo = "0" + segundo;
        }
        if (minuto.length() == 1) {
            minuto = "0" + minuto;
        }
        if (hora.length() == 1) {
            hora = "0" + hora;
        }
        return hora + ":" + minuto + ":" + segundo;
    }
}
