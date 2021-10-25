/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoesshoprustem;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;
import shopclasses.Client;
import shopclasses.History;
import shopclasses.Model;



public class Shop {
    float opa = 0;
    Scanner scanner = new Scanner(System.in);
    private Model[] models = new Model[10];
    private Client[] client = new Client[10];
    private History[] histories = new History[10];
  
    double shopStonks = 0;
    Calendar c = new GregorianCalendar();
    public Shop() {

    }
    public void run(){
        String repeat = "r";
        do{
            System.out.println("Задача - 0: Выход из программы");
            System.out.println("Задача - 1: Добавить модель");
            System.out.println("Задача - 2: Список моделей");
            System.out.println("Задача - 3: Добавить инфо о покупателе");
            System.out.println("Задача - 4: Инфо о покупателе");
            System.out.println("Задача - 5: Покупка покупателем обуви");
            System.out.println("Задача - 6: Доход магазина за всё время работы");
            System.out.printf("~~~ Поменять номер задачи ~~~ = ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("Хорошего дня!");
                    break;
                case 1:
                    System.out.println("-- Добавить модель --");
                    for (int i = 0; i < models.length; i++) {
                        if(models[i] == null){
                            models[i] = addModel();

                            break;
                        }
                    }
                    break;
                case 2:
                  System.out.println("-- Список моделей --");
                    for (int i = 0; i < models.length; i++) {
                        if(models[i] != null){
                            System.out.println(models[i].toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("-- Добавить клиента --");
                    for (int i = 0; i < client.length; i++) {
                        if(client[i] == null){
                            client[i] = addClient();
 
                            break;
                        }
                    }
                case 4:
                    System.out.println("-- Инфо о покупателе --");
                    for (int i = 0; i < client.length; i++) {
                        if(client[i] != null){
                            System.out.println(client[i].toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("-- Предметы --");
                    for (int i = 0; i < client.length; i++) {
                        if(histories[i] == null){
                            histories[i] = addHistory();
                            break;
                        }
                    }
                break;
                case 6:
                    System.out.println("-- Доход магазина --");
                    System.out.println(opa);
                default:
                    System.out.println("Измените номер списка!");;
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
        System.out.print("Название модели: ");
        model.setModelFirm(scanner.nextLine()); 

        
        
        
       
        return model;
    }
    private Client addClient(){
        Client client = new Client();
        System.out.print("Имя покупателя: ");
        client.setName(scanner.nextLine());
        System.out.print("Фамилия покупателя: ");
        client.setSurname(scanner.nextLine());
        System.out.print("Число покупателей: ");
        client.setMobile(scanner.nextLine());
        System.out.print("Деньги покупателя: ");
        client.setMoney(scanner.nextDouble());
        return client;
    }

    private History addHistory() {
        History history = new History();
       

        System.out.println("Список предметов: ");
        for (int i = 0; i < models.length; i++) {
            if(models[i] != null){
                System.out.println(i+1+" "+models[i].toString());
            }
        }
        System.out.print("Выберите товар: ");
        int numberModel = scanner.nextInt(); scanner.nextLine();
        System.out.print("Будет продано -> ");
        for (int i = 0; i < client.length; i++) {
            if(client[i] != null){
                System.out.println(i+1+" "+client[i].toString());
            }
        }
        System.out.println("Кто покупает этот товар: ");
        int numberClient = scanner.nextInt();scanner.nextLine();
        history.setModel(models[numberModel - 1]);
        history.setClient(client[numberClient - 1]);
           Calendar c = new GregorianCalendar();
           double MMoney = models [numberClient - 1].getPrice();
           double CMoney = client[numberClient - 1].getMoney(); 
                if(CMoney >=MMoney){
                client [numberClient-1].setMoney(client[numberClient-1].getMoney()-models[numberClient-1].getPrice());
                opa+=models[numberClient-1].getPrice();
                   }else{
                       System.out.println("Недостаточно средств на счету!");
                       
                   }
            
        return history;
    }
}
