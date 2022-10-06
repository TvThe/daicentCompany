/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.daicent.testproduct;

import com.daicent.Entity.Category;
import com.daicent.Entity.CategoryDetail;
import com.daicent.Entity.Product;
import com.daicent.dao.CategoryDao;
import com.daicent.dao.ProductDao;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENNOVO
 */
public class TestProduct {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("Option list:");
            System.out.println("1: Category Name");
            System.out.println("2: Show all product");
            System.out.println("3: Search product by ID");
            System.out.println("4: Search product by Name");
            System.out.println("5: Search by Category Detail Name");
            System.out.println("6: Exit!");
            System.out.print("Your option: ");

            option = sc.nextInt();
            System.out.println("------------------------");
            switch (option) {
                case 1:
                    ProductDao dbProduct = new ProductDao();
                    CategoryDao c = new CategoryDao();
                    List<Category> cate = c.getCategory();
                    for (Category category : cate) {
                        System.out.println(category.getName());
                        System.out.println("-----------------");
                        List<CategoryDetail> list = c.getCategoryDeatail(category.getName());
                        for (CategoryDetail categoryDetail : list) {
                            System.out.println(categoryDetail);
                            System.out.println("-----------------");
                            List<Product> product = dbProduct.getByDetailName(categoryDetail.getName());
                            for (Product product1 : product) {
                                System.out.println(product1);

                            }
                            System.out.println("-----------------");
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
                case 5: 
                    ProductDao dbdao = new ProductDao();
                    System.out.println("Enter Detail Name: ");
                    String s = sc.next();
                    List<Product> listp = dbdao.getByDetailName(s);
                    for (Product product : listp) {
                        System.out.println(product.toString());
                    }
                    break;
                case 6 :
                    return;
                default:
                    System.out.println("Cannot found options!");
            }
        } while (option < 6);
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
