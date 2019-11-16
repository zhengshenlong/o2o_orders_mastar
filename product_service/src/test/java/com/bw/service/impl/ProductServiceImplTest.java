package com.bw.service.impl;

import com.bw.service.ProductService;
import com.bw.vo.ProductVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testSpec(){
        ProductVo vo = new ProductVo();

        vo.setProductName("皮蛋");
    }
}