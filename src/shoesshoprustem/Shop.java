/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoesshoprustem;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import shopclasses.Client;
import shopclasses.History;
import shopclasses.Model;

/**
 *
 * @author ruste
 */
public class Shop {
    Scanner scanner = new Scanner(System.in);
    private Model[] model = new Model[10];
    private Client[] client = new Client[10];
    private History[] histories = new History[10];
    Calendar c = new GregorianCalendar(); 
    public void run() {
        String repeat = "r";
        do{
            System.out.println("0: Выход из программы");
            System.out.println("1: Добавить модель");
            System.out.println("2: Список продаваемых моделей");
            System.out.println("3: Добавить покупателя");
            System.out.println("4: Список зарегистрированных покупателей");
            System.out.println("5: Покупка покупателем обуви");
            System.out.println("6: Доход магазина за всё время работы");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "q";
                    System.out.println("Have a nice day, bye!");
                    break;
                case 1:
                    System.out.println("~~~~~ Добавить модель ~~~~~");
                    for (int i = 0; i < model.length; i++) {
                        if(model[i] == null){
                            model[i] = addModel();
                            break;
                        }
                    }
                    break;
                case 2:
                  System.out.println("~~~~~ Список продаваемых моделей ~~~~~");
                    for (int i = 0; i < model.length; i++) {
                        if(model[i] != null){
                            System.out.println(model[i].toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("~~~~~ Добавить покупателя ~~~~~");
                    for (int i = 0; i < client.length; i++) {
                        if(client[i] == null){
                            client[i] = addClient();
                            break;
                        }
                    }
                case 4:
                    System.out.println("~~~~~ Список зарегистрированных покупателей ~~~~~ ");
                    for (int i = 0; i < client.length; i++) {
                        if(client[i] != null){
                            System.out.println(client[i].toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("~~~~~ Покупка покупателем обуви ~~~~~");
                    for (int i = 0; i < client.length; i++) {
                        if(histories[i] == null){
                            histories[i] = addHistory();
                            break;
                        }
                    }
                break;
                case 6:
                    int n = 0;
                    System.out.println("~~~~~ Доход магазина за всё время работы ~~~~~");
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] != null){
                            System.out.println(histories[i].toString());
                            System.out.println(" "+histories[i].getModel().getModelName()
                                +" "+histories[i].getClient().getName()
                                +" "+ histories[i].getClient().getSurname());
                            n++;
                        }
    
                    }    
            }
        }while ("r".equals(repeat));
    }
     private Model addModel(){
        Model model = new Model();
        System.out.print("Название модели: ");
        model.setModelName(scanner.nextLine());
        System.out.print("Размер модели: ");
        model.setModelSize(scanner.nextLine());
        System.out.print("Цена модели: ");
        model.setPrice(scanner.nextDouble());scanner.nextLine();
        System.out.print("Название фирмы: ");
        model.setModelFirm(scanner.nextLine()); 
        return model;
        
    }
    private Client addClient(){
        Client client = new Client();
        System.out.print("Имя покупателя: ");
        client.setName(scanner.nextLine());
        System.out.print("Фамилия покупателя: ");
        client.setSurname(scanner.nextLine());
        System.out.print("Кол-во покупателей: ");
        client.setMobile(scanner.nextLine());
        System.out.print("Платёж клиента: ");
        client.setMoney(scanner.nextDouble());
        System.out.printf("Поменять номер =");
        return client;
        
    }
    
    private History addHistory() {
        History history = new History();
        
        System.out.println("Список моделей: ");
        for (int i = 0; i < model.length; i++) {
            if(model[i] != null){
                System.out.println(i+1+" "+model[i].toString());
            }
        }
        System.out.print("Поменять/Изменить модель: ");
        int numberModel = scanner.nextInt(); scanner.nextLine();
        System.out.print("Будет продано -> ");
        for (int i = 0; i < client.length; i++) {
            if(client[i] != null){
                System.out.println(i+1+" "+client[i].toString());
            }
        }
        System.out.println("Кто покупает эту модель: ");
        int numberClient = scanner.nextInt();scanner.nextLine();
        history.setModel(model[numberModel - 1]);
        history.setClient(client[numberClient - 1]);
           Calendar c = new GregorianCalendar();
           double MMoney = model [numberClient - 1].getPrice();
           double CMoney = client[numberClient - 1].getMoney();
           double finMoney = 0;
                   if(CMoney >=MMoney){
                       finMoney = CMoney - MMoney;
                   }else{
                       System.out.println("//Извините, у вас недостаточно средств//");
                       
                   }
                   history.getClient().setMoney(finMoney);
           history.setGivendate(c.getTime());
        return history;
    }   
}
