package com.example.ruleengine.service;

import com.example.ruleengine.engine.RuleEvaluator;
import com.example.ruleengine.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleService {

    private final List<String> rules = new ArrayList<>();

    public void addRules(List<String> newRules) {
        rules.clear();
        rules.addAll(newRules);
    }

    public List<String> getRules() {
        return rules;
    }

    public List<Transaction> evaluate(List<Transaction> transactions) {
        List<Transaction> matched = new ArrayList<>();

        for (Transaction tx : transactions) {
            if (RuleEvaluator.evaluate(tx, rules)) {
                matched.add(tx);
            }
        }
        return matched;
    }
}
