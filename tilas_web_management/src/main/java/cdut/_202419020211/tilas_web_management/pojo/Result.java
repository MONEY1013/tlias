package cdut._202419020211.tilas_web_management.pojo;

import lombok.Data;

import java.util.List;


@Data
public class Result {
    private int code;  // 状态码
    private String message;  //错误信息
    private Object data;  // 数据
    private List<Object> dataList;

    // 成功,无数据
    public static Result success(){
        Result result = new Result();
        result.code = 1;  //按照接口定义，1表示成功，0表示失败
        result.message = "success";
        return result;
    }
    // 成功,有数据
    public static Result success(Object object){
        Result result = new Result();
        result.data = object;
        result.code = 1;  //按照接口定义，1表示成功，0表示失败
        result.message = "success";
        return result;
    }
    // 成功,有数据
    public static Result success(List<Object> list){
        Result result = new Result();
        result.dataList = list;
        result.code = 1;  //按照接口定义，1表示成功，0表示失败
        result.message = "success";
        return result;
    }
    // 失败,无数据
    public static Result error(String message){
        Result result = new Result();
        result.code = 0;  //按照接口定义，1表示成功，0表示失败
        result.message = message;
        return result;
    }

}
