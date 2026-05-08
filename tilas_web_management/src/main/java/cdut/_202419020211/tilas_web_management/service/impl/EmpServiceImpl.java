package cdut._202419020211.tilas_web_management.service.impl;

import cdut._202419020211.tilas_web_management.mapper.EmpExprMapper;
import cdut._202419020211.tilas_web_management.mapper.EmpMapper;
import cdut._202419020211.tilas_web_management.pojo.Emp;
import cdut._202419020211.tilas_web_management.pojo.EmpExpr;
import cdut._202419020211.tilas_web_management.pojo.PageResult;
import cdut._202419020211.tilas_web_management.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            empMapper.delete(id);
        }
    }

    @Override
    @Transactional
    public void save(Emp emp) {
        empMapper.insertEmp(emp);
        List<EmpExpr> exprList = emp.getExprExprList();
        if (exprList != null && !exprList.isEmpty()) {
            for (EmpExpr expr : exprList) {
                expr.setEmpId(emp.getId());
            }
            empExprMapper.batchInsert(exprList);
        }
    }

    @Override
    public Emp getName(Integer id) {
        Emp emp = empMapper.getById(id);
        emp.setExprExprList(empExprMapper.selectByEmpId(id));
        return emp;
    }

    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
    }

    @Override
    public PageResult page(Integer page, Integer size, String name, String gender, Date entryStart, Date entryEnd) {
        Long total = empMapper.count(name, gender, entryStart, entryEnd);
        List<Emp> rows = empMapper.page((page - 1) * size, size, name, gender, entryStart, entryEnd);
        return new PageResult(total, rows);
    }

    @Override
    public void updateExpr(EmpExpr expr) {
        empExprMapper.updateExpr(expr);
    }

    @Override
    public Object getExprExprList(Integer id) {
        return empExprMapper.selectByEmpId(id);
    }

    @Override
    public void saveEmpExpr(EmpExpr expr) {
        empExprMapper.saveEmpExpr(expr);
    }

    @Override
    public void deleteExprById(Integer id) {
        empExprMapper.deleteExprById(id);
    }


}