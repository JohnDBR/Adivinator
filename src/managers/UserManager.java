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

    public UserManager() {
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
        users.clear();
        users.addAll(User.loadAll());
        sortUsers(0, users.size() - 1);
    }

    private void sortUsers(int left, int right) { //Need testing...
        User pivot = users.get(left); //we took the first element as pivot
        int i = left;  //i searches from left to right
        int j = right; //j searches from right to left

        while (i < j) {            //while the searches do not cross
            while (users.get(i).getTopScore() <= pivot.getTopScore() && i < j) {
                i++; //search the element greater than pivot
            }
            while (users.get(j).getTopScore() > pivot.getTopScore()) {
                j--; //search the element smaller than pivot
            }
            if (i < j) { //if they have not been crossed, it exchange
                users.changePosition(i, j);
            }
        }
        users.set(left, users.get(j)); //The pivot is putted in its place so we have
        users.set(j, pivot); //the minors to the left and the majors to the right
        if (left < j - 1) {
            sortUsers(left, j - 1); // we order the left subLinkedList 
        }
        if (j + 1 < right) {
            sortUsers(j + 1, right); // we order the right subLinkedList
        }
    }

    public User get(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return users.get(i);
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
        //if (get(name) == null) {
        users.add(new User(name));
        //}
    }

    public boolean scoreToUser(String name, int newScore) {
        try {
            get(name).updateScore(newScore);
        } catch (Exception e) {
            return false;
        }
        return true;
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

    public boolean selectUser(String name) {
        selectedUser = get(name);
        return selectedUser != null;
        //for (int i = 0; i < users.size(); i++) {
        //    User user = users.get(i);
        //    if (user.getName().equals(name)) {
        //        selectedUser = user;
        //        return;
        //    }
        //}
    }

    private User getSelectedUser() {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(selectedUser)) {
                return users.get(i);
            }
        }
        return null;
    }

    public void scoreToSelectedUser(int newScore) {
        if (selectedUser != null) {
            getSelectedUser().updateScore(newScore);
        }
    }

    public void updateSelectedUser(String newName) {
        if (get(newName) == null && selectedUser != null) {
            getSelectedUser().setName(newName);
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

    public LinkedList<User> getTop5() {
        sortUsers(0, users.size() - 1);
        LinkedList<User> top5 = new LinkedList<>();
        try {
            for (int i = 0; i < 5; i++) {
                top5.add(users.get(i));
            }
        } catch (Exception e) {
        }
        return top5;
    }
}
