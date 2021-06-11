//package com.senior.controllers;
//
//import com.senior.controller.ClientController;
//import com.senior.service.ClientService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ClientController.class)
//public class ClientTest {
//
//    @Autowired
//    ClientController clientController;
//
//    @MockBean
//    ClientService mock;
//
//    @BeforeEach
//    void setup() {
//        standaloneSetup(this.clientController);
//    }
//}
