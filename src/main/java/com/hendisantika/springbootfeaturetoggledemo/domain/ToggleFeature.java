package com.hendisantika.springbootfeaturetoggledemo.domain;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-feature-toggle-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-30
 * Time: 07:14
 */
public class ToggleFeature {
    private String name;
    private boolean active;

    public ToggleFeature() {
    }

    public ToggleFeature(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
