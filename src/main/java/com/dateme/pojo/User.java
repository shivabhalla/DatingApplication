package com.dateme.pojo;

import com.dateme.enums.Gender;
import com.dateme.enums.Status;
import com.dateme.spi.Filter;
import com.sun.tools.javac.jvm.Gen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;

/**
 * Created by shiva.b on 16/06/18.
 */
@Getter
public class User {
  private String id;
  private String name;
  private Location location;
  private List<Filter> filters;
  private Gender gender;
  private Status status;
  private Set<String> hobbies;

  private User(String id, String name, Location location, List<Filter> filters,
               Set<String> hobbies, Gender gender, Status status) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.filters = filters;
    this.hobbies = hobbies;
    this.gender = gender;
    this.status = status;
  }

  public static class UserBuilder {
    private String id;
    private String name;
    private Location location;
    private List<Filter> filters = new ArrayList<Filter>();
    private Set<String> hobbies = new HashSet<String>();
    private Gender gender;
    private Status status;

    UserBuilder() {
    }

    public UserBuilder id(String id) {
      this.id = id;
      return this;
    }

    public UserBuilder name(String name) {
      this.name = name;
      return this;
    }

    public UserBuilder location(Location location) {
      this.location = location;
      return this;
    }

    public UserBuilder gender(Gender gender) {
      this.gender = gender;
      return this;
    }

    public UserBuilder status(Status status) {
      this.status = status;
      return this;
    }

    public UserBuilder addFilter(Filter filter) {
      this.filters.add(filter);
      return this;
    }

    public UserBuilder addHobby(String hobby) {
      this.hobbies.add(hobby);
      return this;
    }

    public User build() {
      return new User(id, name, location, filters, hobbies, gender, status);
    }
  }
}
