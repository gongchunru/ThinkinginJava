package com.java.chapter14.typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo.pets
 * @date 16/3/23 17:25
 *
 * 通过该方法来创建不同类型的宠物, 为了适应多种不同的实现,将其定义为抽象类
 */
public abstract class PetCreator {
    private Random rand = new Random(47);
    //The List of the different types of Pet to create;
    public abstract List<Class<? extends  Pet>> types();
    public Pet randomPet(){
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        }catch (InstantiationException e){
            throw  new RuntimeException(e);
        }catch (IllegalAccessException  e){
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size){
        Pet[] result = new Pet[size];
        for (int i=0;i<size;i++)
            result[i] = randomPet();
        return result;
    }
    public ArrayList<Pet> arrayList(int size){
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));

        return result;
    }

}
