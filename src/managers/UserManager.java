/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import models.User;
import structures.linkedlist.LinkedList;

/**
 *
 * @author john
 */
public class UserManager {

    private LinkedList<User> users;
    private User selectedUser;

    private boolean loaded;

    public UserManager() {
        loaded = false;
        users = new LinkedList<>();
        selectedUser = null;
    }

    public void saveAll() {
        if (users != null) {
            for (int i = 0; i < users.size(); i++) {
                users.get(i).save();
            }
        }
    }

    public void loadAll() {
        if (!loaded) {
            users.addAll(User.loadAll());
            loaded = true;
        }
    }

    public User get(String name) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void save(String name) {
        try {
            get(name).save();
        } catch (Exception e) {
        }
    }

    public void createUser(String name) {
        if (get(name) == null) {
            users.add(new User(name));
        }
    }

    public void scoreToUser(String name, int newScore) {
        try {
            get(name).updateScore(newScore);
        } catch (Exception e) {
        }
    }

    public void updateUser(String oldName, String newName) {
        User user = null;
        if ((user = get(oldName)) != null && get(newName) == null) {
            user.setName(newName);
        }
    }

    public void deleteUser(String name) {
        users.delete(get(name));
    }

    public int getScoreOfUser(String name) {
        try {
            return get(name).getTopScore();
        } catch (Exception e) {
            return -1;
        }
    }

    public void selectUser(String name) {
        selectedUser = get(name);
        //for (int i = 0; i < users.size(); i++) {
        //    User user = users.get(i);
        //    if (user.getName().equals(name)) {
        //        selectedUser = user;
        //        return;
        //    }
        //}
    }

    public void scoreToSelectedUser(int newScore) {
        if (selectedUser != null) {
            selectedUser.updateScore(newScore);
        }
    }

    public void updateSelectedUser(String newName) {
        if (get(newName) == null && selectedUser != null) {
            selectedUser.setName(newName);
        }
    }

    public void deleteSelectedUser() {
        users.delete(selectedUser);
    }

    public int getScoreSelectedUser() {
        if (selectedUser != null) {
            return selectedUser.getTopScore();
        } else {
            return -1;
        }
    }

    public void saveSelectedUser() {
        if (selectedUser != null) {
            selectedUser.save();
        }
    }
}
