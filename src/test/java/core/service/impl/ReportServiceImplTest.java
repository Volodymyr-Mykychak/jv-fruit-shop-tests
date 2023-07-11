package core.service.impl;

import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.ReportServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ReportServiceImplTest {
    private String expected;
    private ReportService reportService;
    private Map<String, Integer> map;

    @Before
    public void setUp() {
        reportService = new ReportServiceImpl();
        map = new HashMap<>();
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator() + "apple,90" + System.lineSeparator();
    }

    @Test
    public void reportService_CreateReport_Ok() {
        map.put("banana", 152);
        map.put("apple", 90);
        String actual = reportService.getReport(map);
        assertEquals(expected, actual);
    }

    @Test
    public void reportService_isEmptyStorage_Ok() {
        String expectedTitle = "fruit,quantity" + System.lineSeparator();
        String actual = reportService.getReport(map);
        assertEquals(expectedTitle, actual);
    }
}
