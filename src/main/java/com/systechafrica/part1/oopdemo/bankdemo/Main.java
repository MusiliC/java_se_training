package com.systechafrica.part1.oopdemo.bankdemo;

public class Main {

    public static void main(String[] args) {
        Account account = new Account("011", 200, "Cee", "musili@gmail.com", "0700");

        account.depositMoney(100);
    }
}
