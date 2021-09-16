package com.getir.readingisgood.repository.impl;

import com.getir.readingisgood.dto.statistic.StatisticDto;
import com.getir.readingisgood.enums.OrderState;
import com.getir.readingisgood.repository.OrderRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public StatisticDto monthlyOrderStatisticsForCustomer(String customerId, OrderState orderState) {

//        mongoTemplate.up
//
//        final Aggregation aggregation = newAggregation(
//          match(Criteria.where("orderState").is(orderState).and("customerId").is(customerId)),
//                project("","")
//
//        );
//
//
//
//        final Aggregation aggregation = newAggregation(
//                //Get only PURCHASED ones
//                match(Criteria.where("orderStatus").is(OrderStatus.PURCHASED)),
//                //We need two fields and month
//                project("quantity", "totalPrice").and(DateOperators.Month.month("$createdDate")).as("month"),
//                //Group to month and calculate other fields
//                group("month").count().as("totalOrderCount")
//                        .sum("quantity").as("totalBookCount")
//                        .sum("totalPrice").as("totalPurchasedAmount"),
//                //We have to re-projection to get rid of the _id field
//                project("totalOrderCount", "totalBookCount", "totalPurchasedAmount")
//                        .and("month").previousOperation(),
//                //Sort by month
//                sort(Sort.Direction.DESC, "month")
//        );
        return null;
    }
}
