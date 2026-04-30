package cdut._202419020211.tilas_web_management;

import cdut._202419020211.tilas_web_management.mapper.DeptMapper;
import cdut._202419020211.tilas_web_management.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xmlunit.util.Mapper;

import java.util.List;

@SpringBootTest
class TilasWebManagementApplicationTests {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public  void findAll()
    {
        List<Dept> depts = deptMapper.findAll();
        System.out.println(depts);
    }

}
