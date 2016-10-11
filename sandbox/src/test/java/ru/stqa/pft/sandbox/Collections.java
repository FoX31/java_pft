package ru.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by e.kutsenko on 11.10.2016.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Photon", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Photon", "PHP");

    for (String l : languages){
      System.out.println("Я хочу выучить" + l);
    }
  }
}
