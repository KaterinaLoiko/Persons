package com.homework;

import java.util.OptionalInt;

public class Person {

  protected final String name;
  protected final String surname;
  protected int age;
  protected String address;

  public Person(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public Person(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public boolean hasAge() {
    return getAge().isPresent();
  }

  public boolean hasAddress() {
    return !getAddress().isEmpty();
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public OptionalInt getAge() {
    if (age == 0) {
      return OptionalInt.empty();
    } else {
      return OptionalInt.of(age);
    }
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void happyBirthday() {
    if (hasAge()) {
      age = age + 1;
    }
  }

  @Override
  public String toString() {
    String resultString = "Имя: " + getName() + "\nФамилия: " + getSurname();
    if (hasAge()) {
      resultString = resultString + "\nВозраст: " + getAge().getAsInt();
    }
    if (hasAddress()) {
      resultString = resultString + "\nМесто жительства: " + getAddress();
    }
    return resultString;
  }

  @Override
  public int hashCode() {
    return getName().hashCode() * getSurname().hashCode() + getAddress().hashCode();
  }

  public PersonBuilder newChildBuilder() {
    return new PersonBuilder()
        .setSurname(getSurname())
        .setAddress(getAddress());
  }
}
