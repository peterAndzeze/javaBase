package com.customer.nashornjs;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * jdk1.8提供了js引擎
 */
public class JsNashorn {
    /**
     * 执行js 函数
     */
    public void executorJsFunction(){
        ScriptEngineManager jsManager=new ScriptEngineManager();
        ScriptEngine scriptEngine=jsManager.getEngineByName("JavaScript");
        try {
            Object value=scriptEngine.eval("function count(){return 2;}; count()+1");
            System.out.println("js 运算结果："+value);

            scriptEngine.put("name","张三");
            System.out.println(scriptEngine.get("name"));
            //不能搞 哈哈 异常
           // Object alert=scriptEngine.eval("function msg(){alert(1);}; msg()");
            //System.out.println(alert);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
