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

}
