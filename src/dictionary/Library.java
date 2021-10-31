/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Dell 2419h
 */
public class Library {
    static final String F = "init.txt";
    private Vector<String> key = new Vector<>();
    private Vector<String> translate = new Vector<>();
    private Vector<Integer> historys = new Vector<>();

    public void readFile() throws IOException {
        FileReader file = new FileReader(F);
        BufferedReader reader = new BufferedReader(file);
        try {
            String line = reader.readLine();
            String temp = new String();
            while (line != null) {
                if (line.length() == 0) {
                    temp += "\n";
                    line = reader.readLine();
                    continue;
                }
                if (line.charAt(0) == '@') {
                    if (temp.length() != 0) {
                        translate.add(temp);
                    }
                    int k = 0;
                    boolean check = true;
                    while (line.charAt(k) != '/' && check) {
                        k++;
                        if (k == line.length()-1){
                            check = false;
                        }
                    }
                    if (check) {
                        String str_1 = line.substring(1, k - 1);
                        String str_2 = line.substring(k-1, line.length());
                        key.add(str_1);
                        temp = str_2 + "\n";
                    } else {
                        String str = line.substring(1, line.length());
                        key.add(str);
                        temp = "\n";
                    }
                } else {
                    temp = temp.concat(line);
                    temp += "\n";
                }
                //System.out.println(line);
                line = reader.readLine();
            }
            translate.add(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        file.close();
    }

    public void writeFile() throws IOException {
        FileWriter file = new FileWriter("aa.txt");
        BufferedWriter writer = new BufferedWriter(file);
        int n = key.size();
        for (int i = 0; i < n; i++) {
            writer.write("@" +key.get(i));
            writer.write(translate.get(i));
        }
        writer.close();
        file.close();
    }

    public int binSearch(String data) {
        int left = 0;
        int right = key.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (key.get(mid).compareTo(data) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
            if (key.get(left).compareTo(data) == 0) {
                return left;
            }
        }
        return -1;
    }

    public String searchWord(String data) {
        int k = binSearch(data);
        if (k < 0) {
            return "...";
        } else {
            return translate.get(k);
        }
    }

    public boolean addWord(String data, String value) {
        int k = binSearch(data);
        if (k >= 0 || value.length() == 0) {
            return false;
        }
        k = 0;
        while (key.get(k).compareTo(data) < 0) {
            k ++;
        }
        key.add(k, data);
        translate.add(k, value);
        return true;
    }

    public boolean deleteWord(String data) {
        int k = binSearch(data);
        if (k < 0) {
            return false;
        }
        key.remove(key.get(k));
        translate.remove(translate.get(k));
        return true;
    }

    public void historyWord(int k) {
        historys.add(k);
    }

    public void printcc() {
        for (int i = 0; i < 4; i++) {
            System.out.println(key.get(i));
            System.out.println(translate.get(i));
        }
    }
}
