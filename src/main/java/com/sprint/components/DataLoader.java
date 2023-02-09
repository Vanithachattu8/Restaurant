//package com.sprint.components;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import com.sprint.models.Booking;
//import com.sprint.models.Customer;
//import com.sprint.models.Restaurant;
//import com.sprint.models.Transaction;
//import com.sprint.repository.CustomerRepository;
//import com.sprint.repository.RestaurantRepository;
//import com.sprint.repository.TransactionRepository;
//
////@Component
//public class DataLoader implements ApplicationRunner {
//
//    @Autowired
//    com.sprint.repository.BookingRepository bookingRepository;
//    @Autowired
//    CustomerRepository customerRepository;
//    @Autowired
//    RestaurantRepository restaurantRepository;
//    @Autowired
//    TransactionRepository transactionRepository;
//
//    public DataLoader() {
//
//    }
//
//    public void run(ApplicationArguments args) {
//
//        // 6 table of 4:
//        Restaurant table1 = new Restaurant(1,4);
//        restaurantRepository.save(table1);
//        Restaurant table2 = new Restaurant(2, 4);
//        restaurantRepository.save(table2);
//        Restaurant table3 = new Restaurant(3, 4);
//        restaurantRepository.save(table3);
//        Restaurant table4 = new Restaurant(4, 4);
//        restaurantRepository.save(table4);
//        Restaurant table5 = new Restaurant(5, 4);
//        restaurantRepository.save(table5);
//        Restaurant table6 = new Restaurant(6, 4);
//        restaurantRepository.save(table6);
//        Restaurant table7 = new Restaurant(7, 4);
//        restaurantRepository.save(table7);
//        Restaurant table8 = new Restaurant(8, 4);
//        restaurantRepository.save(table8);
//        Restaurant table9 = new Restaurant(9, 4);
//        restaurantRepository.save(table9);
//        Restaurant table10 = new Restaurant(10, 4);
//        restaurantRepository.save(table10);
//        Restaurant table11 = new Restaurant(11, 4);
//        restaurantRepository.save(table11);
//        Restaurant table12 = new Restaurant(12, 4);
//        restaurantRepository.save(table12);
//        Restaurant table13 = new Restaurant(13, 4);
//        restaurantRepository.save(table13);
//        Restaurant table14 = new Restaurant(14, 4);
//        restaurantRepository.save(table14);
//        Restaurant table15 = new Restaurant(15, 4);
//        restaurantRepository.save(table15);
//        Restaurant table16 = new Restaurant(16, 4);
//        restaurantRepository.save(table16);
//        Restaurant table17 = new Restaurant(17, 4);
//        restaurantRepository.save(table17);
//        Restaurant table18 = new Restaurant(18, 4);
//        restaurantRepository.save(table18);
//        Restaurant table19 = new Restaurant(19, 4);
//        restaurantRepository.save(table19);
//        Restaurant table20 = new Restaurant(20, 4);
////
//        List myTables = new ArrayList<Restaurant>(Arrays.asList((table1)));
//        List myTables2 = new ArrayList<Restaurant>(Arrays.asList((table18)));
//        List myTables3 = new ArrayList<Restaurant>(Arrays.asList((table19)));
//        List myTables4 = new ArrayList<Restaurant>(Arrays.asList((table11)));
//
//      // 5 customers:
//        Customer customer1 = new Customer("Likhitha",10, 0732452344);
//        customerRepository.save(customer1);
//        Customer customer2 = new Customer("Ramya",10, 0734645673);
//        customerRepository.save(customer2);
//        Customer customer3 = new Customer("Navya",10, 0723434435);
//        customerRepository.save(customer3);
//        Customer customer4 = new Customer("Vanitha", 10,07233573256);
//        customerRepository.save(customer4);
//        Customer customer5 = new Customer("Deepika", 10,01314411321);
//        customerRepository.save(customer5);
//      // 3 bookings:
//        Booking booking1 = new Booking(LocalDate.now(),LocalTime.now(),5, customer1, myTables4);
//        bookingRepository.save(booking1);
//        Booking booking2 = new Booking(LocalDate.now(), LocalTime.now(), 3,customer5, myTables4);
//        bookingRepository.save(booking2);
//        Booking booking3 = new Booking(LocalDate.now(),LocalTime.now(), 2, customer3, myTables2);
//        bookingRepository.save(booking3);
//        Booking booking4 = new Booking(LocalDate.now(),LocalTime.now(), 10, customer4, myTables3);
//        bookingRepository.save(booking4);
//        Booking booking5 = new Booking(LocalDate.now(),LocalTime.now(), 6,customer2, myTables);
//        bookingRepository.save(booking5);
//
//          // transactions:
//        Transaction transaction1 = new Transaction(LocalDate.parse("2023-02-04"),LocalDate.parse("2023-02-01"), 234, booking5);
//        Transaction transaction2 = new Transaction(LocalDate.parse("2023-02-04"), LocalDate.parse("2023-02-01"),150, booking2);
//        Transaction transaction3 = new Transaction(LocalDate.parse("2023-02-04"), LocalDate.parse("2023-02-01"), 25, booking3);
//        Transaction transaction4 =new Transaction(LocalDate.parse("2023-02-04"),LocalDate.parse("2023-02-01"), 40,  booking4);
//
//        transactionRepository.save(transaction1);
//        transactionRepository.save(transaction2);
//        transactionRepository.save(transaction3);
//        transactionRepository.save(transaction4);
//
//        
//
//    }}
