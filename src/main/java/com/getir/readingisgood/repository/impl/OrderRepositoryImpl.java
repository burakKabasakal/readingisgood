package com.getir.readingisgood.repository.impl;

import com.getir.readingisgood.dto.statistic.StatisticDto;
import com.getir.readingisgood.enums.OrderState;
import com.getir.readingisgood.model.Order;
import com.getir.readingisgood.repository.OrderRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

       @Override
    public List<StatisticDto> monthlyOrderStatisticsForCustomer(String customerId, OrderState orderState) {
        //find customer with APPROVED state
        //order's amount and count specified fields group with createdDate months
        //then prepare totalOrderCount, totalBookCount and totalAmount
        // and sort with createdDate
        /**
         *  NOTE: Some of decimal amount values like 3.5234234, 5.5345435 sometimes give the wrong total because of scale.
         *  Each of them should firstly scale and added.
          */
        final Aggregation aggregation = newAggregation(
                match(Criteria.where("orderState").is(orderState).and("customerId").is(customerId)),

                project("amount","count").and(DateOperators.Month.month("$createdDate")).as("month"),
                group("month").count().as("totalOrderCount")
                        .sum("count").as("totalBookCount")
                .sum("amount").as("totalAmount"),
                project("totalOrderCount","totalBookCount","totalAmount").and("month")
                        .previousOperation(), //
                sort(Sort.Direction.ASC,"month")
        );

            return mongoTemplate.aggregate(aggregation,Order.class,StatisticDto.class).getMappedResults();
// https://www.mongodb.com/community/forums/t/group-query-result-by-month-in-mongotemplate/117680
// https://gist.github.com/japharr/f15a871d853ff45398f7f02667000e51

    }
}
