package com.cll.mix.kafka.serializer;

import com.cll.mix.kafka.entity.StudentEntity;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;

/**
 *@ClassName : StudentSerializer
 *@Description : 学生实体序列化器
 *@Author : pc
 *@Date : 2019/7/6 9:36
 *@Version : 1.0
 **/
public class StudentSerializer implements Serializer<StudentEntity> {

    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    public byte[] serialize(String topic, StudentEntity data) {

        if(data == null){
            return null;
        }

        byte[] name, age;

        try{
            if(data.getName() != null){
                name = data.getName().getBytes("UTF-8");
            }else{
                name = new byte[0];
            }
            if(data.getAge() != null){
                age = data.getAge().toString().getBytes("UTF-8");
            }else{
                age = new byte[0];
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(4+4+name.length + age.length);
            byteBuffer.putInt(name.length);
            byteBuffer.put(name);
            byteBuffer.putInt(age.length);
            byteBuffer.put(age);
            return byteBuffer.array();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return new byte[0];
    }

    public void close() {

    }
}
