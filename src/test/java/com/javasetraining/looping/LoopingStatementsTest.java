package com.javasetraining.looping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.systechafrica.looping.LoopingStatements;

public class LoopingStatementsTest {
    
    LoopingStatements app = new LoopingStatements();

    @Test

    public void test_number_in_range_one_fifty(){
        int search = app.search(10);

        Assertions.assertEquals(10, search);
    }


}
