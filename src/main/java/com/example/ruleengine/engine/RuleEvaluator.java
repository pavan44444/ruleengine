package com.example.ruleengine.engine;

import com.example.ruleengine.model.Transaction;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;

public class RuleEvaluator {

    public static boolean evaluate(Transaction tx, List<String> rules) {

        if (rules == null || rules.isEmpty()) {
            return false;
        }

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(tx);

        for (String rule : rules) {
            try {
                Boolean result = parser
                        .parseExpression(rule)
                        .getValue(context, Boolean.class);

                if (Boolean.TRUE.equals(result)) {
                    return true;
                }

            } catch (Exception e) {
                // ignore invalid rule and continue
            }
        }
        return false;
    }
}
