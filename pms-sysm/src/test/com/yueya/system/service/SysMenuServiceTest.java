package com.yueya.system.service;

import com.yueya.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SysMenuServiceTest extends BaseTest {
    @Autowired
    SysMenuService menuService;

    @Test
    public void testDelete(){
        menuService.delete("2");
    }

    @Test
    public void testStream() {
        List<String> list = new ArrayList<>();
        list.add("aad:ad,dasd:dd,asd:aaaaa");
        list.add("aa9d:ad,dalsd:dd,ajsd:aamka,");
        List<String> bb = list.stream()
                .flatMap(r -> Arrays.stream(r.split(",")))
                .collect(Collectors.toList());
        bb.stream().forEach(r -> System.out.println(r));
        assertEquals(bb.size(),6);
    }

}
