package cdut._202419020211.tilas_web_management.pojo;

public class EmpResult {
    int code;
    String msg;
    PageResult data;

    public EmpResult success(PageResult data) {
        EmpResult empResult = new EmpResult();
        this.data = data;
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
    public EmpResult fail() {
        EmpResult empResult = new EmpResult();
        this.msg = "fail";
        this.code = 0;
        return empResult;
    }
}
