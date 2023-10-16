package com.gildedrose.v1;

import com.gildedrose.v1.strategy.DefaultItemQualityStrategy;
import com.gildedrose.v1.strategy.QualityStrategy;

import java.util.List;

public class QualityStrategyFactory {

    private final List<QualityStrategy> strategies;

    public QualityStrategyFactory(List<QualityStrategy> strategies) {
        this.strategies = strategies;
    }

    public QualityStrategy get(String name) {
        return strategies.stream()
            .filter(s -> s.isSupport(name))
            .findFirst()
            .orElseGet(() -> new DefaultItemQualityStrategy());
    }
}
