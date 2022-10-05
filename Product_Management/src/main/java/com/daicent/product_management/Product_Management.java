/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.daicent.product_management;

import com.daicent.Entity.Category;
import com.daicent.Entity.Product;
import com.daicent.Entity.Product_Category;
import com.daicent.dao.CategoryDao;
import com.daicent.dao.ProductDao;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENNOVO
 */
public class Product_Management {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("Option list:");
            System.out.println("1: Category Name");
            System.out.println("2: Show all product");
            System.out.println("3: Search product by ID");
            System.out.println("4: Search product by Name");
            System.out.println("5: Exit!");
            System.out.print("Your option: ");

            option = sc.nextInt();
            System.out.println("------------------------");
            switch (option) {
                case 1:
                    System.out.println("Category include: ");
                    CategoryDao dbCate = new CategoryDao();
                    List<Category> cate = dbCate.getCategory();
                    for (Category category : cate) {
                        ProductDao dbc = new ProductDao();
                        System.out.println(category);
                        List<Product_Category> pc = dbc.searchByCategory(category.getName());
                        for (Product_Category product_Category : pc) {
                            System.out.println(product_Category.toString());
                        }
                    }
                    System.out.println("------------------------");
                    break;

                case 3:
                    System.out.println("Search product by ID");
                    ProductDao db = new ProductDao();
                    System.out.print("Enter ID:");
                    int n = sc.nextInt();
                    System.out.println(db.searchByID(n).toString());
                    System.out.println("------------------------");
                    break;

                case 4:
                    System.out.println("Search product by Name");
                    System.out.print("Enter name product: ");
                    String name = sc.next();
                    ProductDao db1 = new ProductDao();
                    List<Product> list = db1.searchByName(name);
                    for (Product product : list) {
                        System.out.println(product);
                    }
                    System.out.println("------------------------");
                    break;

                case 2:
                    ProductDao db2 = new ProductDao();
                    List<Product> listPro = db2.getAllProduct();
                    for (Product product : listPro) {
                        System.out.println(product.toString());
                    }
                    System.out.println("------------------------");
                    break;
                case 5: //QUIT (exit out to main menu)
                    return;
                default:
                    System.out.println("Cannot found options!");
            }
        } while (option < 5);
        System.out.println("Do you want continue? Enter y if you want continue.");
        System.out.print("Your answer: ");
        String s = sc.next();
        if (s.equalsIgnoreCase("y")) {
            option = sc.nextInt();
        } else {
            System.out.println("Exit!");
        }
    }
}
