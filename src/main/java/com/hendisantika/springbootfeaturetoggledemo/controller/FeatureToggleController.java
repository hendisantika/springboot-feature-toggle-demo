package com.hendisantika.springbootfeaturetoggledemo.controller;

import com.hendisantika.springbootfeaturetoggledemo.domain.MyFeatures;
import com.hendisantika.springbootfeaturetoggledemo.domain.ToggleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.togglz.core.context.FeatureContext;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.FeatureState;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-feature-toggle-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-30
 * Time: 07:16
 */

@RestController
public class FeatureToggleController {
    @Autowired
    private FeatureManager manager;

    @RequestMapping(value = "/feature/{name}", method = RequestMethod.POST)
    public ResponseEntity<ToggleFeature> setFeatureStatus(@PathVariable String name,
                                                          @RequestBody ToggleFeature resource) {
        FeatureContext.getFeatureManager()
                .setFeatureState(new FeatureState(MyFeatures.valueOf(name), resource.isActive()));
        return ResponseEntity.ok(new ToggleFeature(name, MyFeatures.valueOf(name).isActive()));
    }
}
