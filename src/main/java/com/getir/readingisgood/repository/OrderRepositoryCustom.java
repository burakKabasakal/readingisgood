package com.getir.readingisgood.repository;

import com.getir.readingisgood.dto.statistic.StatisticDto;
import com.getir.readingisgood.enums.OrderState;

public interface OrderRepositoryCustom {
    StatisticDto monthlyOrderStatisticsForCustomer(String customerId, OrderState orderState);
}
