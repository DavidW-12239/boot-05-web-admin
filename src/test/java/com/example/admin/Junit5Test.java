package com.example.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Junit5Test {

    static int num = 1;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @DisplayName("测试前置条件")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(false, "not true");
        System.out.println("this is true");
    }

    @DisplayName("Assertions")
    @Test
    void testSimpleAssertions(){
        int cal = cal(1,2);
        assertEquals(cal, 3,"print failed");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1, obj2, "not equals");
    }

    int cal(int i, int j){
        return i+j;
    }

    @DisplayName("组合断言")
    @Test
    void testAll(){
        assertAll("test",
                ()->assertTrue(true && true,"not true"),
                ()->assertEquals(1,2, "not equals"));
    }

    @DisplayName("异常断言")
    @Test
    void testException(){
        //出现异常才不报错，正常运行就报错并打印message
        assertThrows(ArithmeticException.class, ()-> {int i=10/2;}, "居然正常");
    }

    @DisplayName("快速失败")
    @Test
    void testFail(){
        //出现异常才不报错，正常运行就报错并打印message
        int i = 99999;
        if(i == 99999){
            fail("失败哦");
        }
    }

    @DisplayName("测试displayName注解")
    @Test
    void test1(){
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @RepeatedTest(5)
    @Test
    void test3(){
        System.out.println("我测试了几次：" + num);
        num += 1;
    }

    @Disabled
    @Test
    void disabledTest(){
        System.out.println("被禁用了");
    }

    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)//超出时间报错
    @Test
    void timeOutTest() throws InterruptedException {
        Thread.sleep(90);
    }

    @Test
    void test2(){
        System.out.println(2);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("start test");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("finish test");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("the very beginning");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("the very end");
    }
}
