package cdut._202419020211.tilas_web_management.pojo;

public class EmpResult {
    int code;
    String msg;
    PageResult pageData;
    Object data;

    public EmpResult success(PageResult data) {
        EmpResult empResult = new EmpResult();
        this.pageData = data;
        this.msg = "success";
        this.code = 1;
        return empResult;
    }
    public EmpResult success() {
        EmpResult empResult = new EmpResult();
        this.msg = "success";
        this.code = 1;
        return empResult;
    }
    public EmpResult success(Object data) {
        EmpResult empResult = new EmpResult();
        this.msg = "success";
        this.code = 1;
        this.data = data;
        return empResult;
    }
    public EmpResult fail() {
        EmpResult empResult = new EmpResult();
        this.msg = "fail";
        this.code = 0;
        return empResult;
    }
}
