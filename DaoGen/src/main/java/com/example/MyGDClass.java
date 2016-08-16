package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyGDClass {
    public static void main(String args[]) throws Exception {
        //创建一个用于添加实体（Entity）的模式（schema）对象
        Schema schema = new Schema(1, "com.example.hah");
        //一个实体类 就关联到数据库中的一张表中，此处的表名为User
        Entity userBean = schema.addEntity("User");
        //添加字段
        userBean.addIdProperty();
        userBean.addStringProperty("number");
        userBean.addStringProperty("password");

        new DaoGenerator().generateAll(schema, "app/src/main/java-gen");
    }
}
