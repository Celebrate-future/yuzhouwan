package com.yuzhouwan.hacker.javaProhibited.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Copyright @ 2017 yuzhouwan.com
 * All right reserved.
 * Function: Serializable with No Serializable Attribution
 *
 * @author Benedict Jin
 * @since 2015/8/4
 */
public class SerializableWithNoSAttribution implements Serializable {

    private String id;
    private String name;
    private int age;

    private Infos infos;

    public SerializableWithNoSAttribution() {
    }

    public SerializableWithNoSAttribution(String id, String name, int age, Infos infos) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.infos = infos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Infos getInfos() {
        return infos;
    }

    public void setInfos(Infos infos) {
        this.infos = infos;
    }

    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.writeUTF(this.id);
        out.writeUTF(this.name);
        out.writeInt(this.age);
        out.writeUTF(this.infos.getTel());
    }

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.id = in.readUTF();
        this.name = in.readUTF();
        this.age = in.readInt();
        this.infos = new Infos(in.readUTF());
    }


    @Override
    public String toString() {
        return "SerializableWithNoSAttribution{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", infos=" + infos +
                '}';
    }
}

class Infos {

    private String tel;

    public Infos() {
    }

    public Infos(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Infos{" +
                "tel='" + tel + '\'' +
                '}';
    }
}

class MainThread {

    public static void main(String... args) {

        /**
         * Serialization of Object SerializableWithNoSAttribution{id='ASDF2014', name='asdf', age=20, infos=Infos{tel='123456'}} completed.
         * Deserialization of Object SerializableWithNoSAttribution{id='ASDF2014', name='asdf', age=20, infos=Infos{tel='123456'}} is completed.
         */
        Infos infos = new Infos("123456");
        SerializableWithNoSAttribution s = new SerializableWithNoSAttribution("ASDF2014", "asdf", 20, infos);

        SerializationConverter.serialize(s, "asdf");
        SerializableWithNoSAttribution sDe = SerializationConverter.deserialize("asdf", SerializableWithNoSAttribution.class);
    }

}