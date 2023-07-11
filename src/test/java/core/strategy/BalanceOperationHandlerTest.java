package core.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.BalanceOperationHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalanceOperationHandlerTest {
    private BalanceOperationHandler balanceOperationHandler;

    @Before
    public void setUp() {
        balanceOperationHandler = new BalanceOperationHandler();
    }

    @Test
    public void balanceOperation_BalanceValidTransaction_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction("banana", 20);
        balanceOperationHandler.handle(fruitTransaction);
        int expected = 20;
        int actual = Storage.storageFruits.get("banana");
        assertEquals(expected, actual);
    }
}
