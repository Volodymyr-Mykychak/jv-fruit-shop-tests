package core.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.SupplyOperationHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SupplyOperationHandlerTest {
    private SupplyOperationHandler supplyOperationHandler;

    @Before
    public void setUp() {
        supplyOperationHandler = new SupplyOperationHandler();
        Storage.storageFruits.put("banana", 20);
    }

    @Test
    public void supplyOperationHandler_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction("banana",20);
        supplyOperationHandler.handle(fruitTransaction);
        int expected = 40;
        int actual = Storage.storageFruits.get("banana");
        assertEquals(expected, actual);
    }
}
