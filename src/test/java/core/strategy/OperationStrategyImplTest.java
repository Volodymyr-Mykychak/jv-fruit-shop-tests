package core.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static core.basesyntax.model.FruitTransaction.Operation.*;
import static org.junit.Assert.assertEquals;

public class OperationStrategyImplTest {
    private OperationStrategy operationStrategy;
    private Map<FruitTransaction.Operation, OperationHandler> map;

    @Before
    public void setUp() {
        map = new HashMap<>();
        map.put(BALANCE, new BalanceOperationHandler());
        map.put(SUPPLY, new SupplyOperationHandler());
        map.put(PURCHASE, new PurchaseOperationHandler());
        map.put(RETURN, new ReturnOperationHandler());
        operationStrategy = new OperationStrategyImpl(map);
    }

    @Test
    public void operationStrategy_ValidBalanceHandler_Ok() {
        Class<? extends OperationHandler> actual =
                operationStrategy.getOperationHandler(BALANCE).getClass();
        assertEquals(BalanceOperationHandler.class, actual);
    }

    @Test
    public void operationStrategy_ValidSupplyHandler_Ok() {
        Class<? extends OperationHandler> actual =
                operationStrategy.getOperationHandler(SUPPLY).getClass();
        assertEquals(SupplyOperationHandler.class, actual);
    }

    @Test
    public void operationStrategy_ValidPurchaseHandler_Ok() {
        Class<? extends OperationHandler> actual =
                operationStrategy.getOperationHandler(PURCHASE).getClass();
        assertEquals(PurchaseOperationHandler.class, actual);
    }

    @Test
    public void operationStrategy_ValidReturnHandler_Ok() {
        Class<? extends OperationHandler> actual =
                operationStrategy.getOperationHandler(RETURN).getClass();
        assertEquals(ReturnOperationHandler.class, actual);
    }

    @Test (expected = RuntimeException.class)
    public void operationStrategy_NullOperation_NotOk() {
        operationStrategy.getOperationHandler(null).getClass();
    }
}
