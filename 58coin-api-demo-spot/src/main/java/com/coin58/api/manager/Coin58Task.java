
//package com.coin58.api.manager;
//
//import com.coin58.api.consumer.AccountConsumer;
//import com.coin58.api.consumer.OrderConsumer;
//import com.coin58.api.consumer.PublicConsumer;
//import com.coin58.api.enums.OrderStatusEnum;
//import com.coin58.api.enums.SideEnum;
//import com.coin58.api.services.AccountService;
//import com.coin58.api.services.OrderService;
//import com.coin58.api.services.PublicService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.util.concurrent.Executor;
//
///**
// * @author coin58 - 2018/3/24.
// */
//@Component
//@Slf4j
//public class Coin58Task {
//
//    private final Executor apiExecutor;
//    private final Coin58Executor executor;
//    private final PublicService publicService;
//    private final PublicConsumer publicConsumer;
//    private final AccountService accountService;
//    private final AccountConsumer accountConsumer;
//    private final OrderService orderService;
//    private final OrderConsumer orderConsumer;
//    private Boolean limit = Boolean.FALSE;
//    private int limitCount = 0;
//
//    @Autowired
//    public Coin58Task(Coin58Executor executor,
//                      @Qualifier("coin58-publicService") PublicService publicService,
//                      @Qualifier("coin58-publicConsumer") PublicConsumer publicConsumer,
//                      @Qualifier("coin58-accountService") AccountService accountService,
//                      @Qualifier("coin58-orderService") OrderService orderService,
//                      @Qualifier("coin58-accountConsumer") AccountConsumer accountConsumer,
//                      @Qualifier("coin58-orderConsumer") OrderConsumer orderConsumer,
//                      @Qualifier("api-executor") Executor apiExecutor) {
//        this.executor = executor;
//        this.publicService = publicService;
//        this.publicConsumer = publicConsumer;
//        this.accountService = accountService;
//        this.orderService = orderService;
//        this.accountConsumer = accountConsumer;
//        this.orderConsumer = orderConsumer;