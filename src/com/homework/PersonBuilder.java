package com.homework;

public class PersonBuilder {

  private String name;
  private String surname;
  private int age;
  private String address;

  public PersonBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public PersonBuilder setSurname(String surname) {
    this.surname = surname;
    return this;
  }

  public PersonBuilder setAge(int age) {
    if (age <= 0) {
      throw new IllegalArgumentException("Возраст не может быть меньше или равен 0");
    } else {
      this.age = age;
      return this;
    }
  }

  public PersonBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public Person build() {
    if (surname == null || name == null) {
      throw new IllegalStateException("Не хватает обязательных полей!");
    } else {
      Person person;
      if (age != 0) {
        person = new Person(name, surname, age);
      } else {
        person = new Person(name, surname);
      }
      if (!address.isEmpty()) {
        person.setAddress(address);
      }
      return person;
    }
  }
}
