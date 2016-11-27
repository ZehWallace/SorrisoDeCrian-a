/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorrisodecrianca;

/**
 *
 * @author Bruno
 */
public class testeclass {
    public static void main(String[] args) 
    {
        String rg = "38.094.168-5";
        rg = rg.replaceAll("\\.", "").replaceAll("-", "").replaceAll("/", "");
        System.out.println(rg);
    }
  
}
